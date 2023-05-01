package com.dayv1dx.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.DecimalFormat

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textALtura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textALtura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)


        val bundle: Bundle? = intent.extras
        if (bundle != null){

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado $peso kg"
            textALtura.text = "Altura informada $altura m"

            val resultado = peso /(altura * altura)
            val df = DecimalFormat("#.#")

            val imc = df.format(resultado)

            textResultado.text = if( resultado < 18.5){
                "Baixo\n IMC = $imc"
            } else if(resultado in 18.5 .. 24.9){
                "Normal\n IMC = $imc"
            } else if (resultado in 25.0 .. 29.9){
                "Sobrepeso\n IMC = $imc"
            } else{
                "Obeso\n IMC = $imc"
            }

        }
    }
}