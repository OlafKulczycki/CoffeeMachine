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
  // Test für Espresso (genügend Ressourcen)
  var input: InputStream = ByteArrayInputStream("1\n".toByteArray())
  System.setIn(input)
  machine.buy()
  assertEquals(150, machine.waterCap)
  assertEquals(104, machine.beansCap)
  assertEquals(8, machine.cupsOrder)
  assertEquals(554, machine.money)

  // Test für Latte (genügend Ressourcen)
  machine = CoffeeMachine()
  input = ByteArrayInputStream("2\n".toByteArray())
  System.setIn(input)
  machine.buy()
  assertEquals(50, machine.waterCap)
  assertEquals(465, machine.milkCap)
  assertEquals(100, machine.beansCap)
  assertEquals(8, machine.cupsOrder)
  assertEquals(557, machine.money)

  // Test für Cappuccino (genügend Ressourcen)
  machine = CoffeeMachine()
  input = ByteArrayInputStream("3\n".toByteArray())
  System.setIn(input)
  machine.buy()
  assertEquals(200, machine.waterCap)
  assertEquals(440, machine.milkCap)
  assertEquals(108, machine.beansCap)
  assertEquals(8, machine.cupsOrder)
  assertEquals(556, machine.money)

  // Test für Rückkehr zum Hauptmenü
  machine = CoffeeMachine()
  input = ByteArrayInputStream("back\n".toByteArray())
  System.setIn(input)
  machine.buy()
  assertEquals(400, machine.waterCap) // Werte bleiben unverändert
  assertEquals(540, machine.milkCap)
  assertEquals(120, machine.beansCap)
  assertEquals(9, machine.cupsOrder)
  assertEquals(550, machine.money)

  // Test für ungültige Eingabe
  machine = CoffeeMachine()
  input = ByteArrayInputStream("4\n".toByteArray())
  System.setIn(input)
  machine.buy()
  assertEquals(400, machine.waterCap) // Werte bleiben unverändert
  assertEquals(540, machine.milkCap)
  assertEquals(120, machine.beansCap)
  assertEquals(9, machine.cupsOrder)
  assertEquals(550, machine.money)

  // Test für nicht genügend Wasser für Espresso
  machine = CoffeeMachine()
  machine.waterCap = 0
  input = ByteArrayInputStream("1\n".toByteArray())
  System.setIn(input)
  machine.buy()
  assertEquals(0, machine.waterCap)
  assertEquals(120, machine.beansCap)
  assertEquals(9, machine.cupsOrder)
  assertEquals(550, machine.money)

  // Test für nicht genügend Kaffeebohnen für Latte
  machine = CoffeeMachine()
  machine.beansCap = 0
  input = ByteArrayInputStream("2\n".toByteArray())
  System.setIn(input)
  machine.buy()
  assertEquals(400, machine.waterCap)
  assertEquals(540, machine.milkCap)
  assertEquals(0, machine.beansCap)
  assertEquals(9, machine.cupsOrder)
  assertEquals(550, machine.money)

  // Test für nicht genügend Becher für Cappuccino
  machine = CoffeeMachine()
  machine.cupsOrder = 0
  input = ByteArrayInputStream("3\n".toByteArray())
  System.setIn(input)
  machine.buy()
  assertEquals(400, machine.waterCap)
  assertEquals(540, machine.milkCap)
  assertEquals(120, machine.beansCap)
  assertEquals(0, machine.cupsOrder)
  assertEquals(550, machine.money)

  // Test für nicht genügend Milch für Latte
  machine = CoffeeMachine()
  machine.milkCap = 0
  input = ByteArrayInputStream("2\n".toByteArray())
  System.setIn(input)
  machine.buy()
  assertEquals(400, machine.waterCap)
  assertEquals(0, machine.milkCap)
  assertEquals(120, machine.beansCap)
  assertEquals(9, machine.cupsOrder)
  assertEquals(550, machine.money)
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
