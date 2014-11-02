/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem029 {

  def main(args: Array[String]): Unit = {
    println(List.range(2, 101).flatMap(a => for (b <- 2 to 100) yield BigInt(a).pow(b)).distinct.sorted.size)
    // correct value is 9183
  }

}
