import java.util
import java.util.{Calendar, Date}

import scala.collection.{Set, mutable}

/**
 * Created by roackb2 on 15/5/10.
 */
object JSONTest extends App{
    abstract class JSON {
        override  def toString(): String = stringify(this, 0)
        def stringify(obj: JSON, depth: Int): String = {
            val indent = "\t"
            val prefix = if (depth != 0) (0 to depth - 1).map((x) => indent).reduce((former, element) => former + element) else ""
            obj match {
                case JSONObject(content) =>
                    content.keys.zipWithIndex.toList.map{case (key, i) =>
                        indent + prefix + key + ": " + stringify(content.getOrElse(key, JSONNumber(0)), depth + 1) +
                            (if(i < content.keys.size - 1) ",\n" else "\n")
                    }.foldLeft("{\n")((former, element) => former + element) + prefix + "}"
                case JSONArray(array) =>
                    array.zipWithIndex.map{ case(element, i) =>
                        indent + prefix + stringify(element, depth + 1) +
                            (if(i < array.size - 1)  ",\n" else  "\n")
                    }.foldLeft("[\n")((former, element) => former + element) + prefix + "]"
                case JSONNumber(value) => "" + value
                case JSONString(value) => value
                case JSONDate(value) => "" + value
            }
        }
    }
    case class JSONObject(map: Map[String, JSON]) extends JSON
    case class JSONArray(array: List[JSON]) extends JSON
    case class JSONNumber(num: Double) extends JSON
    case class JSONString(value: String) extends JSON
    case class JSONDate(value: Date) extends JSON


    val arr: JSON = JSONArray(
        List(JSONNumber(3),
            JSONString("hello")))
    val innerObj: JSON = JSONObject(
        Map("one" -> JSONNumber(8),
            "two" -> JSONArray(
                List(JSONString("hi"),
                    JSONNumber(3),
                    JSONObject(
                        Map("1" -> JSONString("yo"),
                            "2" -> JSONString("ya")))))))

    val obj: JSON = JSONObject(
        Map("first" -> JSONString("hi"),
            "second" -> arr,
            "third" -> innerObj,
            "fourth" -> JSONDate(Calendar.getInstance.getTime)))
    println(obj.toString())

    // result of this program:
    /*
        {
            first: hi,
            second: [
                3.0,
                hello
            ],
            third: {
                one: 8.0,
                two: [
                    hi,
                    3.0,
                    {
                        1: yo,
                        2: ya
                    }
                ]
            },
            fourth: Mon May 11 00:16:36 CST 2015
        }
    */
}

