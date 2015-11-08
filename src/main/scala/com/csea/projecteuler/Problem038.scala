/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem038 {

  def isNineDigitPandigital(number:Int) = {
    val digits = number.toString.toList.map(c => c.asDigit)
    !(digits.contains(0)) && (digits.max == digits.length) && (digits.distinct.length == digits.length) && (digits.length == 9)
  }

  def concatProduct(number: Int, multipliers: List[Int]): Int = {
    val asString = multipliers.map(i => i * number).map(j => j.toString).mkString
    if (asString.length == 9) {
      asString.toInt
    } else 
      0
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    // Used logic from http://www.mathblog.dk/project-euler-38-pandigital-multiplying-fixed-number/
    val candidates = for (num <- 9000 to 10000;
                                        rangeLimit <- 2 to 3) yield concatProduct(num, List.range(1, rangeLimit))
    val pandigitals = candidates.filter(c => isNineDigitPandigital(c))
    pandigitals.foreach(c => Console.println(c))
    Console.println(pandigitals.max)
  }

}
