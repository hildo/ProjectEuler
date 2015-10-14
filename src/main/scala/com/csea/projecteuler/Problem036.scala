/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem036 {

  def isEven(input: Int) = input % 2 == 0
  
  def constructStrings(input: String) = isEven(input.length) match {
    case true => input.splitAt(input.length / 2)
    case _ => {
        val idx = (input.length -1) / 2
        (input.substring(0, idx + 1), input.substring(idx))
    }
  }
  
  def isDoubleBasePalindrome(input: Int) = {
    val tuple = constructStrings(input.toBinaryString)
    if (tuple._1 == tuple._2.reverse) {
      val tuple2 = constructStrings(input.toString)
      tuple2._1 == tuple2._2.reverse
    } else {
      false
    }
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val values = for (idx <- List.range(1, 1000000); if isDoubleBasePalindrome(idx)) yield idx
    Console.println(values.sum)
    // Answer is 872187
  }

}
