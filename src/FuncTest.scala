/**
 * Created by roackb2 on 15/5/11.
 */

object FuncTest extends App {

    val list: List[Int] = List(1, 2, 3, 4, 5)
    val files: List[String] = List("warn 2013", "error 2014", "warn 2014", "error 2013")

    println("list contains odd: " + list.exists(_ % 2 == 1))
    println(files.filter(_.contains("2013")).filter(_.contains("warn")))
    println(files.map(_.split(" ").size).reduceLeft(_ + _))
    println(list.fold(3)((l, r) => l + r))
}