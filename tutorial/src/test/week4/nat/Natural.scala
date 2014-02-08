package test.week4.nat

import test.week4.nat.Successor

abstract class Natural{
  	def isZero: Boolean
  	def predecessor: Natural
  	def successor:Natural = new Successor(this)
  	def + (that:Natural): Natural
  	def - (that:Natural): Natural
  }