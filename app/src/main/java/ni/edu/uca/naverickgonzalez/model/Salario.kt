package ni.edu.uca.naverickgonzalez.model

import java.math.RoundingMode

class Salario(
    salNeto: Double,
        ) {
    val impInss = 0.7
    val salFin = redondear(salNeto*impInss)
    val aPagar = redondear(salNeto-salFin)
}

private fun redondear(don: Double) : Double {
    return don.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
}
