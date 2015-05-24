import java.io.File

import akka.actor.Props
import com.typesafe.config.ConfigFactory


/**
 * Created by roackb2 on 15/5/22.
 */
object RemoteActorTest extends App {

    val configFile = getClass.getClassLoader.
        getResource("application.conf").getFile
    val config = ConfigFactory.parseFile(new File(configFile))

    implicit val remoteSystem = akka.actor.ActorSystem("RemoteSystem", config)
    val remoteServer = remoteSystem.actorOf(Props[ActorTest.ServerActor], name = "remoteServer")
    val client = remoteSystem.actorSelection("akka.tcp://RemoteSystem@127.0.0.1:2552/user/remoteServer")
    client ! ActorTest.Render("hi")

}
