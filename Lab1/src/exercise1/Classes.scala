package exercise1

//package exercise1

/*
  a) Создать класс Animal, который имеет следующие поля:
  *      - name: String (название)
  *      - species: String (вид)
  *      - food: String
  *
  *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
  *              // остальные поля и методы
  *            }
*/

class Animal(val name: String, val species: String, food: String) {
  /*
   * c) Добавьте следующие метод в Animal:
   *      def eats(food: String): Boolean
   *
   *     который проверяет ест ли животное определенную пищу
   */

  def eats(food: String): Boolean = {

    this.food == food

  }


}

/* b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
*      - cat, mammal, meat
*      - parrot, bird, vegetables
*      - goldfish, fish, plants
*
*    Синтаксис: object MyClass {
*              // статические поля и методы
*            }
*/

object AnimalCompanion {
  val cat = new Animal("cat", "mammal", "meat")
  val parrot = new Animal("parrot", "bird", "vegetables")
  val goldfish = new Animal("goldfish", "fish", "plants")

  /* e) Добавьте следующие функции в объект-компаньон Animal:
  *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
  *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
  */

  def knownAnimal(name: String): Boolean = {
    name == "cat" | name == "parrot" | name == "goldfish"
  }

  def apply(name: String): Option[AnimalTrait] = name match {
    case "cat" => Some(Mammals("cat", Meat))
    case "parrot" => Some(Birds("parrot", Vegetables))
    case "goldfish" => Some(Fishes("goldfish", Plants))
    case _ => None
  }
}

/*
* d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishes.
*    Вам все еще нужно поле `species`?
*/

trait AnimalTrait {
  val name: String
  val food: Food

  def eats(food: Food): Boolean = { this.food == food }
}

case class Mammals(name: String, food: Food) extends AnimalTrait
case class Birds(name: String, food: Food) extends AnimalTrait
case class Fishes(name: String, food: Food) extends AnimalTrait


/* f) Создайте трейт Food со следующими классами-образцами:
*      - Meat
*      - Vegetables
*      - Plants
*   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
*      def apply(food: String): Option[Food]
*/

trait Food

case object Meat extends Food
case object Vegetables extends Food
case object Plants extends Food

object FoodCompanion {
  def apply(food: String): Option[Food] = {
    food match {
      case "meat" => Some(Meat)
      case "vegetables" => Some(Vegetables)
      case "plants" => Some(Plants)
      case _ => None
    }
  }
}

object Main extends App {

  println("Classes")
  println(AnimalCompanion.goldfish.eats("meat"))
  println(AnimalCompanion.goldfish.eats("plants"))
  println(AnimalCompanion.cat.eats("meat"))
  println(AnimalCompanion.knownAnimal("dog"))
  println(AnimalCompanion.knownAnimal("cat"))
  println(AnimalCompanion.apply("cat"))
  println(AnimalCompanion.apply("fish"))
  println(FoodCompanion.apply("vegetables"))
  println(FoodCompanion.apply("plants"))

}






