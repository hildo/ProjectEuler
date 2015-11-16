/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

// pretty much copied from http://pelangchallenge.blogspot.com.au/2013/09/problem-43-scala.html
// I kept thinking while loop, and couldn't visualise this code'
object Problem044 {

//  def pentagonalNumber(n: Int) : Stream[Int] = ((n * (3*n - 1)) / 2) #:: pentagonalNumber(n + 1) 
//  val pentNums = pentagonalNumber(1)
  
  def min(x : Int, y : Int) : Int = if (x < y) x else y
 
  def isPent(p : Int) : Boolean = {
    val root =  math.sqrt(24 * p + 1).asInstanceOf[Int]
    return (root * root == 24*p + 1) && ((root + 1)% 6 == 0)
  }
 
  def pent(n : Int) : Int = n * (3 * n - 1) / 2
 
  def main(args: Array[String]) {
    var D = 1000000000
    var p1 = 0
    var p2 = 0
    for (i <- 1 to 10000) {
      for (j <- (i+1) to 10000) {
        p1 = pent(i)
        p2 = pent(j)
        if (isPent(p1 + p2) && isPent(p2 - p1)) {
          D = min(D, p2 - p1)
        }
      }
    }
    println(D)
  }
}
