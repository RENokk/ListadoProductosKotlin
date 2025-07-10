
import java.net.HttpURLConnection
import java.net.URL
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val currency: String,
    @SerializedName("in_stock") val inStock: Boolean
)

data class ProductResponse(
    val products: List<Product>
)

fun main() {
    val apiUrl = "https://jsonkeeper.com/b/MX0A"
    val url = URL(apiUrl)
    val connection = url.openConnection() as HttpURLConnection

    try {
        connection.requestMethod = "GET"
        connection.connect()

        if (connection.responseCode == 200) {
            val inputStream = connection.inputStream.bufferedReader().readText()
            val gson = Gson()
            val productResponse = gson.fromJson(inputStream, ProductResponse::class.java)

            println("Listado de productos:")
            for (product in productResponse.products) {
                println("${'$'}{product.name} - ${'$'}{product.price} ${'$'}{product.currency}")
            }
        } else {
            println("Error al obtener los productos. Código: ${'$'}{connection.responseCode}")
        }
    } catch (e: Exception) {
        println("Ocurrió un error: ${'$'}{e.message}")
    } finally {
        connection.disconnect()
    }
}
