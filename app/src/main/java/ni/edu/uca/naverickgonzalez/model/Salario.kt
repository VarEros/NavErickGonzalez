package ni.edu.uca.naverickgonzalez.model

class Salario(
    val salNeto: Double,
    val impInss: Double,
    var salFin: Double,
    var aPagar: Double
        ) {
    fun calcularSalario() {
        this.salFin = this.salNeto*this.impInss
        this.aPagar = this.salFin-this.salNeto
    }
}