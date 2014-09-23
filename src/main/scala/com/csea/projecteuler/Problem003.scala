/*
 * http://projecteuler.net/problem=3
 *
 * From http://www.scala-blogs.org/2007/12/project-euler-fun-in-scala.html
 */

package com.csea.projecteuler

object Problem003 {

  lazy val naturals: Stream[Int] = Stream.cons(1, naturals.map(_ + 1))

//  var theNum = 600851475143L
  var theNum = 13195

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    // original code
    // naturals.drop(1).dropWhile(n => {while(theNum % n == 0) {theNum /= n}; theNum > 1})
    println(naturals.drop(1).dropWhile(
        n => {
          println("n is " + n)
          while(theNum % n == 0) {
            theNum /= n
            println("\tsetting theNum to " + theNum)
          }
          theNum > 1
        }).head)
  }

}
