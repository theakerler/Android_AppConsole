package com.theakerler.acuario_poo.acuario
import kotlin.math.PI


open class Acuario(open var largo:Int = 100, open var ancho:Int = 20, open var alto:Int = 40) {
    open var volumen: Int
        get() = ancho * alto * largo / 1000  // 1000 cm^3 = 1 l
        set(valor) {
            alto = (valor *1000) / (ancho * largo)
        }
    open var forma = "Rectangulo"
    open var agua: Double = 0.0
        get() = volumen * 0.9

    init {
        println("inicializando acuario")
    }
    constructor(numeroDePeces: Int) : this() {
        // 2,000 cm^3 por pez + espacio extra para que no se derrame
        val tanque = numeroDePeces * 2000 * 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }

    fun imprimirTamano() {
        println(forma)
        println("Ancho: $ancho cm " +
                "Largo: $largo cm " +
                "Alto: $alto cm ")
        println("Volumen: $volumen l Agua: $agua l (${agua/volumen*100.0}% lleno)")
    }

}



















