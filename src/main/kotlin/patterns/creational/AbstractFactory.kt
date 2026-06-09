package patterns.creational

interface ProductoMotor {
    fun tipo(): String
}

interface ProductoPanel {
    fun tema(): String
}

interface AbstractFactory {
    fun crearMotor(): ProductoMotor
    fun crearPanel(): ProductoPanel
}

class MotorDeportivo : ProductoMotor {
    override fun tipo(): String = "Motor deportivo"
}
class PanelDeportivo : ProductoPanel {
    override fun tema(): String = "Panel negro"
}
class FabricaDeportiva : AbstractFactory {
    override fun crearMotor(): ProductoMotor = MotorDeportivo()
    override fun crearPanel(): ProductoPanel = PanelDeportivo()
}

class MotorElectrico : ProductoMotor {
    override fun tipo(): String = "Motor eléctrico"
}
class PanelEcologico : ProductoPanel {
    override fun tema(): String = "Panel verde"
}
class FabricaEcologica : AbstractFactory {
    override fun crearMotor(): ProductoMotor = MotorElectrico()
    override fun crearPanel(): ProductoPanel = PanelEcologico()
}

class AbstractFactoryDemo {
    fun ejecutar(fabrica: AbstractFactory): String {
        val motor = fabrica.crearMotor()
        val panel = fabrica.crearPanel()
        return "Configuración: ${motor.tipo()} + ${panel.tema()}"
    }
}

fun main() {
    val demo = AbstractFactoryDemo()

    println("Deportivo  " + demo.ejecutar(FabricaDeportiva()))
    println("Eléctrico  " + demo.ejecutar(FabricaEcologica()))
}
