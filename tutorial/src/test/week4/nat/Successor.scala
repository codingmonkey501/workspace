package test.week4.nat
import test.week4.nat.Natural



class Successor(n:Natural) extends Natural{
  
    override def isZero:scala.Boolean = false
  	override def predecessor:Natural = n
  	override def + (that:Natural):Natural = new Successor(n + that)
  	override def - (that:Natural):Natural = if (n.isZero) n else n - that.predecessor

}