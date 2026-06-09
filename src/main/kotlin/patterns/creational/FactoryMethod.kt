package patterns.creational

interface Product {
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
