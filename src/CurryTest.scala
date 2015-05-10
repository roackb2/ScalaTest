/**
 * Created by roackb2 on 15/5/10.
 */
object CurryTest extends App{

    def add(x: Int)(y: Int): Int = {
        x + y
    }

    def mult(x: Int)(y: Int): Int = {
        x * y
    }

    def seqOp[T](arr: List[T], op: (T) => T):List[T] = {
        arr.map(op)
    }

    def addPrefix(prefix: String)(original: String) = {
        prefix + " " + original
    }

    def addPostfix(postfix: String)(original: String) = {
        original + " " + postfix
    }

    val arr: List[Int] = (1 to 5).toList

    val another = seqOp( seqOp(arr, add(3)), mult(2))
    println(another)

    val chars: List[String] = List("1", "2", "3", "4", "5")
    val newChars = seqOp( seqOp(chars, addPrefix("hello")), addPostfix("world") )
    println(newChars)


}
