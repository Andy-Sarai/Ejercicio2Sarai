package com.tallercompumovil.ejercicio2sarai

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.tallercompumovil.ejercicio2sarai.model.Anime

class Adaptador2(private val contexto: Context, val datos: ArrayList<Anime>): BaseAdapter()  {
    private val inflater: LayoutInflater = LayoutInflater.from(contexto)

    override fun getCount(): Int {//elementos que hay que pintar en pantalla tantos como tenga el Array List Anime
        return datos.size
    }

    override fun getItem(position: Int): Any {//regresa el item de una posicion en particular
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return datos[position].id
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val vista = inflater!!.inflate(R.layout.elemento_lista, null)
        val tvPosicion = vista.findViewById<TextView>(R.id.tvPosicion)
        tvPosicion.text = datos[position].posicion
        return vista

    }
}