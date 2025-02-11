package com.roberto.restaurante

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class IngresoActivity : AppCompatActivity() {

    private lateinit var edtCorreo: EditText
    private lateinit var edtContrasena: EditText
    private lateinit var swtGuardar: Switch
    private lateinit var btnIngresar: Button
    private lateinit var btnBorrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso) // Asegúrate de que `activity_ingreso.xml` existe

        edtCorreo = findViewById(R.id.edtCorreo)
        edtContrasena = findViewById(R.id.edtContrasena)
        swtGuardar = findViewById(R.id.swtGuardar)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnBorrar = findViewById(R.id.btnBorrar)

        btnIngresar.setOnClickListener { ingresar() }
        btnBorrar.setOnClickListener { limpiar() }
    }

    private fun ingresar() {
        if (edtCorreo.text.isNotBlank() && edtContrasena.text.isNotBlank()) {
            val usuario = Usuario(edtCorreo.text.toString(), edtContrasena.text.toString(), swtGuardar.isChecked)

            if (swtGuardar.isChecked) {
                guardarPreferencias(usuario)
            }

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Capturar información", Toast.LENGTH_LONG).show()
        }
    }

    private fun limpiar() {
        edtCorreo.text = null
        edtContrasena.text = null
        edtCorreo.requestFocus()
    }

    private fun guardarPreferencias(usuario: Usuario) {
        val preferences: SharedPreferences = getSharedPreferences("preferenciasUsuario", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("email", usuario.correo)
        editor.putString("password", usuario.contrasena)
        editor.putBoolean("guardado", usuario.guardado)
        editor.apply()
    }
}
