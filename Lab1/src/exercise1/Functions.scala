package exercise1


/** Напишите отдельные функции, решающие поставленную задачу.
 *
 * Синтаксис:
 *   // метод
 *   def myFunction(param0: Int, param1: String): Double = // тело
 *
 *   // значение
 *   val myFunction: (Int, String) => Double (param0, param1) => // тело
 */

object Functions extends App {

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */

  def square(r: Double): Double = { scala.math.pow(r,2) * scala.math.Pi }

  //val squareV:(Double) => Double = r => { scala.math.pow(r,2) * scala.math.Pi }

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = { square(r) }

  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def rectangleCurried(a: Double)(b: Double): Double = a * b

  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = { rectangleCurried(a)(b) }

  // c) Напишите не карированную функцию для расчета площади прямоугольника.

  def rectangle(a: Double, b: Double): Double = { a * b }

  //val rectangleV:(Double, Double) => Double = (a,b) => { a * b }

  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = { rectangle(a, b) }

  def testFunctions: Unit ={

    println(testCircle(10))

    println(testRectangleCurried(7, 8))

    println(testRectangleUc(7, 30))

  }

  println("Functions")
  testFunctions

}

