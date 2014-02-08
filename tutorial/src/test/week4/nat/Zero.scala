package test.week4.nat

import test.week4.nat.Natural

object Zero extends Natural{
  	override def isZero:scala.Boolean = true
  	override def predecessor:Natural = throw new Error("0.predecessor")
  	override def + (that:Natural):Natural = that
  	override def - (that:Natural):Natural = if(that.isZero) that else throw new Error("negative")
}