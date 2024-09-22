package funsets

object Main extends App {
  import FunSets._
  
  val condition : Int => Boolean = (x => x < 2)
  val multipleTwo : Int => Int = (x => 2 * x)
  
  val baseSet = union(singletonSet(1), singletonSet(2))
  val unionSet = union(baseSet, singletonSet(3))
  val interSet = intersect(unionSet, baseSet)
  val diffSet = diff(unionSet, baseSet)
  val filtedSet = filter(unionSet, condition)
  val multipledSet = map(unionSet, multipleTwo)
  
  println("1. Test singletonSet / contains Function")
  println(contains(singletonSet(1), 1))
  println()
  
  println("2. Test union / interSet / diff / filter Function")
  println(FunSets.toString(unionSet))
  println(FunSets.toString(interSet))
  println(FunSets.toString(diffSet))
  println(FunSets.toString(filtedSet))
  println()
  
  println("3. Test forall / exists / map Function")
  println(forall(unionSet, condition))
  println(exists(unionSet, condition))
  println(FunSets.toString(multipledSet))
  println()
}
