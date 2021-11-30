package exercise1

//package exercise1

/** Напишите ваши решения в виде функций. */
object HigherOrder extends App {

  val plus: (Int, Int) => Int = _ + _
  val multiply: (Int, Int) => Int = _ * _

  /* a) Напишите функцию, которая принимает `f: (Int, Int) => Int`, параменты `a` и `b`
   *    и коэффициент умножения `n` и возвращает n * f(a, b). Назовите `nTimes`.
   */

  def nTimes(f: (Int, Int) => Int, a: Int, b: Int, n: Int): Int = { n * f(a, b) }

  // примените вашу функцию (a) здесь, не изменяйте сигнатуру
  def testNTimes(f: (Int, Int) => Int, a: Int, b: Int, n: Int): Int = { nTimes(f, a, b, n) }

  /* b) Напишите анонимную функцию, функцию без идентификатора ((a, b) => ???) для `nTimes` которая
   *    выполняет следующее:
   *          if (a > b) a else b
   */
  def testAnonymousNTimes(a: Int, b: Int, n: Int): Int = {

    nTimes((a, b) => if (a > b) a else b, a, b, n)

  }

  def testHiOrder: Unit ={

    println(testNTimes(plus, 7, 1, 6))
    println(testNTimes(multiply, 2, 9, 3))
    println(testAnonymousNTimes(5, 10, 10))
    println(testAnonymousNTimes(10, 5, 10))
    println(testAnonymousNTimes(5, 5, 3))
    println(testAnonymousNTimes(7, 2, 4))

  }

  println("HiOrder")
  testHiOrder

}