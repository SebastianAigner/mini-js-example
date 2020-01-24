import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlin.browser.document

@Serializable
data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)

val ktorClient = HttpClient(Js) { }

val json = Json(JsonConfiguration.Stable)

fun main() {
    val welcome = document.create.div {
        h1 {
            +"Hello, Kotlin/JS!"
        }
    }
    document.getElementById("root")?.appendChild(welcome)

    GlobalScope.launch {
        val video =
            ktorClient.get<String>("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/1")
        val vidObj = json.parse(Video.serializer(), video)
        console.log(vidObj)
    }
}