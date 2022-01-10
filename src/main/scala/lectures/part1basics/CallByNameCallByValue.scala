package lectures.part1basics

object CallByNameCallByValue extends App {
  def calledByName(x: Long): Unit = {
    println(s"Called by name 1 $x")
    Thread.sleep(100)
    println(s"Called by name 2 $x")
  }

  def calledByValue(x: => Long): Unit = {
    println(s"Called by value 1 $x")
    Thread.sleep(100)
    println(s"Called by value 2 $x")
  }

  calledByName(System.currentTimeMillis())
  calledByValue(System.currentTimeMillis())

  def infinite(): Int = infinite() + 1

  def printFirst(x: Int, y: => Int): Unit = println(x)

  //printFirst(infinite(), 34) //Throws StackOverflowError
  printFirst(34, infinite()) //Runs Fine as call to the function is not made
}
