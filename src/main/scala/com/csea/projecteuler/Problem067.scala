/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem067 {

  val valueArrays:Array[Array[Int]] = {
    io.Source.fromInputStream(getClass.getResourceAsStream("/p067_triangle.txt")).getLines.toArray.map(_.split(" ").map(_.toInt))
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    for (idx <- valueArrays.length - 2 to 0 by -1) {
      for (valWithIndex <- valueArrays(idx).zipWithIndex) {
        valueArrays(idx).update(valWithIndex._2,
          valWithIndex._1 + scala.math.max(
            valueArrays(idx + 1).apply(valWithIndex._2),
            valueArrays(idx + 1).apply(valWithIndex._2 + 1)))
      }
    }
    println(valueArrays(0).apply(0))
  }

}
