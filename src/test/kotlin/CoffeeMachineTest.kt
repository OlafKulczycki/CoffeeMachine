import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream

class CoffeeMachineTest {

    lateinit var machine: CoffeeMachine

    @BeforeEach
    fun setUp() {
        machine = CoffeeMachine()
    }

    @Test
    fun buy() {
        @Test
        fun testBuyEspresso() {
            val input: InputStream = ByteArrayInputStream("1\n".toByteArray())
            System.setIn(input)

            machine.buy()

            assertEquals(150, machine.waterCap) // Wasser reduziert
            assertEquals(540, machine.milkCap) // Milch bleibt gleich
            assertEquals(104, machine.beansCap) // Bohnen reduziert
            assertEquals(8, machine.cupsOrder) // Becher reduziert
            assertEquals(554, machine.money) // Geld erhöht
        }

        @Test
        fun testBuyInvalidOption() {
            val input: InputStream = ByteArrayInputStream("4\n".toByteArray())
            System.setIn(input)

            machine.buy()

            assertEquals(400, machine.waterCap) // Keine Änderung
            assertEquals(540, machine.milkCap)
            assertEquals(120, machine.beansCap)
            assertEquals(9, machine.cupsOrder)
            assertEquals(550, machine.money)
        }

        @Test
        fun testBuyBackOption() {
            val input: InputStream = ByteArrayInputStream("back\n".toByteArray())
            System.setIn(input)

            machine.buy()

            assertEquals(400, machine.waterCap) // Keine Änderung
            assertEquals(540, machine.milkCap)
            assertEquals(120, machine.beansCap)
            assertEquals(9, machine.cupsOrder)
            assertEquals(550, machine.money)
        }

        @Test
        fun testBuyNotEnoughWater() {
            machine.waterCap = 0
            val input: InputStream = ByteArrayInputStream("1\n".toByteArray())
            System.setIn(input)

            machine.buy()

            assertEquals(0, machine.waterCap) // Keine Änderung
            assertEquals(120, machine.beansCap)
            assertEquals(9, machine.cupsOrder)
            assertEquals(550, machine.money)
        }
    }

    @Test
    fun fill() {

        machine = CoffeeMachine()

        // Simuliere die Eingabe für das Auffüllen der Maschine
        val input: InputStream = ByteArrayInputStream("200\n100\n50\n10\n".toByteArray())
        System.setIn(input)

        // Simuliere das Auffüllen der Maschine
        machine.fill()
        // Überprüfe, ob die Ressourcen korrekt aktualisiert wurden
        assertEquals(600, machine.waterCap) // Beispielwerte, anpassen je nach Ausgangswerten
        assertEquals(640, machine.milkCap)
        assertEquals(170, machine.beansCap)
        assertEquals(19, machine.cupsOrder)
    }

    @Test
    fun take() {
        machine = CoffeeMachine()
        machine.take()
        assertEquals(0, machine.money)
    }

    @Test
    fun remaining() {
        machine = CoffeeMachine()
        machine.remaining()
        // Überprüfe die Ausgabe der verbleibenden Ressourcen
        assertEquals(400, machine.waterCap)
        assertEquals(540, machine.milkCap)
        assertEquals(120, machine.beansCap)
        assertEquals(9, machine.cupsOrder)
        assertEquals(550, machine.money)
    }
}
