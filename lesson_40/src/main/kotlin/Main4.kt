//import kotlinx.coroutines.Job
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//fun main(args: Array<String>) = runBlocking {
//    var d:Int?=null
//    var f:Int?=null
//    var t=d!!+f!!
//    println(t)
//    repeat(100_000) { // launch a lot of coroutines
////        launch {
////            delay(1000L)
////            println(".")
////        }
//        delay(1000L)
//        println(".")
//    }
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