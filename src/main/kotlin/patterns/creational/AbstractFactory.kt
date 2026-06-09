package patterns.creational

interface Motor {
    fun tipo(): String
}

interface Panel {
    fun tema(): String
}

interface AbstractFactory {
    fun crearMotor(): Motor
    fun crearPanel(): Panel
}

class MotorDeportivo : Motor {
    override fun tipo(): String = "Motor deportivo"
}
class PanelDeportivo : Panel {
    override fun tema(): String = "Panel negro"
}
class FabricaDeportiva : AbstractFactory {
    override fun crearMotor(): Motor = MotorDeportivo()
    override fun crearPanel(): Panel = PanelDeportivo()
}


class MotorElectrico : Motor {
    override fun tipo(): String = "Motor eléctrico"
}
class PanelEcologico : Panel {
    override fun tema(): String = "Panel verde"
}
class FabricaEcologica : AbstractFactory {
    override fun crearMotor(): Motor = MotorElectrico()
    override fun crearPanel(): Panel = PanelEcologico()
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

    // Variante 1: familia deportiva — motor V8 + panel negro
    println("🏎️  " + demo.ejecutar(FabricaDeportiva()))

    // Variante 2: familia ecológica — motor eléctrico + panel verde
    println("🌱  " + demo.ejecutar(FabricaEcologica()))
}
