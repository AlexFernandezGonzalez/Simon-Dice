package com.alex.simondice

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button // Sin esto no podemos usar el botón
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private var contador: Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bR: Button = findViewById(R.id.bR)
        var bV: Button = findViewById(R.id.bV)
        var bAz: Button = findViewById(R.id.bAz)
        var bA: Button = findViewById(R.id.bA)


          //Creamos la varible para contar las rondas
        val jugar: Button = findViewById(R.id.bJugar)

        var random: Int = (0..3).random()
        var colores: Array<String> = arrayOf("Rojo","Verde","Azul","Amarillo")
        var secuencia: Array<String> = arrayOf()
        var rondaInterna: Int = 1

        jugar.setOnClickListener{

            //Al darle al botón de 'Jugar!' se va a ejecutar esto
            Log.i("Estado","El usuario le dio a jugar")

           //Lógica de la partida en si


            mostrarRondas()

            //Usamos la corrutina
            val job= GlobalScope.launch(Dispatchers.Main){
                crearSecuencia()
            }




        }






    }

    private fun mostrarRondas(){
        Log.i("Estado","Muestra las rondas")
        val t:TextView=findViewById(R.id.contador)
        t.setText("Ronda: "+contador.toString())


    }

    private fun comprobar(){
        Log.i("Estado","Comprobamos si el jugador introdujo bien la secuencia")

        if("secuencia"=="secuencia_jugador"){
            contador+1
        }
        else{
            contador=0
            //El juego se acaba
            //Mensaje que ponga que el juego se acabó y el nº de rondas que consiguió
        }
    }

    suspend fun crearSecuencia(){
        Log.i("Estado","Se crea la secuencia")
        //Creamos la secuencia
        //Esperamos a que el usuario haga la suya
        //Comprobamos si está bien o no
        comprobar()
    }


}


