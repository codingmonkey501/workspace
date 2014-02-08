package day1.brief

/**
 * 1. => keyword
 * 2. : keyword
 * 3. "Class method argument" style
 * 4. Unit usage
 */
object Anonymous extends App {
  oncePerSecond(() => println("time flies like an arrow..."))
  def oncePerSecond(callback: () => Unit) {
    while (true) { callback(); Thread sleep 1000 }
  }
}