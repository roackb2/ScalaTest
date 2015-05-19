import akka.actor.{Props, ActorLogging, Actor, ActorSystem}
import akka.actor.ActorDSL._
import akka.pattern.ask


/**
 * Created by roackb2 on 15/5/19.
 */

object ActorTest extends App {

    case class Route(path: String)
    case class Render(filePath: String)
    case class Error(msg: String)

    val system = ActorSystem("server")
    implicit val context = scala.concurrent.ExecutionContext.Implicits.global

    class Crawler extends Actor with ActorLogging {
        def receive = {
            case account: String => sender() ! LazyTest.getRepositories(account).toIterator.mkString("\n")
        }

    }

    class ServerActor extends Actor with ActorLogging {

        def receive = {
            case Route(path) => log.info("route to path: " + path)
            case Render(file) => log.info("render page: " + file)
            case Error(msg) => log.info("error message: " + msg)
        }
    }

    val server = actor(system)(new Act with ActorLogging {
        become {
            case Route(path) => log.info("route to path: " + path)
            case Render(file) => log.info("render page: " + file)
            case Error(msg) => log.info("error message: " + msg)
        }
    })
    server ! Render("index.html")

    val servers = (1 to 10).map(x => system.actorOf(Props[ServerActor], x.toString))
    (1 to 9).foreach(x => servers(x) ! Render(x.toString))

    val crawler = system.actorOf(Props[Crawler])
    val content = crawler.ask("roackb2")(5000)
    content.onComplete(text => text.foreach(line => println(line)))
    println("this code execute immediately after calling crawler.ask and before web content returned")

    val gitAccounts = List("ernie55ernie", "kabochya", "wanderer")
    gitAccounts.par.map(account => LazyTest.getRepositories(account)).zip(gitAccounts).foreach{
        case(repos, account) => println("repos of account " + account + ":\n" + repos.toIterator.mkString("\n") + "\n")}
}
