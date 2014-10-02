/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem018 {

  val valueArrays:Array[Array[Int]] = {
    io.Source.fromInputStream(getClass.getResourceAsStream("/smallTriangle.txt")).getLines.toArray.map(_.split(" ").map(_.toInt))
  }

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    for (idx <- valueArrays.length - 2 to 0 by -1) {
      for (innerIdx <- 0 to valueArrays(idx).length - 1) {
        var currentValue = valueArrays(idx).apply(innerIdx)
        valueArrays(idx).update(innerIdx, (currentValue + scala.math.max(
              valueArrays(idx + 1).apply(innerIdx), 
              valueArrays(idx + 1).apply(innerIdx+1))))
      }
    }
    println(valueArrays(0).apply(0))
  }

}
