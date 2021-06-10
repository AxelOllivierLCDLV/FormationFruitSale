import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    println("Press enter to start")
    val fruits = mutableMapOf<Fruit, Int>()
    try {
        while (scan.hasNextLine()) {
            val line: String = scan.nextLine().toLowerCase()
            val stringFruits = line.split(',')
            println(stringFruits)
            stringFruits.forEach {
                updateFruitsOf(it, fruits)
            }
           // updateFruitsOf(line, fruits)
            println(calculatePriceOf(fruits))
            if (line == "##") {
                System.exit(0)
                scan.close()
            }
        }
    } finally {
        if (scan != null) scan.close()
    }
}

private fun updateFruitsOf(line: String, fruits: MutableMap<Fruit, Int>) {
    when (line) {
        "pommes" -> increment(fruits, Fruit.APPLEFR)
        "apples" -> increment(fruits, Fruit.APPLEEN)
        "mele" -> increment(fruits, Fruit.APPLEIT)
        "bananes" -> increment(fruits, Fruit.BANANA)
        "cerises" -> increment(fruits, Fruit.CHERRY)
        else -> {
        }
    }
}

fun calculatePriceOf(fruits: MutableMap<Fruit, Int>) =
    calculateAppleFrPrice(fruits[Fruit.APPLEFR] ?: 0) + calculateAppleEnPrice(fruits[Fruit.APPLEEN] ?: 0) + calculateAppleItPrice(fruits[Fruit.APPLEIT] ?: 0) + calculateBananaPrice(fruits[Fruit.BANANA] ?: 0) + calculateCherryPrice(
        fruits[Fruit.CHERRY] ?: 0
    )

fun calculateAppleFrPrice(numberOfApples: Int) = numberOfApples * 100
fun calculateAppleEnPrice(numberOfApples: Int) = numberOfApples * 100 - ((numberOfApples / 3) * 100)
fun calculateAppleItPrice(numberOfApples: Int) = numberOfApples * 100 - ((numberOfApples / 2) * 100)

fun calculateBananaPrice(numberOfBananas: Int) = ((numberOfBananas + 1) / 2) * 150

fun calculateCherryPrice(numberOfCherries: Int) = numberOfCherries * 75 - (numberOfCherries / 2) * 20

fun increment(map: MutableMap<Fruit, Int>, key: Fruit) {
    map.putIfAbsent(key, 0)
    map[key] = map[key]!! + 1
    println(key)
}

enum class Fruit {
    APPLEFR, APPLEEN, APPLEIT,  BANANA, CHERRY
}

