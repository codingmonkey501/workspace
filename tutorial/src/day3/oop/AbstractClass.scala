package day3.oop

object AbastractClass extends App {
  
  var date1 = new Date(1996, 9, 1)
  var date2 = new Date(1996, 9, 1)
  var i:Int = 1
  println(date1 < date2)
  println(date1 == date2)
  println(date1 <= date2)
  println(date1 >= date2)
  println(date1 > date2)
  println(date1 < i)
  
  /**
   * 1. "trait" key word like abstract class
   * 2. system operator can be implemented
   * 3. abstract method
   * 4. "this" key word
   */
  trait Ord {
    def <(that: Any): Boolean
    def <=(that: Any): Boolean = (this < that) || (this == that)
    def >(that: Any): Boolean = !(this <= that)
    def >=(that: Any): Boolean = !(this < that)
  }

  /**
   * 2. override equals
   * 3. implicit return
   * 4. implement method inside trait
   * 5. throw exception
   */
  class Date(y: Int, m: Int, d: Int) extends Ord {
    def year = y
    def month = m
    def day = d
    
    override def toString(): String = year + "-" + month + "-" + day

	override def equals(that: Any): Boolean = that.isInstanceOf[Date] && {
    	val o = that.asInstanceOf[Date]
	    o.day == day && o.month == month && o.year == year
	}
	
    def <(that: Any): Boolean = {
	  if (!that.isInstanceOf[Date]) 
	    error("cannot compare " + that + " and a Date")
	  val o = that.asInstanceOf[Date]
	  (year < o.year) || (year == o.year && (month < o.month || (month == o.month && day < o.day)))
	}
  }
}