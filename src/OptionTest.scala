/**
 * Created by roackb2 on 15/5/17.
 */

object OptionTest extends App {

    def getPosition[T](index: Int)(list: List[T]): Option[T] = {
        if(index < list.length) Some(list(index)) else None
    }

    val list: List[Int] = List(1, 2, 3, 4, 5)
    println(getPosition(2)(list).get)
    println(getPosition(6)(list).getOrElse(-1))

}

