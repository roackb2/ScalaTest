/**
 * Created by roackb2 on 15/5/22.
 */
object EqualityTest extends App {

    class Person(val name: String) 

    case class Employee(override val name: String) extends Person(name)

    println(new Person("jay") == new Employee("jay"))
}
