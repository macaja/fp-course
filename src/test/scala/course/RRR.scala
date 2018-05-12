package course

import cats.data.EitherT
import monix.cats.monixToCatsMonad
import monix.eval.Task
import monix.execution.Scheduler
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{AsyncWordSpec, Matchers}

import scala.concurrent.duration.{FiniteDuration, _}
import scala.util.Failure

class RRR extends AsyncWordSpec with Matchers with ScalaFutures {

  implicit val scheduler: Scheduler = Scheduler.io()

  var r = 1

  private def retryBackoff(source: Task[Unit], firstDelay: FiniteDuration): Task[Unit] = {
    source.onErrorHandleWith {
      case _ => {
        println(s"retrying $r")
        r = r + 1
        retryBackoff(source, (firstDelay * 2).min(2.minute))
          .delayExecution(firstDelay)
      }
    }
  }

  "UCP" should {
    "r" in {
      def exec(): Task[Unit] = {
        val t = (for {
          a <- EitherT.right[Task,List[String], Int](Task.now(1))
          b <- EitherT.right[Task, List[String], Double](Task.fromTry(Failure(new Exception("fail to syndicate"))))
        } yield (a, b)).fold(
          e => {
            println(s"errors => ${e}")
            ()
          },
          v => {
            println(s"int => ${v._1}, double => ${v._2}")
            ()
          }
        )
        retryBackoff(t, 1.second)
      }
      whenReady(exec().runAsync) { r =>
        println(s"finish")
      }

      1 should be(1)
    }
  }

}