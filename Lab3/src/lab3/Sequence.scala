package lab3

import scala.annotation.tailrec

/** Напишите свои решения в тестовых функциях.
  * 
  * Seq(1, 2) match {
  *   case head +: tail => ???
  *   case Nil          => ???
  *   case s            => ???
  * }
  * 
  * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
  */
// Примечание: напишите функции с хвостовой рекурсией

object Sequence {

  /* a) Найдите последний элемент Seq.
   *    
   */
  @tailrec
  def LastElement[A](seq: Seq[A]): Option[A] = seq match {
    case head +: Nil => Some(head)
    case _ +: tail => LastElement(tail)
    case Nil => None
  }

  def testLastElement[A](seq: Seq[A]): Option[A] = LastElement(seq)


  /* b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.
   *
   */
  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = a.zip(b)

  /* c) Проверьте, выполняется ли условие для всех элементов в Seq.
   *
   */
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = seq.forall(cond)

  def testForAll2[A](seq: Seq[A])(cond: A => Boolean): Boolean = {
    @tailrec
    def rec[A](seq: Seq[A])(cond: A => Boolean): Boolean = seq match{
      case head +: tail => if (cond(head)) rec(tail)(cond) else false
      case Nil => false
    }
    rec(seq)(cond)
  }

  /* d) Проверьте, является ли Seq палиндромом
   *
   */

  def testPalindrome[A](seq: Seq[A]): Boolean = seq == seq.reverse

  def testPalindrome2[A](seq: Seq[A]): Boolean = {
    @tailrec
    def loop[A] (seq: Seq[A], copy: Seq[A]): Boolean = seq match{
      case head +: tail => loop(tail, copy :+ head)
      case Nil => seq.equals(copy)
    }
    loop(seq, Nil)
  }


  /* e) Реализуйте flatMap используя foldLeft.
   * flatMap преобразует каждый элемент коллекции по оределенному правилу
   * используется для разделения элементов коллекции
   * Scala с целью создания единой коллекции с элементами аналогичного типа.
   * foldLeft начинает слева
   */
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = seq.foldLeft(Seq[B]())((list, el) => list ++: f(el))


  val seq1 = Seq(1, 2, 3, 4)
  val seq2 = Seq(9, 8, 7, 6)
  val seq3 = Seq(0, 1, 1, 0)

  def TestSeq: Unit ={

    println(testLastElement(seq1))
    println(testLastElement(seq2))
    println(testLastElement(seq3))

    println(testZip(seq1, seq2))
    println(testZip(seq1, seq3))

    println(testForAll(seq2)((x: Int) => x - 2 == 0))
    println(testForAll(seq3)((x: Int) => x >= 0))

    println(testPalindrome(seq1))
    println(testPalindrome2(seq2))
    println(testPalindrome(seq3))
    println(testPalindrome2(seq1))

    println(testFlatMap(seq1)((x: Int) => Seq(x * 10)))
    println(testFlatMap(seq2)((x: Int) => Seq(x * 10)))

  }

}

object MainSeq extends App {

  Sequence.TestSeq

}