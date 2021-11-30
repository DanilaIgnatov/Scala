package lab3

/** Напишите ваши решения в тестовых функциях.
 *
 * https://www.scala-lang.org/api/2.12.3/scala/collection/immutable/StringOps.html
 */
object Strings {

  /* a) Преобразуйте все символы типа Char в верхний регистр (не используйте заглавные буквы).
   *
   */
  def upp(s:String):String=s.toUpperCase()

  def testUppercase(str: String): String = upp(str)

  /* b) Вставьте следующие значения в строку:
   *       Hi my name is <name> and I am <age> years old.
   *
   */
  def interpolations(name: String, age: Int): String = { s"Hi my name is $name and I am $age years old." }

  def testInterpolations(name: String, age: Int): String = interpolations(name,age)

  /* c) Добавьте два числа в следующую строку:
   *       Hi,
   *       now follows a quite hard calculation. We try to add:
   *         a := <value of a>
   *         b := <value of b>
   *
   *         result is <a + b>
   *
   *
   */
  def hardCalc(a:Int, b:Int):String={
    s"Hi,\n now follows a quite hard calculation. We try to add:\n a := $a\n b := $b\n result is ${a + b}"
  }
  def testComputation(a: Int, b: Int): String = hardCalc(a,b)

  /* d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки.
   */
  def twoSmb (s:String):String={ if(s.length==2) s else s.take(2) }

  def testTakeTwo(str: String): String = twoSmb(str)


  def TestStr: Unit = {

    println(testUppercase("HeLLo"))
    println(testUppercase("thank you"))

    println(testInterpolations("Danila", 20))
    println(testInterpolations("Jack", 19))

    println(testComputation(0,6))
    println(testComputation(12,-4))

    println(testTakeTwo("stop"))
    println(testTakeTwo("STart"))

  }


}


object MainStr extends App {

  Strings.TestStr

}
