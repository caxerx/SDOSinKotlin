class Salad(itemName: String, public val pricePer100g: Double) : Item(itemName) {
    public var weight: Int = 0

    constructor(itemName: String, pricePer100g: Double, weight: Int) : this(itemName, pricePer100g) {
        this.weight = weight
    }

    override fun showItemDetails(): String {
        return "$itemName\t | $pricePer100g per 100g"
    }

    override fun calculateOrderPrice(): Double {
        return (weight / 100.0) * pricePer100g
    }

    override fun showOrderDetails(): String {
        return """Item Name: $itemName
            |Weight: $weight g
            |Order Price: ${calculateOrderPrice()}
        """.trimMargin()
    }

}