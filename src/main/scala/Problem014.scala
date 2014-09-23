/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

object Problem014 {

  def evenFn(n: BigInt): BigInt = n / 2
  def oddFn(n: BigInt): BigInt = (BigInt(3) * n) + 1

  def calcNext(n: BigInt): BigInt = {
    if (n == 1) BigInt(1)
    else if (n % 2 == 0) evenFn(n)
    else oddFn(n)
  }

  val stepMap: scala.collection.mutable.Map[BigInt, Int] = scala.collection.mutable.Map()

  def calcSteps(n: Int): BigInt = {
    def inner(n1: BigInt, stepCount: Int): Int = {
      if (stepMap.get(n1).isDefined) stepCount + stepMap.get(n1).get
      else if (n1 == 1) stepCount + 1
      else inner(calcNext(n1), stepCount + 1)
    }
    val steps = inner(n, 0)
    stepMap += ((BigInt(n), steps))
    steps
  }

  def getMax(acc: BigInt, idx: Int) = {
    val steps = calcSteps(idx)
    if (steps > acc) {
      println("new max at starting number " +  idx + ": " + steps)
      steps
    } else acc
  }

  def max() = {
    List.range(1,1000000).foldLeft(BigInt(0))((acc,i)=> getMax(acc, i))
  }

}
