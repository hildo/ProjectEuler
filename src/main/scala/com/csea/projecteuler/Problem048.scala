/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem048 {

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val nums = for (i <- 1 to 1000) yield BigInt(i).pow(i)
    println(nums.sum) // 9110846700
  }

}
