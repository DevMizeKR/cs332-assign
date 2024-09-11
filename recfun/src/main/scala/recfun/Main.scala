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
    println(countChange(5, List(1, 2, 5)))
    println(countChange(5, List(1, 2, 3, 4, 5)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0) 1 // First Element
    else if (c == r) 1 // Outside Elements
    else pascal(c - 1, r - 1) + pascal(c, r - 1) // Calculate Middle Elements
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def checkBalance(chars: List[Char], count: Int) : Boolean = {
      if (count < 0) false // Close Parentheses came first
      else if (chars.isEmpty && count == 0) true // Parentheses Match
      else if (chars.isEmpty && count != 0) false // Parentheses Doesn't Match
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
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 || coins.isEmpty) 0 // Impossible Cases
    else if (money == 0) 1 // Basic Case
    else countChange(money - coins.head, coins) + countChange(money, coins.tail) // Divide whether to use first coin
  }
}
