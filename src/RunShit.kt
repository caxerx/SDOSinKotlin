fun main(args: Array<String>) {
    val menu = arrayOf(Salad("Caesar Salad", 35.0), Salad("Chicken Salad", 20.0), Salad("Potato Salad", 25.0), Salad("Fruit Salad", 30.0), Drink("Coca Cola", 5.0), Drink("Orange Juice", 8.0), Drink("Ice Lemon Tea", 6.0))
    var sys = SaladAndDrinkOrderSystem(menu)
    sys.placeOrder()
}