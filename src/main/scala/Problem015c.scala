/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

object Problem015c {

  def main(rows: Int) {
    println("Pascal's Triangle")
    for (row <- 0 to rows) {
      for (col <- 0 to row)
        print(pascal(row,col) + " ")
      println()
    }
  }

  val valueMap: scala.collection.mutable.Map[(Int, Int), BigInt] = scala.collection.mutable.Map()

  def pascal(r: Int, c: Int): BigInt = {
    val key = (r,c)
    val opt = valueMap.get(key)
    if (opt.isDefined) opt.get
    else {
      val rv = innerPascal(r,c)
      valueMap += (((r,c), rv))
      rv
    }
  }

  def innerPascal(r: Int, c: Int): BigInt = {
    if (r == 0 || r == 1 || c == 0 || r == c) 1
    else pascal(r-1,c-1) + pascal(r-1,c)
  }


  def factorial(n: Int): BigInt = if (n == 0) BigInt(1) else BigInt(n) * factorial(n-1)
  def binCoeff(n: Int, k: Int):BigInt  = factorial(n) / (factorial(k) * factorial(n-k))

  //Note answer is provided by both pascal(40,20) and binCoeff(40,20)
}
