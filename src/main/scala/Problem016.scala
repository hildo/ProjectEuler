/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

object Problem016 {

  def sum(powerOf: Int): Int = {
    BigInt(2).pow(powerOf).toString.map(_.asDigit).sum
  }
}
