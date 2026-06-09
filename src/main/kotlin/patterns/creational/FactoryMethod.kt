package patterns.creational

/**
 * Interfaz que define el contrato de un Producto creado por el Factory Method.
 * Cualquier producto concreto debe implementar [descripcion], que retorna
 * una cadena describiendo el resultado o característica del producto.
 */
interface Producto {
    fun descripcion(): String
}

abstract class TallerPendiente {
    fun prepararPedido(): String {
        val producto = crearProducto()
        return "Pedido preparado para ${producto.descripcion()}"
    }

    abstract fun crearProducto(): Producto
}

class ProductoLocal : Producto {
    override fun descripcion(): String = "Producto local terminado"
}

class TallerLocal : TallerPendiente() {
    override fun crearProducto(): Producto = ProductoLocal()
}

class FactoryMethodDemo {
    fun ejecutar(): String {
        val taller: TallerPendiente = TallerLocal()
        return taller.prepararPedido()
    }
}
