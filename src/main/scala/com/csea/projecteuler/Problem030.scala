/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem030 {

  def isDigitSumOfPowers(value: Integer, power: Integer): Boolean = value.toString.map(_.asDigit).foldLeft(0)((b,a) => b + BigInt(a).pow(power).intValue) == value
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println(List.range(2, 1000000).filter(i => isDigitSumOfPowers(i, 5)).sum)
  }

}
