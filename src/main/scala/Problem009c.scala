/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

object Problem009c {

  def findTriple(): (Int, Int, Int) = {
    val list = for {
      a <- 1 to 500
      b <- a to 500
      c = 1000 - b - a
      if {
        (a * a) + (b * b) == (c * c)
      }
    }yield (a,b,c)
    list.apply(0)
  }

  def findProduct(): Int = {
    findTriple() match {
      case (a, b, c) => a * b * c
    }
  }
}
