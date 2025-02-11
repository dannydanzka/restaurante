package com.roberto.restaurante

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PlatillosActivity : AppCompatActivity() {

    private lateinit var listaPlatillos: ListView
    private val platillos = arrayOf(
        "Hamburguesa - $50",
        "Pizza - $80",
        "Hot Dog - $30",
        "Ensalada - $40",
        "Tacos - $60"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platillos)

        listaPlatillos = findViewById(R.id.listaPlatillos)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, platillos)
        listaPlatillos.adapter = adaptador

        listaPlatillos.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, platillos[position], Toast.LENGTH_SHORT).show()
        }
    }
}
