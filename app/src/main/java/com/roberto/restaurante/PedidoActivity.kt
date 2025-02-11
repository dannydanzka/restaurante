package com.roberto.restaurante

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PedidoActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtDomicilio: EditText
    private lateinit var spnProducto: Spinner
    private lateinit var spnTamano: Spinner
    private lateinit var edtTelefono: EditText
    private lateinit var btnRegistrar: Button
    private lateinit var btnCancelar: Button
    private lateinit var productoSeleccionado: String
    private lateinit var tamanoSeleccionado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        edtNombre = findViewById(R.id.edtNombre)
        edtDomicilio = findViewById(R.id.edtDomicilio)
        spnProducto = findViewById(R.id.spnProducto)
        spnTamano = findViewById(R.id.spnTamano)
        edtTelefono = findViewById(R.id.edtTelefono)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnCancelar = findViewById(R.id.btnCancelar)

        // Configuración del Spinner de Productos
        val productos = resources.getStringArray(R.array.productos)
        val adaptadorProductos = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, productos)
        spnProducto.adapter = adaptadorProductos
        productoSeleccionado = productos[0]

        spnProducto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                productoSeleccionado = productos[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Configuración del Spinner de Tamaño
        val tamanos = resources.getStringArray(R.array.tamanos)
        val adaptadorTamanos = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tamanos)
        spnTamano.adapter = adaptadorTamanos
        tamanoSeleccionado = tamanos[0]

        spnTamano.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tamanoSeleccionado = tamanos[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btnRegistrar.setOnClickListener { registrarPedido() }
        btnCancelar.setOnClickListener { finish() }
    }

    private fun registrarPedido() {
        if (edtNombre.text.isNotBlank() && edtDomicilio.text.isNotBlank() && edtTelefono.text.isNotBlank()) {
            val sharedPreferences = getSharedPreferences("MisCompras", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("pedido_nombre", edtNombre.text.toString())
            editor.putString("pedido_domicilio", edtDomicilio.text.toString())
            editor.putString("pedido_producto", productoSeleccionado)
            editor.putString("pedido_tamano", tamanoSeleccionado)
            editor.putString("pedido_telefono", edtTelefono.text.toString())
            editor.apply()

            Toast.makeText(this, "Pedido registrado correctamente", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}
