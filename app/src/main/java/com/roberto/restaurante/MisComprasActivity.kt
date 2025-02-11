package com.roberto.restaurante

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MisComprasActivity : AppCompatActivity() {

    private lateinit var txtCompras: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_compras)

        txtCompras = findViewById(R.id.txtCompras)

        // Recuperar datos de SharedPreferences
        val sharedPreferences = getSharedPreferences("MisCompras", Context.MODE_PRIVATE)
        val nombre = sharedPreferences.getString("pedido_nombre", "No registrado")
        val domicilio = sharedPreferences.getString("pedido_domicilio", "No registrado")
        val producto = sharedPreferences.getString("pedido_producto", "No registrado")
        val tamano = sharedPreferences.getString("pedido_tamano", "No registrado")
        val telefono = sharedPreferences.getString("pedido_telefono", "No registrado")

        // Mostrar la información en el TextView
        txtCompras.text = """
            Pedido Registrado:
            Nombre: $nombre
            Domicilio: $domicilio
            Producto: $producto
            Tamaño: $tamano
            Teléfono: $telefono
        """.trimIndent()
    }
}
