/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


object Problem006 {

  def diff(input: List[Int]): Long = {
    def sumOfSquares: Long = input.map(x => x * x).sum
    def squareOfSums: Long = input.sum * input.sum
    squareOfSums - sumOfSquares
  }
}
