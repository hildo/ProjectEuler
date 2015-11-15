/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem043 {
  
  val tens = BigInt(10).pow(1)
  val hundreds = BigInt(10).pow(2)
  val thousands = BigInt(10).pow(3)
  val tenthousands = BigInt(10).pow(4)
  val hundredthousands = BigInt(10).pow(5)
  val millions = BigInt(10).pow(6)
  val tenmillions = BigInt(10).pow(7)
  val hundredmillions = BigInt(10).pow(8)
  val billions = BigInt(10).pow(9)
  
  val digits = List.range(0, 10)
  
  def isPandigital(number:BigInt) = {
    val digits = number.toString.toList.map(c => c.asDigit)
    (digits.contains(0)) && (digits.max + 1 == digits.length) && (digits.distinct.length == digits.length)
  }

  def buildSubValue(hundredsDigit: Int, tensDigit: Int, onesDigit: Int) = 
      (hundredsDigit * hundreds) + (tensDigit * tens) + onesDigit
  
  def buildPandigitals = {
      for (digitPerm <- digits.permutations;
             if (digitPerm.apply(0) > 0);
             if ((buildSubValue(digitPerm.apply(1), digitPerm.apply(2), digitPerm.apply(3)) % 2) == 0);
             if ((buildSubValue(digitPerm.apply(2), digitPerm.apply(3), digitPerm.apply(4)) % 3) == 0);
             if ((buildSubValue(digitPerm.apply(3), digitPerm.apply(4), digitPerm.apply(5)) % 5) == 0);
             if ((buildSubValue(digitPerm.apply(4), digitPerm.apply(5), digitPerm.apply(6)) % 7) == 0);
             if ((buildSubValue(digitPerm.apply(5), digitPerm.apply(6), digitPerm.apply(7)) % 11) == 0);
             if ((buildSubValue(digitPerm.apply(6), digitPerm.apply(7), digitPerm.apply(8)) % 13) == 0);
             if ((buildSubValue(digitPerm.apply(7), digitPerm.apply(8), digitPerm.apply(9)) % 17) == 0);
             val candidate = (digitPerm.apply(0) * billions)
                                     + (digitPerm.apply(1) * hundredmillions)
                                     + (digitPerm.apply(2) * tenmillions)
                                     + (digitPerm.apply(3) * millions)
                                     + (digitPerm.apply(4) * hundredthousands)
                                     + (digitPerm.apply(5) * tenthousands)
                                     + (digitPerm.apply(6) * thousands)
                                     + (digitPerm.apply(7) * hundreds)
                                     + (digitPerm.apply(8) * tens)
                                     + digitPerm.apply(9);
             if isPandigital(candidate)
      ) yield candidate
  }
  

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println(buildPandigitals.sum)
  }

}
