class Drink(itemName: String, public var basePrice: Double) : Item(itemName) {
    public var size: Char = 'S'

    constructor(itemName: String, basePrice: Double, size: Char) : this(itemName, basePrice) {
        this.size = size
    }

    companion object {
        @JvmStatic
        private fun getSizePrice(basePrice: Double, size: Char): Double {
            return when (size) {
                'M' -> basePrice * 1.5
                'L' -> basePrice * 2
                else -> basePrice
            }
        }
    }

    override fun showItemDetails(): String {
        return "$itemName\t | S: $basePrice M: ${getSizePrice(basePrice, 'M')} L: ${getSizePrice(basePrice, 'L')}"
    }


    override fun calculateOrderPrice(): Double {
        return getSizePrice(basePrice, size)
    }

    override fun showOrderDetails(): String {
        return """Item Name: $itemName
            |size: $size
            |Order Price: $${calculateOrderPrice()}
        """.trimMargin()
    }
}