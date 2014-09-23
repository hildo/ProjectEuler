/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

object Problem010b {
  def isPrime(n : Int) : Boolean = n == smallestDivisor(n)
  def smallestDivisor(n : Int) : Int = findDivisor(n, 2)
  def findDivisor(n : Int, testDivisor : Int) : Int = {
    if (square(testDivisor) > n)
      n
    else if (divides(testDivisor, n))
      testDivisor
    else
      findDivisor(n, testDivisor + 1)
  }

  def square(n : Int) : Int =  n * n
  def divides(d : Int, n : Int) : Boolean = (n % d) == 0

  def getSum() = {
    (2 until 2000000).filter(isPrime(_)).sum
  }
}
