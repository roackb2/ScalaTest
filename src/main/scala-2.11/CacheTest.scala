import scala.collection.mutable

/**
 * Created by roackb2 on 15/5/22.
 */
object CacheTest extends App {
    val cache = new mutable.WeakHashMap[Int, Int]
    def memo(f: Int => Int) = (x: Int) => cache.getOrElseUpdate(x, f(x))

    def fibonacciImp(n: Int): Int = n match {
        case 0 => 1
        case 1 => 1
        case _ => memo(fibonacciImp)(n - 1) + memo(fibonacciImp)(n -2)
    }

    def fibonacci(n: Int) = memo(fibonacciImp)(n)

    val t = System.currentTimeMillis()
    println(fibonacci(40))
    println("takes " + (System.currentTimeMillis() - t) + " ms")
}
