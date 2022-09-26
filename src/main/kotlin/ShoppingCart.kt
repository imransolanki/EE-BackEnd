class ShoppingCart(val taxRate: Double) {

    private val products = HashMap<Product, Int>()

    fun add(product: Product, quantity: Int) {

        if (products.containsKey(product)) {
            products[product] = quantity + products[product]!!
        } else {
            products[product] = quantity
        }
    }

    fun getQuantity(product: Product): Int? = products[product]

    fun getTotalPrice(): Double {
        var total = 0.0
        products.forEach { (product, quantity) ->
            total += quantity * product.price
        }
        return total
    }

    fun getTotalTaxAmount(): Double =
        Math.ceil(
            getTotalPrice() * (taxRate / 100)
        )

    fun getBillAmount(): Double = getTotalPrice() + getTotalTaxAmount()

}
