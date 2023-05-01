package com.dayv1dx.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var btn_calcular: Button
    lateinit var edt_peso: EditText
    lateinit var edt_altura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calcular = findViewById(R.id.btn_calcular)
        edt_peso = findViewById(R.id.edit_peso)
        edt_altura = findViewById(R.id.edt_altura)

        btn_calcular.setOnClickListener {

            val intent = Intent(this, ResultadoActivity::class.java)

            val peso = edt_peso.text.toString()
            val altura = edt_altura.text.toString()

            if(peso.isNotEmpty() && altura.isNotEmpty()){

                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }

            startActivity( intent )
        }
    }
}