package com.tallercompumovil.ejercicio2sarai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.tallercompumovil.ejercicio2sarai.model.Anime

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle = intent.extras

        val lista_datos = bundle?.getIntegerArrayList("lista_datos")
        if(lista_datos!=null){
            lista_datos.sortedDescending().forEach{
                Log.d("Valores","Valor recibido: $it")
            }
        }

            //val xxx = arrayOf("Android","Php","hola","Juan")
/*
        if (lista != null) {
            for (item in lista) {
                val arrayAdapter: ArrayAdapter<String> =
                    ArrayAdapter(this, android.R.layout.simple_list_item_1, xxx)
                val lv = findViewById<ListView>(R.id.LV)
                lv.adapter = arrayAdapter
            }
        }
        */

        val datos = ArrayList<Anime>()
        if (lista_datos != null) {
            for (i in lista_datos.sortedDescending().toSet()){//i es cada elemento en la lista en este caso toma cada caracter
                //val animeTmp = Anime(i.toLong(), "Numero $i: $lista")
                val animeTmp = Anime(i.toLong(), "Número: $i ")
                datos.add(animeTmp)
            }
            val lv = findViewById<ListView>(R.id.LV)
            lv.adapter = Adaptador(this, datos)
            Toast.makeText(this,resources.getString(R.string.Repetidos), Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,resources.getString(R.string.error), Toast.LENGTH_SHORT).show()
        }

    }
}