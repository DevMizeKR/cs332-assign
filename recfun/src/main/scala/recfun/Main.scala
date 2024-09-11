package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println()
    println("Parentheses Balancing")
    println(balance("()()t((e()s((t())".toList))
    println(balance("()()()()()()asdf(())((()()))".toList))
    
    println()
    println("Counting Change")
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0) 1
    else if (c == r) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def checkBalance(chars: List[Char], count: Int) : Boolean = {
      if (count < 0) false
      else if (chars.isEmpty && count == 0) true
      else if (chars.isEmpty && count != 0) false
      else {
        val newCount = chars.head match {
          case '(' => count + 1
          case ')' => count - 1
          case _ => count
        }
        checkBalance(chars.tail, newCount)
      }
    }
    checkBalance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
