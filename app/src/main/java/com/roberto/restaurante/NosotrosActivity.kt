package com.roberto.restaurante

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NosotrosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nosotros)

        val txtNosotros: TextView = findViewById(R.id.txtNosotros)
        txtNosotros.text = """
            Bienvenidos a nuestro restaurante de comida rápida.
            Ofrecemos una variedad de platillos deliciosos y preparados con los mejores ingredientes.
            ¡Gracias por elegirnos!
        """.trimIndent()
    }
}
