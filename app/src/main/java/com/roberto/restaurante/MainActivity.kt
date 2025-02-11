package com.roberto.restaurante

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = if (esUsuarioGuardado()) {
                Intent(applicationContext, MenuActivity::class.java)
            } else {
                Intent(applicationContext, IngresoActivity::class.java)
            }
            startActivity(intent)
            finish()
        }, 2000)
    }

    private fun esUsuarioGuardado(): Boolean {
        val preferences: SharedPreferences = getSharedPreferences("preferenciasUsuario", MODE_PRIVATE)
        return preferences.getBoolean("guardado", false)
    }
}
