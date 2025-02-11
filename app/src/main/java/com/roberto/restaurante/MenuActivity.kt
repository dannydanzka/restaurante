package com.roberto.restaurante

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)  // Asegurar que la Toolbar se use como ActionBar
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itmPedido -> startActivity(Intent(this, PedidoActivity::class.java))
            R.id.itmPlatillos -> startActivity(Intent(this, PlatillosActivity::class.java))
            R.id.itmMisCompras -> startActivity(Intent(this, MisComprasActivity::class.java))
            R.id.itmNosotros -> startActivity(Intent(this, NosotrosActivity::class.java))
            R.id.itmCerrarSesion -> cerrarSesion()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun cerrarSesion() {
        val preferences: SharedPreferences = getSharedPreferences("preferenciasUsuario", MODE_PRIVATE)
        preferences.edit().clear().apply()

        val intent = Intent(this, IngresoActivity::class.java)
        startActivity(intent)
        finish()
    }
}
