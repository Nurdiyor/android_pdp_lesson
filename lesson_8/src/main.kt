import kotlin.concurrent.thread

fun main() {
    Thread {
        fun1()
        fun3()
    }.start()
//    Thread {
//
//    }.start()
    Thread {
        fun2()
    }.start()
}

fun fun1() {
    Thread.sleep(1000)
    println("fun1")
}

fun fun2() {
    Thread.sleep(2000)
    println("fun2")
}

fun fun3() {
    Thread.sleep(3000)
    println("fun3")
}