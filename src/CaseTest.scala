/**
 * Created by roackb2 on 15/5/11.
 */
object CaseTest extends App {

    def fib(num: Int): Int = num match {
        case n: Int if n > 1 => fib(num - 1) + fib(num - 2)
        case _ => 1
    }

    abstract class Exp
    case class Var(value: Int) extends Exp
    case class Add(l: Exp, r: Exp) extends Exp
    case class Sub(l: Exp, r: Exp) extends Exp

    def value[T <: Exp](x: Exp): Int = x match {
        case Var(v) => v
        case Add(l, r) => value(l) + value(r)
        case Sub(l, r) => value(l) - value(r)
    }

    val exp: Exp = Add(Var(3), Sub(Var(6), Add(Var(1), Var(2))))
    println(value(exp))
}
