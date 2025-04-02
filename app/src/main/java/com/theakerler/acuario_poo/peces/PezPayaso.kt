package com.theakerler.acuario_poo.peces


class PezPayaso : Pez(), AccionPez {
    override val color: String
        get() = "dorado"
    override fun comer() {
        println("Comer algas")
    }
}