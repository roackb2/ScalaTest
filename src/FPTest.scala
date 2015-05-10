/**
 * Created by roackb2 on 15/5/7.
 */


object FPTest {
    def delegate(callback: () => Unit) {
        println("now the callback runs:");
        callback();
    }

    def delegateStatement(callback: (String) => Unit, toSay: String) {
        callback(toSay)
    }

    def saySomething(toSay: String) {
        println("this is what gonna be said: " + toSay)
    }

    def sayHello() {
        println("Hello World!~");
    }

    def main(args: Array[String]) {
        delegate(sayHello)
        delegateStatement(saySomething, "Hello FP!~")
        delegateStatement((toSay: String) => {
            println("this is what gonna be said in anonymous function: " + toSay)
        }, "Hello FP!~")
    }
}
