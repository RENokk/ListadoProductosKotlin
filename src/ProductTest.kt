import org.junit.Assert.*
import org.junit.Test

class ProductTest {

    @Test
    fun testProductosDisponibles() {
        val productos = listOf(
            Product(1, "iPhone 13", "The latest iPhone from Apple", 999.99, "USD", true),
            Product(2, "Samsung Galaxy S21", "The latest Samsung phone", 899.99, "USD", true)
        )
        assertTrue("El listado no debería estar vacío", productos.isNotEmpty())
    }

    @Test
    fun testListadoVacio() {
        val productos = emptyList<Product>()
        assertTrue("El listado está vacío, no se debe mostrar nada", productos.isEmpty())
    }
}
