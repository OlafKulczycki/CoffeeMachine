class CoffeeMachine {

    //variables
    var waterCap = 400
    var milkCap = 540
    var beansCap = 120
    var cupsOrder = 9
    var money = 550
    var exit = true

    //  String variables
    private val enothResaurces = "I have enough resources, making you a coffee!\n"
    private val notEnothRes = "Sorry, i haven't enough resources, making you a coffee!\n"
    private val notWater = "Sorry, not enough water!\n"
    private val notCoffee = "Sorry, not enough coffee beans!\n"
    private val notCups = "Sorry, not enough cups!\n"
    private val notMilk = "Sorry, not enough milk!\n"

    //functions
    fun buy() {
        println(
            "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                    " back - to main menu:"
        )
        val choice = readln()
        if (choice == "1") {
            if (waterCap >= 250 && beansCap >= 16 && cupsOrder > 0) {
                println(enothResaurces)
                waterCap -= 250
                beansCap -= 16
                cupsOrder--
                money += 4
            } else if (waterCap < 250 && beansCap >= 16 && cupsOrder > 0) {
                println(notWater)
            } else if (waterCap >= 250 && beansCap < 16 && cupsOrder > 0) {
                println(notCoffee)
            } else if (waterCap >= 250 && beansCap >= 16) {
                println(notCups)
            } else
                println(notEnothRes)
        } else if (choice == "2") {
            if (waterCap >= 350 && milkCap >= 75 && beansCap >= 20 && cupsOrder > 0) {
                println(enothResaurces)
                waterCap -= 350
                milkCap -= 75
                beansCap -= 20
                cupsOrder--
                money += 7
            } else if (waterCap < 350 && milkCap >= 75 && beansCap >= 20 && cupsOrder > 0) {
                println(notWater)
            } else if (waterCap >= 350 && milkCap >= 75 && beansCap < 20 && cupsOrder > 0) {
                println(notCoffee)
            } else if (waterCap >= 350 && milkCap >= 75 && beansCap >= 20 && cupsOrder < 0) {
                println(notCups)
            } else if (waterCap >= 350 && milkCap < 75 && beansCap >= 20 && cupsOrder > 0) {
                println(notMilk)
            } else
                println(enothResaurces)
        } else if (choice == "3") {
            if (waterCap >= 200 && milkCap >= 100 && beansCap >= 12 && cupsOrder > 0) {
                println(enothResaurces)
                waterCap -= 200
                milkCap -= 100
                beansCap -= 12
                cupsOrder--
                money += 6
            } else if (waterCap < 200 && milkCap >= 100 && beansCap >= 12 && cupsOrder > 0) {
                println(notWater)
            } else if (waterCap >= 200 && milkCap >= 100 && beansCap < 12 && cupsOrder > 0) {
                println(notCoffee)
            } else if (waterCap >= 200 && milkCap >= 100 && beansCap >= 12 && cupsOrder < 0) {
                println(notCups)
            } else if (waterCap >= 200 && milkCap < 100 && beansCap >= 12 && cupsOrder > 0) {
                println(notMilk)
            } else
                println(notEnothRes)
        } else if (choice == "back")
            return
        else
            println(false)
    }

    fun fill() {
        println("Write how many ml of water do you want to add:")
        val waterAdd = readln().toInt()
        waterCap += waterAdd
        println("Write how many ml of milk do you want to add:")
        val milkAdd = readln().toInt()
        milkCap += milkAdd
        println("Write how many grams of coffee beans do you want to add:")
        val beansAdd = readln().toInt()
        beansCap += beansAdd
        println("Write how many disposable cups of coffee do you want to add:")
        val cupsAdd = readln().toInt()
        cupsOrder += cupsAdd
    }

    fun take() {
        println("I gave you $$money\n")
        money = 0
    }

    fun remaining() {
        println(
            "The coffee machine has:\n$waterCap ml of water\n$milkCap ml of milk\n" +
                    "$beansCap g of coffee beans\n$cupsOrder disposable cups\n$$money" +
                    " of money\n"
        )
    }
}

// main
fun main() {
    val machine = CoffeeMachine()
    while (machine.exit) {
        println("Write action (buy, fill, take, remaining, exit):")
        when(readln()) {
            "buy" -> machine.buy()
            "fill" -> machine.fill()
            "take" -> machine.take()
            "remaining" -> machine.remaining()
            "exit" -> machine.exit = false
            else -> println(false)
        }
    }
}