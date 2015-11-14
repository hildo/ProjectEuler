/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem033 {

  /**
   * @param args the command line arguments
   * 
   * Using logic at http://www.mathblog.dk/project-euler-33-fractions-unorthodox-cancelling-method/
   */
  def main(args: Array[String]): Unit = {   
    val fractions = for (i <- 1 until 10;
           den <- 1 to i;
           nom <- 1 to den;
           if (nom < den);
           if ((nom * 10 + i) * den == nom * (i * 10 + den))
    ) yield (nom, den)
    Console.println(fractions)
    val nomProduct = fractions.map(_._1).product
    val denProduct = fractions.map(_._2).product
    
    val output = denProduct / Problem009b.gcd(nomProduct, denProduct)
    Console.println(output)
  }

}
