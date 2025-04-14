class CoffeeMachine {

    // Variablen
    var waterCap = 400
    var milkCap = 540
    var beansCap = 120
    var cupsOrder = 9
    var money = 550
    var exit = true

    // String-Variablen
    private val enoughResources = "I have enough resources, making you a coffee!\n"
    private val notWater = "Sorry, not enough water!\n"
    private val notCoffee = "Sorry, not enough coffee beans!\n"
    private val notCups = "Sorry, not enough cups!\n"
    private val notMilk = "Sorry, not enough milk!\n"

    // Kaffee-Typen
    private enum class Coffee(val water: Int, val milk: Int, val beans: Int, val cost: Int) {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6)
    }

    // Funktionen

    /**
     * Führt die Kaufaktion aus, bei der der Benutzer eine Kaffeesorte auswählt.
     * Aktualisiert die Ressourcen der Maschine basierend auf der Auswahl.
     */
    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> makeCoffee(Coffee.ESPRESSO)
            "2" -> makeCoffee(Coffee.LATTE)
            "3" -> makeCoffee(Coffee.CAPPUCCINO)
            "back" -> return
            else -> println(false)
        }
    }

    /**
     * Bereitet den ausgewählten Kaffee zu, wenn genügend Ressourcen vorhanden sind.
     * Reduziert die Ressourcen der Maschine entsprechend der Kaffeesorte.
     *
     * @param coffee Die ausgewählte Kaffeesorte.
     */
    private fun makeCoffee(coffee: Coffee) {
        when {
            waterCap < coffee.water -> println(notWater)
            milkCap < coffee.milk -> println(notMilk)
            beansCap < coffee.beans -> println(notCoffee)
            cupsOrder <= 0 -> println(notCups)
            else -> {
                println(enoughResources)
                waterCap -= coffee.water
                milkCap -= coffee.milk
                beansCap -= coffee.beans
                cupsOrder--
                money += coffee.cost
            }
        }
    }

    /**
     * Füllt die Maschine mit zusätzlichen Ressourcen (Wasser, Milch, Bohnen, Becher).
     * Fragt den Benutzer nach den Mengen, die hinzugefügt werden sollen.
     */
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

    /**
     * Gibt das gesamte Geld aus der Maschine aus und setzt den Geldbetrag auf 0.
     */
    fun take() {
        println("I gave you $$money\n")
        money = 0
    }

    /**
     * Zeigt den aktuellen Zustand der Maschine an, einschließlich der verfügbaren Ressourcen.
     */
    fun remaining() {
        println(
            "The coffee machine has:\n$waterCap ml of water\n$milkCap ml of milk\n$beansCap g of coffee beans\n$cupsOrder disposable cups\n$$money of money\n"
        )
    }
}