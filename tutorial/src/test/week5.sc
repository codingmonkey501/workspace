package test

object week5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //pair
  val pair = ("answer", 42)                       //> pair  : (String, Int) = (answer,42)

  val (label, value) = pair                       //> label  : String = answer
                                                  //| value  : Int = 42

  //tuple

  //merge
  object mergesort {

    def msort(xs: List[Int]): List[Int] = {
      val n = xs.length / 2
      if (n == 0) xs
      else {

        def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

        val (fst, snd) = xs splitAt n
        merge(msort(fst), msort(snd))
      }
    }
  }

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  mergesort.msort(nums)                           //> res0: List[Int] = List(-4, 1, 2, 5, 7)

  //general merge sort
  object gmergesort {

    def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
      val n = xs.length / 2
      if (n == 0) xs
      else {

        def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

        val (fst, snd) = xs splitAt n
        merge(msort(fst)(lt), msort(snd)(lt))
      }
    }
  }

  gmergesort.msort(nums)((x: Int, y: Int) => x < y)
                                                  //> res1: List[Int] = List(-4, 1, 2, 5, 7)
  //implicit parameter
  gmergesort.msort(nums)((x, y) => x < y)         //> res2: List[Int] = List(-4, 1, 2, 5, 7)

  val fuits = List("apple", "pinapple", "orange", "banana")
                                                  //> fuits  : List[String] = List(apple, pinapple, orange, banana)

  gmergesort.msort(fuits)((x: String, y: String) => x.compareTo(y) < 0)
                                                  //> res3: List[String] = List(apple, banana, orange, pinapple)
  gmergesort.msort(fuits)((x, y) => x.compareTo(y) < 0)
                                                  //> res4: List[String] = List(apple, banana, orange, pinapple)

  //more general
  //general merge sort
  import scala.math.Ordering
  object mgmergesort {

    def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
      val n = xs.length / 2
      if (n == 0) xs
      else {

        def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (ord.lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

        val (fst, snd) = xs splitAt n
        merge(msort(fst)(ord), msort(snd)(ord))
      }
    }
  }

  mgmergesort.msort(fuits)                        //> res5: List[String] = List(apple, banana, orange, pinapple)

  //high order function
  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * factor :: scaleList(ys, factor)
  }                                               //> scaleList: (xs: List[Double], factor: Double)List[Double]

  def consiceScaleList(xs: List[Double], factor: Double) = xs map (x => x * factor)
                                                  //> consiceScaleList: (xs: List[Double], factor: Double)List[Double]

  val doubles = List(1.2, 2.3, -4.3)              //> doubles  : List[Double] = List(1.2, 2.3, -4.3)
  scaleList(doubles, 2)                           //> res6: List[Double] = List(2.4, 4.6, -8.6)
  consiceScaleList(doubles, 2)                    //> res7: List[Double] = List(2.4, 4.6, -8.6)

  def posElems(xs: List[Double]): List[Double] = xs match {
    case Nil => xs
    case y :: ys => if (y > 0) y :: posElems(ys) else posElems(ys)
  }                                               //> posElems: (xs: List[Double])List[Double]

  def concisePosElems(xs: List[Double]): List[Double] = xs filter (x => x > 0)
                                                  //> concisePosElems: (xs: List[Double])List[Double]
  posElems(doubles)                               //> res8: List[Double] = List(1.2, 2.3)
  concisePosElems(doubles)                        //> res9: List[Double] = List(1.2, 2.3)

  nums filter (x => x > 0)                        //> res10: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res11: List[Int] = List(-4)
  nums partition (x => x > 0)                     //> res12: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
  nums takeWhile (x => x > 0)                     //> res13: List[Int] = List(2)
  nums dropWhile (x => x > 0)                     //> res14: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res15: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))

  nums dropWhile ((x: Int) => x > 0)              //> res16: List[Int] = List(-4, 5, 7, 1)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => {
      (xs takeWhile (y => y == x)) :: pack(xs dropWhile (y => y == x))
    }
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  pack(List("a", "a", "a", "b", "c", "c", "a"))   //> res17: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a
                                                  //| ))

  def pack2[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => {
      val (first, second) = xs span (y => y == x)
      first :: pack2(second)
    }
  }                                               //> pack2: [T](xs: List[T])List[List[T]]

  pack2(List("a", "a", "a", "b", "c", "c", "a"))  //> res18: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a
                                                  //| ))

  def encode[T](xs: List[T]): List[(T, Int)] = xs match {
    case Nil => Nil
    case x :: xs1 => {
      val (first, second) = xs span (y => y == x)
      val encodepart = (first(0), first.length)
      encodepart :: encode(second)
    }
  }                                               //> encode: [T](xs: List[T])List[(T, Int)]
  encode(List("a", "a", "a", "b", "c", "c", "a")) //> res19: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))

  def encode2[T](xs: List[T]): List[(T, Int)] = pack2(xs) map (ys => (ys.head, ys.length))
                                                  //> encode2: [T](xs: List[T])List[(T, Int)]

  encode2(List("a", "a", "a", "b", "c", "c", "a"))//> res20: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
	
	
	//reduction of list
	
	def sum(xs :List[Int]) :Int = xs match{
		case Nil => 0
		case x::xl => x + sum(xl)
	}                                         //> sum: (xs: List[Int])Int
	
	sum(nums)                                 //> res21: Int = 11
	
	def sum2(xs:List[Int]) = (0::xs) reduceLeft((x,y) => x+y)
                                                  //> sum2: (xs: List[Int])Int
	sum2(nums)                                //> res22: Int = 11
	
	def sum3(xs:List[Int]) = (0::xs) reduceLeft(_+_)
                                                  //> sum3: (xs: List[Int])Int
	sum3(nums)                                //> res23: Int = 11
	
	//fold left has an accumulator
	def sum4(xs:List[Int]) = (xs foldLeft 0) (_+_)
                                                  //> sum4: (xs: List[Int])Int
	sum4(nums)                                //> res24: Int = 11
	
	//how fold left works
	def foldLeft2[U,T](xs:List[T], z:U)(op: (U,T) => U):U = xs match{
		case Nil => z
		case x::xs => foldLeft2(xs, op(z,x))(op)
	}                                         //> foldLeft2: [U, T](xs: List[T], z: U)(op: (U, T) => U)U
	
	def foldRight2[U,T](xs:List[T], z:U)(op: (T,U) => U):U = xs match{
		case Nil => z
		case x::xs => op(x, foldRight2(xs, z)(op))
	}                                         //> foldRight2: [U, T](xs: List[T], z: U)(op: (T, U) => U)U
	
	foldLeft2(nums, 0)(_+_)                   //> res25: Int = 11
	
	
	//fold right and reduce right
	(0::nums) reduceRight(_+_)                //> res26: Int = 11
	
	(nums foldRight 0)(_+_)                   //> res27: Int = 11
	
	def concat[T](xs:List[T], ys:List[T]):List[T] = (xs foldRight ys) (_::_)
                                                  //> concat: [T](xs: List[T], ys: List[T])List[T]
	concat(nums, nums)                        //> res28: List[Int] = List(2, -4, 5, 7, 1, 2, -4, 5, 7, 1)
	
	//type not match?
	//def concat2[T](xs:List[T], ys:List[T]):List[T] = (xs foldLeft ys) (_::_)
  //concat2(nums, nums)
	
	
	//laws of concat
	
	def factorial(n:Int):Int =
		if (n==0) 1
		else n* factorial(n-1)            //> factorial: (n: Int)Int
		
	factorial(4) >= 16                        //> res29: Boolean = true
	
	
	
	def concat3[T](xs:List[T], ys:List[T]) = xs match{
		case List() => ys
		case x::xs1 => x::concat(xs1,ys)
	}                                         //> concat3: [T](xs: List[T], ys: List[T])List[T]
	
	
	concat3(nums, nums)                       //> res30: List[Int] = List(2, -4, 5, 7, 1, 2, -4, 5, 7, 1)
	
	
	
}