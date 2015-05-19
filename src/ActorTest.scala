import akka.actor.{Props, ActorLogging, Actor, ActorSystem}

/**
 * Created by roackb2 on 15/5/19.
 */

object ActorTest extends App {

    case class Route(path: String)
    case class Render(filePath: String)
    case class Error(msg: String)

    class ServerActor extends Actor with ActorLogging {

        def receive = {
            case Route(path) => log.info("route to path: " + path)
            case Render(file) => log.info("render page: " + file)
            case Error(msg) => log.info("error message: " + msg)
        }
    }

    val system = ActorSystem("server")
    val server = system.actorOf(Props[ServerActor], name = "webServer")
    server ! Render("index.html")

}
