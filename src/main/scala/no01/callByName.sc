
Seq(1,2,3)

def loop: Int = { println("loop"); loop }


// Call-by-value
def first(x: Int, y: Int): Int = x

//first(1, loop)



// Call-by-name
def first2(x: Int, y: => Int): Int = x

first2(1, loop)


//------------------------------------------------
// Call-by-value

class Logger {

  def debug(msg: String): Unit = {
    println(s"[debug]: $msg")
  }

  def isDebugEnabled: Boolean = true

}

val logger = new Logger


if (logger.isDebugEnabled) {
  logger.debug("test")
}


//------------------------------------------------
// Call-by-name

class Logger2 {

  def debug(msg: => String): Unit = {
    if (isDebugEnabled) {
      println(s"[debug]: $msg")
    }
  }

  def isDebugEnabled: Boolean = true

}

val logger2 = new Logger2

logger2.debug("hogehoge")




