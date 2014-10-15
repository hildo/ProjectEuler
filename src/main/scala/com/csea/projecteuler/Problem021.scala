/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem021 {
  def oldDivisors(n: Int) : List[Int] = for (i <- List.range(1, n-1) if n % i == 0) yield i
  
  def divisors1(n: Int): List[Int] = {
      var retVal = List(1)
      val largest = upperBound(n)
      for (i <- Range(2, largest)) {
        if (n % i == 0) {
          retVal = retVal :+ i
          retVal = retVal :+ (n / i)
        }
      }
      retVal
    }

    def divisors(n: Int): List[Int] = {
      List(1) ::: Range(2,upperBound(n)).flatMap(i => if (isDivisorOf(n, i)) { List(i, n/i)} else {List()} ).toList
    }
    
    def isDivisorOf(n:Int, div: Int): Boolean = {
      div match {
        case 1 => true
        case _ => n % div == 0
      }
    }

  def upperBound(n: Int) = {
    val largest = scala.math.sqrt(n).intValue
    if ((largest * largest) != n) {
      largest + 1
    } else {
      largest
    }
  }
  
  def amicableNumber(a: Int) = {
    val b = divisors(a).sum //d(a) = b
    val a2 = divisors(b).sum // d(b) = a
    ((a2 != b) && (a == a2))
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    // should be 31626
    println((for (i <- List.range(1, 9999) if amicableNumber(i)) yield i).sum)
  }

}
