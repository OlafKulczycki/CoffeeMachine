
fun main() {
    val machine = CoffeeMachine()
    while (machine.exit) {
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> machine.buy()
            "fill" -> machine.fill()
            "take" -> machine.take()
            "remaining" -> machine.remaining()
            "exit" -> machine.exit = false
            else -> println(false)
        }
    }
}
