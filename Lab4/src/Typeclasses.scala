object Typeclasses {

  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.
  //implicitly доступен в Scala 2.8 и версиях младше
  //Обычно он используется, чтобы проверить, доступно ли неявное значение типа, T и вернуть его, если это так.

  trait Reversable[T] {

    def reverse(a: T): T

  }

  object Reversable {
    def reverse[T: Reversable](a: T): T = implicitly[Reversable[T]].reverse(a)

    // b) Реализуйте функцию Reverse для String.
    implicit object ReversString extends Reversable[String] {
      def reverse(a: String): String = a.reverse
    }
  }



  // примените тайп-класс-решение из пункта (a) здесь
  def testReversableString(str: String): String = Reversable.reverse(str)

  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash, которая выполняет операцию со значениями одного типа.

  trait Smash[T] {

    def smash (a:T,b:T):T

  }

  object Smash {

    def smash[T: Smash](a: T, b: T): T = implicitly[Smash[T]].smash(a, b)

    // d) Реализуйте  функции Smash для типа Int и Double.
    // Используйте сложение для типа Int у умножение для типа Double.
    implicit object SmashInt extends Smash[Int] {
      def smash(a: Int, b: Int): Int = a + b
    }

    implicit object SmashDbl extends Smash[Double] {
      def smash(a: Double, b: Double): Double = a * b
    }

    // e) Реализуйте функцию Smash для типа String.
    // Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра.
    implicit object SmashStr extends Smash[String] {
      def smash(a: String, b: String): String = a + b
    }

  }




  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashInt(a: Int, b: Int): Int = Smash.smash(a, b)

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashDouble(a: Double, b: Double): Double = Smash.smash(a, b)

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashString(a: String, b: String): String = Smash.smash(a, b)

  // Реализуйте тестовые функции с выводом на экран проверки разработанных функций.
  def test: Unit = {

    println(testReversableString("Danila Ignatov"))

    println(testSmashInt(99, 1))
    println(testSmashInt(9, 91))

    println(testSmashDouble(99.999, 1000))
    println(testSmashDouble(1.8, 30))

    println(testSmashString("Danila ", "Ignatov"))

  }

}

object Main extends App {

  Typeclasses.test

}