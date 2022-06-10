//import kotlinx.coroutines.Job
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//fun main(args: Array<String>) = runBlocking {
//    val a: Job = launch {
//        show()
//    }
//    launch {
//        getAllUsers()
//        a.cancel()
//    }
//    return@runBlocking
//}
//
//suspend fun show() {
//    delay(3000)
//    println("hello")
//}
//
//fun getAllUsers() {
//    Thread.sleep(1000)
//    println("Users")
//
//}
//
//fun login() {
//    println("Login")
//    Thread.sleep(1000)
//}