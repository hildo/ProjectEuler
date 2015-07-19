/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

/**
 * Using logic from http://www.mathblog.dk/project-euler-28-sum-diagonals-spiral/
 */
object Problem028 {

  def cornerSum(ring:Int): Double = {
    ring match {
      case 0 => 1
      case _ => (((4 * Math.pow((2 * ring + 1), 2)) - (12 * ring)) + cornerSum(ring - 1))
    }
  }
  
  // Can't get this to work, even thought it's supposed to
  def cornerSumPoly(ring: Int): Double = ((16 / 3) * Math.pow(ring, 3)) + (10 * Math.pow(ring, 2)) + ((26 / 3) * ring) + 1
//  def cornerSumPoly(ring: Int): Int = (16 / (3 * Math.pow(ring, 3))) + (10 * Math.pow(ring, 2)) + (26 / (3 * ring)) + 1
    
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println(cornerSum(500) toInt)
    println(cornerSumPoly(500) toInt)
  }

}
