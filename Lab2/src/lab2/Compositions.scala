package lab2

/** Option представляет собой контейнер, который хранит какое-то значение
 * или не хранит ничего совсем, указывает, вернула ли операция результат или нет.
 * Это часто используется при поиске значений или когда операции могут потерпеть неудачу,
 * и вам не важна причина.

 * Комбинаторы называются так потому, что они созданы, чтобы объединять результаты.
 * Результат одной функции часто используется в качестве входных данных для другой.

 * Наиболее распространенным способом, является использование их со стандартными структурами данных.
 * Функциональные комбинаторы `map` и` flatMap` являются контекстно-зависимыми.
 * map - применяет функцию к каждому элементу из списка, возвращается список с тем же числом элементов.
 * flatMap берет функцию, которая работает с вложенными списками и объединяет результаты.
 */
sealed trait Option[A] {

  def map[B](f: A => B): Option[B]
  def flatMap[B](f: A => Option[B]): Option[B]
}
case class Some[A](a: A) extends Option[A] {

  def map[B](f: A => B): Option[B] = Some(f(a))
  def flatMap[B](f: A => Option[B]): Option[B] = f(a)
}
case class None[A]()     extends Option[A] {

  def map[B](f: A => B): Option[B] = None()
  def flatMap[B](f: A => Option[B]): Option[B] = None()
}

/** Напишите ваши решения в тестовых функциях.  */
object Compositions {

  // a) Используйте данные функции. Вы можете реализовать свое решение прямо в тестовой функции.
  // Нельзя менять сигнатуры

  def testCompose[A, B, C, D](f: A => B)
                             (g: B => C)
                             (h: C => D): A => D = h.compose(g).compose(f)


  def testCompose1[A, B, C, D](f: A => B)
                              (g: B => C)
                              (h: C => D): A => D = f andThen g andThen h
  // b) Напишите функции с использованием `map` и `flatMap`. Вы можете реализовать свое решение прямо в тестовой функции.
  // Нельзя менять сигнатуры

  def testMapFlatMap[A, B, C, D](f: A => Option[B])
                                (g: B => Option[C])
                                (h: C => D): Option[A] => Option[D] = _ flatMap f flatMap g map h

  // c) Напишите функцию используя for. Вы можете реализовать свое решение прямо в тестовой функции.
  // Нельзя менять сигнатуры

  def testForComprehension[A, B, C, D](f: A => Option[B])
                                      (g: B => Option[C])
                                      (h: C => D): Option[A] => Option[D] = {
    for {
      a <- _
      b <- f(a)
      c <- g(b)
    } yield h(c)//h(c) = h(g(b)) = h(g(f(a)))
  }


  def A(x: Int): Int = 12 * x - x
  def B(x: Int): Double = 4 * x - 6.5
  def C(x: Double): Double = 16 + x

  def A1(x: Int): Option[Int] = Some(12 * x - x)
  def B1(x: Int): Option[Double] = Some(4 * x - 6.5)
  def C1(x: Double): Double = 16 + x


  def Test: Unit = {

    println("testCompose")
    println(testCompose(A)(B)(C)(19))
    println(testCompose(A)(B)(C)(25))
    println(testCompose(A)(B)(C)(30))

    println("testCompose1")
    println(testCompose1(A)(B)(C)(19))
    println(testCompose1(A)(B)(C)(25))
    println(testCompose1(A)(B)(C)(30))

    println("testMapFlatMap")
    println(testMapFlatMap(A1)(B1)(C1)(Some(12)))
    println(testMapFlatMap(A1)((x: Int) => None())(C1)(Some(12)))

    println("testForComprehension")
    println(testForComprehension(A1)(B1)(C1)(Some(12)))
    println(testForComprehension(A1)((x: Int) => None())(C1)(Some(12)))
  }
}

object Main extends App {

  Compositions.Test


}

