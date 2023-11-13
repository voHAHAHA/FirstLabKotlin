fun main(args: Array<String>) {
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
