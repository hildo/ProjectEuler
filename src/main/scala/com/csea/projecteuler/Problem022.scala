/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem022 {

  val names = {
    io.Source.fromInputStream(getClass.getResourceAsStream("/p022_names.txt")).getLines.next.split(",").map(_.replaceAll("\"",""))
  }
  
  def alphabeticalValue(name: String): Int = name.foldLeft(0)((sum, c) => sum + c.toInt - 64)
  
  def main(args: Array[String]): Unit = {
    // should be 871198282
    println(names.sorted.zipWithIndex.map(tuple => (tuple._2 + 1)  * alphabeticalValue(tuple._1)).sum)
  }

}
