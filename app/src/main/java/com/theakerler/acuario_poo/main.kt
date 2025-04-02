package com.theakerler.acuario_poo

import com.theakerler.acuario_poo.acuario.Acuario
import com.theakerler.acuario_poo.acuario.TanqueTorre

fun main() {
    var acuario: Acuario? = null  // Variable para almacenar el acuario creado

    while (true) {
        imprimirOpciones()
        print("Ingrese una opción: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            0 -> salir()
            2 -> acuario = crearAcuario()
            3 -> {
                if (acuario != null) {
                    mostrarDetalles(acuario)
                } else {
                    println("❌ Error: Primero debe crear un acuario.")
                }
            }
            4 -> {
                if (acuario != null) {
                    calcularPeces(acuario)
                } else {
                    println("❌ Error: Primero debe crear un acuario.")
                }
            }
            5 -> calcularDimensionesParaPeces()
            6 -> {
                if (acuario != null) {
                    modificarDimensiones(acuario)
                } else {
                    println("❌ Error: Primero debe crear un acuario.")
                }
            }
            7 -> {
                if (acuario != null) {
                    mostrarVolumenYAgua(acuario)
                } else {
                    println("❌ Error: Primero debe crear un acuario.")
                }
            }
            else -> println("❌ Opción no válida, intente nuevamente.")
        }
        pausa()
    }
}

fun imprimirOpciones() {
    repeat (30){ println("\n") }
    println("""
______________________________________________________________________
|---------------------------------------------------------------------|
        Escoge una opción:
        0 -> Salir
        2 -> Crear acuario
            2.1 -> Acuario rectangular
            2.2 -> Acuario cilíndrico
        3 -> Mostrar detalles completos del acuario
        4 -> Calcular cuántos peces puedo poner en mi acuario
        5 -> Calcular dimensiones de acuario para X peces
        6 -> Modificar dimensiones del acuario manualmente
        7 -> Mostrar solo el volumen y cantidad de agua del acuario
----------------------------------------------------------------------|
|____________________________________________________________________|
    """.trimIndent())
}

fun salir() {
    println("👋 Saliendo del programa...")
    System.exit(0) // Termina la ejecución del programa
}

fun pausa() {
    print("\nPresiona ENTER para continuar...")
    readLine()
}

fun crearAcuario(): Acuario {
    println("Seleccione el tipo de acuario:")
    println("1 -> Rectangular")
    println("2 -> Cilíndrico")
    print("Ingrese una opción: ")
    val tipo = readLine()?.toIntOrNull()

    return when (tipo) {
        1 -> {
            println("✅ Acuario rectangular creado con valores predeterminados.")
            Acuario()
        }
        2 -> {
            println("Ingrese el alto del tanque: ")
            val alto = readLine()?.toIntOrNull() ?: 40
            println("Ingrese el diámetro del tanque: ")
            val diametro = readLine()?.toIntOrNull() ?: 20
            println("✅ Acuario cilíndrico creado con alto $alto cm y diámetro $diametro cm.")
            TanqueTorre(alto, diametro)
        }
        else -> {
            println("❌ Opción no válida. Se creará un acuario rectangular por defecto.")
            Acuario()
        }
    }
}

fun mostrarDetalles(acuario: Acuario) {
    println("📌 Detalles del acuario:")
    acuario.imprimirTamano()
}

fun calcularPeces(acuario: Acuario) {
    val peces = acuario.volumen * 1000 / (2000 * 1.1) // Cada pez necesita 2200 cm³
    println("🐠 Puedes colocar aproximadamente ${peces.toInt()} peces en tu acuario.")
}

fun calcularDimensionesParaPeces() {
    print("Ingrese la cantidad de peces que desea colocar: ")
    val numeroPeces = readLine()?.toIntOrNull() ?: return
    val tanque = Acuario(numeroDePeces = numeroPeces)
    println("📏 Para $numeroPeces peces, se recomienda un acuario con las siguientes dimensiones:")
    tanque.imprimirTamano()
}

fun modificarDimensiones(acuario: Acuario) {
    print("Ingrese el nuevo ancho: ")
    acuario.ancho = readLine()?.toIntOrNull() ?: acuario.ancho
    print("Ingrese el nuevo largo: ")
    acuario.largo = readLine()?.toIntOrNull() ?: acuario.largo
    print("Ingrese el nuevo alto: ")
    acuario.alto = readLine()?.toIntOrNull() ?: acuario.alto
    println("✅ Dimensiones actualizadas.")
    acuario.imprimirTamano()
}

fun mostrarVolumenYAgua(acuario: Acuario) {
    println("📦 Volumen total: ${acuario.volumen} litros")
    println("💦 Cantidad de agua: ${acuario.agua} litros")
}
