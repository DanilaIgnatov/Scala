package lab2



import scala.annotation.tailrec

/** Реализуйте функции для решения следующих задач.
  * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подстверждения.
  * рекурсия будет хвостовой если:
  *   1. рекурсия реализуется в одном направлении
  *   2. вызов рекурсивной функции будет последней операцией перед возвратом
  */
object RecursiveFunctions extends App {

  def length[A](as: List[A]): Int = {
    @tailrec
    def loop(rem: List[A], agg: Int): Int = rem match {
      case Cons(_, tail) => loop(tail, agg + 1)
      case Nil()         => agg
    }

    loop(as, 0)
  }



  /* a) Напишите функцию которая записывает в обратном порядке список:
   *        def reverse[A](list: List[A]): List[A]
   */
  def reverse[A](list: List[A]): List[A] = {

    @tailrec
    def loop(rem: List[A], agg: List[A]): List[A] = rem match{
      case Cons(head, tail) => loop(tail, Cons(head, agg))
      case Nil() => agg
    }
    loop(list, Nil[A])
  }//123 321


  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testReverse[A](list: List[A]): List[A] = reverse(list)


  /* b) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def map[A, B](list: List[A])(f: A => B): List[B]
   */
  def map[A, B](list: List[A])(f: A => B): List[B] = {

    @tailrec
    def loop(rem: List[A], agg: List[B]): List[B] = rem match{
      case Cons(head, tail) => loop(tail, Cons(f(head), agg))
      case Nil() => testReverse(agg)
    }
    loop(list, Nil[B])

  }//123 543
  def testMap[A, B](list: List[A], f: A => B): List[B] = map(list)(f)

  /* c) Напишите функцию, которая присоединяет один список к другому:
   *        def append[A](l: List[A], r: List[A]): List[A]
   */
  def append[A](l: List[A], r: List[A]): List[A] = {

    @tailrec
    def loop(rem: List[A], agg: List[A]): List[A] = rem match {
      case Cons(n, tail) => loop(tail, Cons(n, agg))
      case Nil() => agg
    }
    loop(testReverse(l), r)

  }//123 321 123456

  // используйте функцию из пункта  (c) здесь, не изменяйте сигнатуру
  def testAppend[A](l: List[A], r: List[A]): List[A] = append(l, r)

  /* d) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
   *
   *    она получает функцию, которая создает новый List[B] для каждого элемента типа A в
   *    списке. Поэтому вы создаете List[List[B]].
   */

  def flatMap[A, B](list: List[A])(f: A => B): List[B] = {
    @tailrec
    def loop(st: List[A], res: List[B]): List[B] = st match {
      case Cons(head, tail) => loop(tail, Cons(f(head), res))
      case Nil() => reverse(res)
    }
    loop(list, Nil[B])
  }


  // используйте функцию из пункта  (d) здесь, не изменяйте сигнатуру
  //def testFlatMap[A, B](list: List[A], f: A => List[B]): List[B] =

  /* e) Вопрос: Возможно ли написать функцию с хвостовой рекурсией для `Tree`s? Если нет, почему? */

  def testRF: Unit = {

    val l1 = Cons(0, Cons(1, Cons(2, Cons(3, Nil()))))
    val l2 = Cons(9, Cons(8, Cons(7, Nil())))

    println("testReverse")
    println(testReverse(l1))
    println(testReverse(l2))

    println("testMap")
    println(testMap(l1, (x: Int) => x + 12))
    println(testMap(l1, (x: Int) => x * x))
    println(testMap(l2, (x: Int) => x + 12))
    println(testMap(l2, (x: Int) => x * x))

    println("testAppend")
    println(testAppend(l1, l2))
    println(testAppend(l2, l1))

    println("flatMap")
    println(flatMap(l1)((x: Int) => Cons(2*x+13, Nil())))
    println(flatMap(l2)((x: Int) => Cons(2*x+13, Nil())))

  }

}

object MainRF extends App {

  RecursiveFunctions.testRF

}
