package com.theakerler.acuario_poo.peces

class Tiburón : Pez(), AccionPez {
    override val color: String
        get() = "gris"
    override fun comer(){
        println("Cazar y comer peces")
    }
}