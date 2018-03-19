abstract class Item(public var itemName: String) {
    abstract fun showItemDetails(): String
    abstract fun calculateOrderPrice(): Double
    abstract fun showOrderDetails(): String
}