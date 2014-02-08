package day2.basic

object CheetSheet3Package extends App {

  //wildcard import
  import scala.collection._

  //selective import.
  import scala.collection.BitSet
  import scala.collection.{ BitSet, AbstractMap }

  //renaming import.
  import scala.collection.{ BitSet => Vec28 }

  //import all from java.util except Date.
  import java.util.{ Date => _, _ }

}