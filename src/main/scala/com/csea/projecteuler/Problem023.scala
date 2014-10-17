/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem023 {

    def divisors(n: Int): List[Int] = {
      var retVal = List(1)
      if (n > 2) {
        var largest = scala.math.sqrt(n).intValue
        if (largest * largest == n) {
          retVal = retVal :+ largest
        } else {
          largest = largest + 1
        }
        for (i <- 2 to largest) {
          if (n % i == 0) {
            retVal = retVal :+ i
            retVal = retVal :+ (n / i)
          }
        }
      }
      retVal.distinct
    }
    
  def isAbundant(n: Int): Boolean = divisors(n).sum > n

  val abundantNumbers = for (i <- List.range(1, 28123) if isAbundant(i)) yield i

  def isSumOfTwoAbundantNumbers(n: Int): Boolean = {
    if (n < 24) {
      false
    } else {
      !abundantNumbers.filter(x => x < n).find(y => isAbundant(n-y)).isEmpty
    }
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val fromNonAbundantSums = for (i <- List.range(1, 28123) if !isSumOfTwoAbundantNumbers(i)) yield i
    println(fromNonAbundantSums.sum)
  }

}
