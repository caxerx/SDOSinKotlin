import java.util.*

class SaladAndDrinkOrderSystem(val menu: Array<Item>) {
    private val s: Scanner
    private val maxOrderItem = 5
    var orderedItem: Array<Item?>
    var numOfOrderedItem: Int

    init {
        orderedItem = arrayOfNulls(maxOrderItem)
        numOfOrderedItem = 0
        s = Scanner(System.`in`)
    }

    fun printMenu() {
        var i = 0
        for (item in menu) {
            println("${i + 1}. ${item.showItemDetails()}")
            i++
        }
    }

    fun calculateTotal(): Double {
        var sum = 0.0
        for (item in 0..numOfOrderedItem) {
            sum += orderedItem[item]!!.calculateOrderPrice()
        }
        return sum
    }

    private fun printSeparator() {
        println("---------------------------------------------")
    }

    fun placeOrder() {
        println("Welcome to Salad and Drink Ordering System")
        println("(You may order at most 5 items in an order) :-")
        println("Menu")
        printMenu()
        printSeparator()
        do {
            println("Please input the item number to be ordered (1 - ${menu.size}) :-")
            val choose = inputWithCondition({ i: Int -> i > 0 && i <= menu.size }, "Invalid choice! Try again!")
            val item = menu[choose - 1]
            println("You have chosen ${item.itemName}")
            val order = when (item) {
                is Salad -> {
                    println("Input weight (in grams) for your salad")
                    val weight = inputWithCondition({ i: Int -> i > 0 }, "Invalid input for weight! Try again!")
                    Salad(item.itemName, item.pricePer100g, weight)
                }
                is Drink -> {
                    println("Input the size for your drink (S: small M: medium L: large)")
                    val size = inputWithCondition({ i: String -> i == "S" || i == "M" || i == "L" }, "Invalid input for size! Try again!")
                    Drink(item.itemName, item.basePrice, size[0])
                }
                else -> null
            }!!
            orderedItem[numOfOrderedItem] = order
            numOfOrderedItem++
            println("\n${order.showOrderDetails()}")
            printSeparator()
            println("Total No. of items ordered: $numOfOrderedItem")
            println("Do you want to order another item? (1: Yes, 0: No)")
        } while (inputWithCondition({ i: Int -> i == 0 || i == 1 }, "Invalid choice! Try again!") == 1 && numOfOrderedItem < maxOrderItem)
        println("Your ordered item(s):")
        for (item in 0 until numOfOrderedItem) {
            printSeparator()
            println(orderedItem[item]!!.showOrderDetails())
        }
        printSeparator()
        println("Total no. of items ordered : $numOfOrderedItem")
        println("Total Order Price : ${calculateTotal()}")
    }

    fun inputWithCondition(cond: (Int) -> Boolean, errMsg: String): Int {
        var input: Int? = null
        do {
            try {
                input = s.nextInt()
                if (!cond(input)) {
                    println(errMsg)
                }
            } catch (e: InputMismatchException) {
                println(errMsg)
                s.nextLine()
            }
        } while (input == null || !cond(input))
        return input
    }


    fun inputWithCondition(cond: (String) -> Boolean, errMsg: String): String {
        var input: String? = null
        do {
            input = s.next()
            if (!cond(input)) {
                println(errMsg)
            }
        } while (input == null || !cond(input))
        return input
    }

}