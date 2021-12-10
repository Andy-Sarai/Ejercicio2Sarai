package com.tallercompumovil.ejercicio2sarai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.tallercompumovil.ejercicio2sarai.model.Anime

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val bundle = intent.extras

        val lista_datos = bundle?.getIntegerArrayList("lista_menor")
        if(lista_datos!=null){
            lista_datos.sorted().forEach{
                Log.d("Valores","Valor recibido: $it")
            }
        }
        val datos = ArrayList<Anime>()
        if (lista_datos != null) {
            for (i in lista_datos.sorted().toSet()){//i es cada elemento en la lista en este caso toma cada caracter
                //val animeTmp = Anime(i.toLong(), "Numero $i: $lista")
                val animeTmp = Anime(i.toLong(), "Número: $i ")
                datos.add(animeTmp)
            }
            val lv = findViewById<ListView>(R.id.lv)
            lv.adapter = Adaptador2(this, datos)
            Toast.makeText(this,resources.getString(R.string.Repetidos), Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,resources.getString(R.string.error), Toast.LENGTH_SHORT).show()
        }

    }
}