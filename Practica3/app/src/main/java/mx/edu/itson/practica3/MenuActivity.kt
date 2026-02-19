package mx.edu.itson.practica3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnAntojitos: Button = findViewById(R.id.btn_antojitos)

        btnAntojitos.setOnClickListener {
            Toast.makeText(this, "CLICK", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ProductosActivity::class.java).putExtra("menuType","Antojitos"))
        }
    }
}
