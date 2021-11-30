package lab3

/** Напишите вашу реализацию в тестовые функции.
 *
 * https://docs.scala-lang.org/overviews/collections/maps.html
 */
object Maps {


  case class User(name: String, age: Int)

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`testGroupUsers`) и вычислите средний возраст: `name -> averageAge`
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testGroupUsers(users: Seq[User]): Map[String, Int] = {
    def averageAge(ages: Seq[Int]) = ages.sum / ages.length
    users.groupBy(_.name).map {
      p => (p._1, averageAge(p._2.map(_.age)))
    }
  }

  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testNumberFrodos(map: Map[String, User]): Int = map.count(_._2.name.contains("Adam")) //map.values.count(_ == "Adam")

  /* c) Удалите всех пользователей возраст которых менее 35 лет.
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testUnderaged(map: Map[String, User]): Map[String, User] = map.filter(_._2.age>=35)


  val us1:Seq[User] = Seq(User("Kate",14),User("Semen",32),User("Anna", 19),User("Danila",20))
  val us2:Seq[User] = Seq(User("Pavel", 16), User("Viktor", 19), User("Roman", 17), User("Lena", 37))
  val ad1 = Map("1"->User("Nastya",25),"2"->User("Adam",38),"3"->User("Adamas",34),"4"->User("Sam",19),"5"->User("Adam",10))
  val ad2 = Map("1"->User("Adam",15),"2"->User("Adam",49),"3"->User("Adam",38),"4"->User("Adam",10),"5"->User("Adam",27))


  def TestMap: Unit ={

    println(testGroupUsers(us1))
    println(testGroupUsers(us2))

    println(testNumberFrodos(ad1))
    println(testUnderaged(ad1))
    println(testNumberFrodos(ad2))
    println(testUnderaged(ad2))

  }
}


object Main extends App {

  Maps.TestMap

}
