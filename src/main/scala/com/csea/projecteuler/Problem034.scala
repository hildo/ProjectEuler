/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem034 {

  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n-1)
  
  def digitFactorial(n: Int): BigInt = n.toString.toList.map(c => c.asDigit).map(i => factorial(i)).sum
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val digitFactorials = for (i <- List.range(10, 100000); if (i == digitFactorial(i))) yield i
    Console.println(digitFactorials.sum)
    // answer is 40730
  }

}
