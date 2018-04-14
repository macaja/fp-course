package course.classes

object EitherMonad {

  trait MessageError{val error: String}
  case class Message(text: String,sha: Int)
  object Message{
    def apply(text: String, sha: Int): Either[MessageError,Message] = { //Smart constructor
      for{
        s <- validateSha(sha)
        t <- validateText(text)
      }yield new Message(t,s)
    }
  }
  private def validateSha(sha:Int): Either[MessageError,Int] = ???
  private def validateText(text: String): Either[MessageError,String] = ???

}
