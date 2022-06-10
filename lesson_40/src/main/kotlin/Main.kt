import kotlinx.coroutines.*

fun main(args: Array<String>) {
    var d = CoroutineScope(Dispatchers.IO).async {
        show()
        getAllUsers()
    }
    runBlocking{
        d.await()
    }
}

suspend fun show() {
    delay(1000)
    println("hello")
}

fun getAllUsers() {
    Thread.sleep(1000)
    println("Users")

}

fun login() {
    println("Login")
    Thread.sleep(1000)
}