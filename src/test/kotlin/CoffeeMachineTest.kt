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
    fun testBuyEspresso() {
        val originalIn = System.`in`
        try {
            val input: InputStream = ByteArrayInputStream("1\n".toByteArray())
            System.setIn(input)

            machine.buy()

            assertEquals(150, machine.waterCap) // Wasser reduziert
            assertEquals(540, machine.milkCap) // Milch bleibt gleich
            assertEquals(104, machine.beansCap) // Bohnen reduziert
            assertEquals(8, machine.cupsOrder) // Becher reduziert
            assertEquals(554, machine.money) // Geld erhöht
        } finally {
            System.setIn(originalIn)
        }
    }

    @Test
    fun testBuyInvalidOption() {
        val originalIn = System.`in`
        try {
            val input: InputStream = ByteArrayInputStream("4\n".toByteArray())
            System.setIn(input)

            machine.buy()

            assertEquals(400, machine.waterCap) // Keine Änderung
            assertEquals(540, machine.milkCap)
            assertEquals(120, machine.beansCap)
            assertEquals(9, machine.cupsOrder)
            assertEquals(550, machine.money)
        } finally {
            System.setIn(originalIn)
        }
    }

    @Test
    fun testBuyBackOption() {
        val originalIn = System.`in`
        try {
            val input: InputStream = ByteArrayInputStream("back\n".toByteArray())
            System.setIn(input)

            machine.buy()

            assertEquals(400, machine.waterCap) // Keine Änderung
            assertEquals(540, machine.milkCap)
            assertEquals(120, machine.beansCap)
            assertEquals(9, machine.cupsOrder)
            assertEquals(550, machine.money)
        } finally {
            System.setIn(originalIn)
        }
    }

    @Test
    fun testBuyNotEnoughWater() {
        val originalIn = System.`in`
        try {
            machine.waterCap = 0
            val input: InputStream = ByteArrayInputStream("1\n".toByteArray())
            System.setIn(input)

            machine.buy()

            assertEquals(0, machine.waterCap) // Keine Änderung
            assertEquals(120, machine.beansCap)
            assertEquals(9, machine.cupsOrder)
            assertEquals(550, machine.money)
        } finally {
            System.setIn(originalIn)
        }
    }
}