/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem023 {

  // Can this be optimised (see http://codereview.stackexchange.com/questions/39946/optimizing-solution-for-project-euler-problem-23-non-abundant-sums)
  def divisors(n: Int): List[Int] = for (i <- List.range(1, n-1) if n % i == 0) yield i

  def isAbundant(n: Int): Boolean = divisors(n).sum > n

  val abundantNumbers = for (i <- List.range(1, 28123) if isAbundant(i)) yield i

  // This is running too long
  def isSumOfTwoAbundantNumbers(n: Int): Boolean = {
    // Find the abundant numbers that are less than n.
    // See if they can be used to 
    println("Checking " + n)
    if (n < 24) {
      false
    } else {
      var index = 0
      var abNum = abundantNumbers(index)
      var keepLooking = true
      while (keepLooking && (abNum < n)) {
        keepLooking = !isAbundant(n - abNum)
        if (keepLooking) {
          index = index + 1
          abNum = abundantNumbers(index)
        }
      }
      !keepLooking
    }
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val fromNonAbundantSums = for (i <- List.range(1, 28123) if !isSumOfTwoAbundantNumbers(i)) yield i
    // http://www.mathblog.dk/project-euler-23-find-positive-integers-not-sum-of-abundant-numbers/
    println(fromNonAbundantSums.toString)
  }

}
