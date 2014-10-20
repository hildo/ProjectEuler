/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem024 {

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println("0123456789".permutations.drop(999999).next)
  }

}
