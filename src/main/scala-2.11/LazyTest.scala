/**
 * Created by roackb2 on 15/5/18.
 */
object LazyTest extends App {

    def getRepositories(account: String): List[String] = {
        lazy val source = {
            println("getting repositories for account " + account + " ...")
            scala.io.Source.fromURL("https://github.com/" + account).getLines().toList
        }

        source.filter(_.contains("class=\"repo\"")).map((line) => line.substring(line.indexOf("title=\"") + 7, line.indexOf("\">")))
    }

    def getTitles(path: String): List[String] = {
        lazy val file = {
            println("reading file...")
            scala.io.Source.fromFile(path).getLines().toList
        }

        file.filter(_.contains("title")).map((line) => line.substring(line.indexOf("\"title\": \"") + 10, line.indexOf("\",")).toLowerCase())
    }

//    getRepositories("roackb2")

    getTitles("/Users/roackb2/Studio/programming/scala/test/src/reuters.json").foreach((title) => println(title))
}
