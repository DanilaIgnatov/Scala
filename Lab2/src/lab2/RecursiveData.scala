package lab2

sealed trait List[A]
case class Cons[A](head: A, tail: List[A]) extends List[A]
case class Nil[A]() extends List[A]

/** Напишите свои решения в виде функций. */
object RecursiveData {

  // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
  def listEmpty(list: List[Int]): Boolean = list == Nil()



  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntEmpty(list: List[Int]): Boolean = listEmpty(list)

  // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
  def listHead(list: List[Int]): Int = list match {
    case list: Cons[Int] => list.head
    case list: Nil[Int] => -1 //case _ => -1
  }



  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntHead(list: List[Int]): Int = listHead(list)

  // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?
  sealed trait NoEmptyList[A]
  case class ConsN[A](head: A, tail: NoEmptyList[A]) extends NoEmptyList[A]
  case class End[A](head: A) extends NoEmptyList[A]

  /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */
  sealed trait Tree[A]
  case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
  case class Leaf[A](head: A) extends Tree[A]



  var list1: List[Int] = Nil()
  var list2: List[Int] = Cons(4, Cons(1, Nil()))
  var list3: List[Int] = Cons(-5, Cons(-2, Cons(0, Nil())))


  def Test: Unit = {

    println("testListIntEmpty")
    println(testListIntEmpty(list1))
    println(testListIntEmpty(list2))
    println(testListIntEmpty(list3))

    println("testListIntHead")
    println(testListIntHead(list1))
    println(testListIntHead(list2))
    println(testListIntHead(list3))



  }
}

object MainRD extends App {

  RecursiveData.Test

}
