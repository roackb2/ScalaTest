/**
 * Created by roackb2 on 15/5/22.
 */
object ExtractorTest extends App {
    object Even {
        def unapply(num: Int): Option[Int] = if(num % 2 == 0) Some(num) else None
    }

    object Date {
        def unapply(d: String): Option[(Int, Int, Int)] = {
            val strs = d.split("-")
            if(strs.length == 3) Some(strs(0).toInt, strs(1).toInt, strs(2).toInt) else None
        }
    }

    val num = 21
    num match {
        case Even(n) => println(n)
        case _ => println(-1)
    }

    val date = "2014-3-12"
    date match {
        case Date(y, m, d) => println(y + ", " + m + ", " + d)
        case _ => println("not date")
    }
}
