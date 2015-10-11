/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem032 {

  def isPandigital(number:String) = number.sorted == "123456789"
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val products = for (multiplicand <- List.range(1,10000); 
                                multiplier <- List.range(multiplicand,10000);
                                val product = multiplicand * multiplier;
                                val asString = multiplicand.toString + multiplier.toString + product.toString
                                if (asString.length == 9)
                                if (isPandigital(asString))
                                ) yield product

      // answer is 45228
     Console.println(products.distinct.sum)
  }
                      
}
