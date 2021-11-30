package lab3

import scala.util.{Try, Failure, Success}
import scala.Right
import scala.io.StdIn

/** Реализуйте следующие функции.
 *
 * List(1, 2) match {
 *   case head :: tail => ???
 *   case Nil          => ???
 *   case l            => ???
 * }
 *
 * Option(1) match {
 *   case Some(a) => ???
 *   case None    => ???
 * }
 *
 * Either.cond(true, 1, "right") match {
 *   case Left(i)  => ???
 *   case Right(s) => ???
 * }
 *
 * Try(impureExpression()) match {
 *   case Success(a)     => ???
 *   case Failure(error) => ???
 * }
 *
 * Try(impureExpression()).toEither
 *
 */
object Adts {

  // a) Дан List[Int], верните элемент с индексом n
  def GetN( list:List[Int], n:Int):Option[Int] = if (list.length > n) Some(list(n)) else None


  // примените функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testGetNth(list: List[Int], n: Int): Option[Int] = GetN(list, n)


  // b) Напишите функцию, увеличивающую число в два раза.
  def X2 (n: Option[Int]):Option[Int] = n match {
    case Some(n) => Some (2 * n)
    case None=>None // case _ => None

  }


  // примените функцию из пункта (b) здесь, не изменяйте сигнатуру
  def testDouble(n: Option[Int]): Option[Int] = X2(n)

  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right. В противном случае, верните Left("Нечетное число.").
  def Even (n:Int):Either[String, Int] = if (n%2==0) Right(n) else Left("Нечетное число.")

  // примените функцию из пункта (c) здесь, не изменяйте сигнатуру
  def testIsEven(n: Int): Either[String, Int] = Even(n)

  // d) Напишите функцию, реализующую безопасное деление целых чисел. Верните Right с результатом или Left("Вы не можете делить на ноль.").
  def safeD (a:Int, b:Int):Either[String, Int] = { if (b==0) Left("Вы не можете делить на ноль.") else Right(a/b) }



  // примените функцию из пункта (d) здесь, не изменяйте сигнатуру
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = safeD(a,b)


  // e) Обработайте исключения функции с побочным эффектом вернув 0.
  def goodOldJava(impure: String => Int, str: String): Try[Int] = Try(impure(str))

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testGoodOldJava(impure: String => Int, str: String): Try[Int] = goodOldJava(impure, str)


  var list1 = List(9,1,2,3,4,5,6,7,8,9)
  var list2 = List(2)
  var list3 = List()

  def func1(str: String): Int = str.toInt / 0
  def func2(str: String): Int = str.toInt


  def Test: Unit = {

    println(testGetNth(list1, 0))
    println(testGetNth(list2, 3))
    println(testGetNth(list3, 6))

    println(testDouble(Some(10)))
    println(testDouble(Some(-5)))
    println(testDouble(None))

    println(testIsEven(10))
    println(testIsEven(11))
    println(testIsEven(0))

    println(safeD(10,2))
    println(safeD(10,0))
    println(safeD(12,3))

    println(testGoodOldJava(func1, "0"))
    println(testGoodOldJava(func2, "1"))


  }
}



object MainAd extends App {

  Adts.Test

}
