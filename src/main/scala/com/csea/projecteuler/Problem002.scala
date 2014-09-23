/*
 * http://projecteuler.net/problem=2
 *
 */

package com.csea.projecteuler

object Problem002 {

  def fib( n: Int): Int = n match {
    case 0 | 1 => n
    case _ => fib(n-1) + fib( n-2)
  }



  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    var sum:Int=0
    var i:Int = 1
    var fibNum=fib(i)
    while( fibNum < 4000000) {
      if (fibNum %2 == 0) {
        sum += fibNum
      }
      i = i + 1
      fibNum=fib(i)
    }
    Console.println("sum is " + sum)
  }

}
