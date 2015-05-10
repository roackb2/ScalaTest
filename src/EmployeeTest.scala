import java.util
import java.util.{Calendar, Date}

import scala.util.parsing.json.JSON

/**
 * Created by roackb2 on 15/5/7.
 */
object EmployeeTest extends App{

    class Language(name: String) {
        override def toString(): String = name
    }


    class SkillSet {
        val list = new util.ArrayList[Language]() with Loopable[Language] with Jsonify
        def push(skill: Language): Unit = {
            if(!list.contains(skill)) list.add(skill)
        }

        def toJson() = list.toJson()
        def foreach(op: (Language) => Unit) = list.foreach(op)
    }

    trait Loopable[T] extends util.ArrayList[T]{
        def foreach(op: (T) => Unit) = {
             for(i <- 0 to this.size() - 1) {
                op(this.get(i))
            }
        }
    }

    trait Jsonify {
        def toJson() = scala.util.parsing.json.JSONFormat.defaultFormatter(this)
    }


    class Employee (val name: String, val bd: Calendar, val position: String) {
        var age: Int = 0;

        override def toString() = "name: " + name +
            "\nbirthday: " + bd.get(Calendar.YEAR) + "-" + (bd.get(Calendar.MONTH) + 1) + "-" + bd.get(Calendar.DATE) +
            "\nposition: " + position +
            (if (age != 0) "\nage: " + age else "")

        def myClone(): Employee = {
            val newEmployee = new Employee(name, bd, position)
            newEmployee
        }
    }

    class Engineer(override val name: String, override val bd: Calendar, override val position: String, val skills: SkillSet) extends Employee(name, bd, position) {
        override def myClone(): Engineer = {
            new Engineer(name, bd, position, skills)
        }
        override def toString(): String = super.toString() + "\nskills: " + skills.toJson()
    }

    trait CanShowSkill {
        def skills: SkillSet
        def showSkill() = {
            skills.foreach((x: Language) => {
                println("I can write " + x.toString())
            })
        }
    }

    def listStringify[T](list: List[T]): String = {
        var result: String = ""
        list.foreach((element: T) => result = result + element + ", ")
        result
    }

    def getAge(bd: Calendar): Int = {
        val now: Calendar = Calendar.getInstance()
        val thisYear = now.get(Calendar.YEAR)
        val age = thisYear - bd.get(Calendar.YEAR)
        age
    }

    def getNewWorkerWithAge[T <: Employee](cloneable: {def myClone(): T}, op: (Calendar) => Int): T = {
        val newWorker: T = cloneable.myClone()
        newWorker.age = op(newWorker.bd)
        newWorker
    }

    val bd = Calendar.getInstance()
    bd.set(1991, 12, 20)
//    val jay = new Employee("Jay Liang",  bd, "Android developer")
//    val jay2 = getNewWorkerWithAge(jay, getAge)
//    println(jay2.toString())

//    val skills = new util.ArrayList[String]() with Jsonify
//    skills.add("java")
//    skills.add("scala")
    val skills = new SkillSet
    skills.push(new Language("Java"))
    skills.push(new Language("Scala"))
    val jay3 = new Engineer("Jay Liang", bd, "Android developer", skills) with CanShowSkill
    val jay4 = getNewWorkerWithAge(jay3, getAge)
    println(jay3)
    jay3.showSkill()

}
