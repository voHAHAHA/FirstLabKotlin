fun main(args: Array<String>) {
    // Лаб. 1
    // Задача 1.
    var numFirst : Int = 15
    var numSecond : Int = 23

    println("Сложение: ${numFirst + numSecond} \tВычетание: ${numFirst - numSecond} \tУмножение: ${numFirst * numSecond} \tДеление :${numFirst / numSecond} \t")

    // Задача 2.
    print("Введите число... ")
    var intNum = readln().toInt()

    if (intNum % 2 == 0) {
        println("Четное")
    } else {
        println("Нечетное")
    }

    // Задача 3.
    var inpNumSecond : Int = 5

    for (i in 0..inpNumSecond) {
        for (j in 0..inpNumSecond) {
            print("${i * j} \t")
        }
        println()
    }
    print("Введите число... ")
    var inpNumThird = readln().toInt()

    while (inpNumThird > 0) {
        println(inpNumThird * inpNumThird)
        inpNumThird--
    }

    // Задача "Колода карт"
    val deck = Deck()
    println("Исходная колода: ")
    deck.printDeck()

    deck.sortDeck()
    println("\nОтсортированная колода: ")
    deck.printDeck()

    // Лаб. 2
    // Задача 1
    println("Addition: ${sum(12, 53)}")
    println("Addition: ${sum(5.6, 9.2)}") // Задача 2
    println("Multiplication: ${multiply(5, 3, 4)}")
    println("Multiplication: ${multiply(3.2, 4.5, 2.9)}") // Задача 2
    greet("Vova")

    // Задача 3
    var cal = Calculator()
    println(cal.add(12, 24))
    println(cal.multiply(2, 5, 9))

    // Задача 4
    val intSumResult = CalculatorObj.sum(2, 3)
    val doubleSumResult = CalculatorObj.sum(2.5, 3.5)
    val intMultiplyResult = CalculatorObj.multiply(4, 6)
    val doubleMultiplyResult = CalculatorObj.multiply(4.5, 2.5)

    println("Sum of ints: $intSumResult")
    println("Sum of doubles: $doubleSumResult")
    println("Sum of ints: $intSumResult")
    println("Sum of doubles: $doubleSumResult")
}

fun sum (num1 : Int, num2 : Int) : Int {
    return num1 + num2
}
fun sum (num1 : Double, num2 : Double) : Double {
    return num1 + num2
}
fun multiply (num1 : Int, num2 : Int, num3 : Int) : Int {
    return num1 * num2 * num3
}
fun multiply (num1 : Double, num2 : Double, num3 : Double) : Double{
    return num1 * num2 * num3
}
fun greet (name : String) {
    println("Hello, $name")
}

class Calculator() {
    fun add(num1 : Int, num2 : Int) : Int {
        return num1 + num2
    }
    fun multiply (num1 : Int, num2 : Int, num3 : Int) : Int {
        return num1 * num2 * num3
    }
}

object CalculatorObj {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    fun sum(a: Double, b: Double): Double {
        return a + b
    }
    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun multiply(a: Double, b: Double): Double {
        return a * b
    }
}

data class Card(val rank: String, val suit: String)

class Deck {
    val cards = mutableListOf<Card>()

    init {
        val ranks = listOf("2","3","4","5","6","7","8","9","10","В","Д","К","Т")
        val suits = listOf("Черви", "Бубны", "Трефы", "Пики")

        for (suit in suits) {
            for (rank in ranks) {
                cards.add(Card(rank, suit))
            }
        }
    }
    fun printDeck() {
        cards.forEach {
            println("${it.rank} ${it.suit}")
        }
    }
    fun sortDeck() {
        cards.sortWith(compareBy({ it.suit }, { rankToInt(it.rank) }))
    }
    private fun rankToInt(rank: String): Int {
        return when (rank) {
            "2" -> 2
            "3" -> 3
            "4" -> 4
            "5" -> 5
            "6" -> 6
            "7" -> 7
            "8" -> 8
            "9" -> 9
            "10" -> 10
            "В" -> 11
            "Д" -> 12
            "К" -> 13
            "Т" -> 14
            else -> 0
        }
    }
}