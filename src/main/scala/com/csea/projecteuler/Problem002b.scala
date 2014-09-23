/*
 * http://projecteuler.net/problem=2
 *
 * This page was handy
 * http://www.codecommit.com/blog/scala/infinite-lists-for-the-finitely-patient
 *
 * This was lifted from
 * http://www.scala-blogs.org/2007/12/project-euler-fun-in-scala.html
 */

package com.csea.projecteuler

object Problem002b {

  lazy val fib: Stream[Int] = Stream.cons(0, Stream.cons(1, fib.zip(fib.tail) map { case (c1,c2) => c1 + c2 } ))

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println("sum is " + fib.filter(_ % 2 == 0).takeWhile(_ <= 4000000).sum)
  }

}
