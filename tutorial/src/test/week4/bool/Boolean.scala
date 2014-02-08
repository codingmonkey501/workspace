package test.week4.bool

abstract class Boolean{
  	def ifThenElse[T](t: => T, f: =>T):T
  	def unary_! :Boolean = ifThenElse(False, True)
  	def == (x: => Boolean):Boolean = ifThenElse(x, x.unary_!)
  	def < (x: => Boolean):Boolean = ifThenElse(False, x)
}

object False extends Boolean {
  override def ifThenElse[T](t: => T, f: => T): T = f
  override def toString = "False"
}

object True extends Boolean {
  override def ifThenElse[T](t: => T, f: => T): T = t
  override def toString = "True"
}


object Main {
  def main(args: Array[String]){
    
      var b:Boolean = True
	  var c:Boolean = False
	  var d:Boolean = True
	  !True
	  b == c
	  b == d
	  c < b
	  b < d
	  c < c
	  d < d
	  b < c
  }
}