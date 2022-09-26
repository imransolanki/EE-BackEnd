import org.junit.Test
import kotlin.test.assertEquals

class ShoppingCartTest {
    @Test
    fun `add products to shopping cart`() {
        val cart = ShoppingCart(0.0)
        val product = Product("Dove Soap", 39.99)

        cart.add(product, 5)

        assertEquals(cart.getQuantity(product), 5)
        assertEquals(product.price, 39.99)
        assertEquals(cart.getTotalPrice(), 199.95, absoluteTolerance = 0.2)
    }

    @Test
    fun `add addition products of the same type`() {
        val cart = ShoppingCart(0.0)
        val product = Product("Dove Soap", 39.99)

        cart.add(product, 5)
        cart.add(product, 3)

        assertEquals(cart.getQuantity(product), 8)
        assertEquals(product.price, 39.99)
        assertEquals(cart.getTotalPrice(), 319.92, absoluteTolerance = 0.2)
    }

    @Test
    fun `calculate tax rate of the shopping cart with multiple items`() {
        val cart = ShoppingCart(taxRate = 12.5)
        val dove = Product("Dove Soap", 39.99)
        val axeDeo = Product("Axe Deo", 99.99)

        cart.add(dove, 2)
        cart.add(axeDeo, 2)

        assertEquals(cart.getQuantity(dove), 2)
        assertEquals(dove.price, 39.99)

        assertEquals(cart.getQuantity(axeDeo), 2)
        assertEquals(axeDeo.price, 99.99)

        assertEquals(cart.getTotalTaxAmount(), 35.00)
        assertEquals(cart.getBillAmount(), 314.96)
    }
}