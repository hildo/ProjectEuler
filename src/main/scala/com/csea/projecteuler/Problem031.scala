/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem031 {

  def countChange(amount: Int, coins: List[Int]) = {
    val ways = Array.fill(amount + 1)(0)
    ways(0) = 1
    coins.foreach(coin =>
      for (j <- coin to amount)
        ways(j) = ways(j) + ways(j - coin))
    ways(amount)
  }
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val englishCurrency = List(1, 2, 5, 10, 20, 50, 100, 200)
    val ways = countChange(200, englishCurrency)
    Console.println(ways.toString)
  }

}
