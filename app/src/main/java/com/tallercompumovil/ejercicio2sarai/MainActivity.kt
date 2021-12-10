package com.tallercompumovil.ejercicio2sarai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var etNumber: EditText
    private lateinit var textView: TextView
    private lateinit var textViewMayor: TextView

    val lista_datos = ArrayList<Int>() //Lista
    //val lista_mayor = ArrayList<Int>() //Lista de Mayor a Menor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber = findViewById(R.id.etNumber)
        etNumber.typeface = ResourcesCompat.getFont(this,R.font.trek)

        //Lista
        textView =findViewById(R.id.tView)
        //Mayor a menor
        textViewMayor=findViewById(R.id.tViewMayor)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btGuardar->{
                if(etNumber.text.toString()==""){
                    Toast.makeText(this, resources.getString(R.string.requiere_inf), Toast.LENGTH_SHORT).show()
                    etNumber.error = getString(R.string.requiere_inf)
                }else{
                    if(etNumber.text.toString().length < 5) {
                        Toast.makeText(this,resources.getString(R.string.error),Toast.LENGTH_SHORT).show()
                        etNumber.error = getString(R.string.error)
                    }else{
                        val numero = etNumber.text.toString().toInt()
                        lista_datos.add(numero)
                        //println(lista_datos)
                        //textView.setText("$lista_datos")
                    }
                }
            }
            R.id.btMayor->{//Mayor a Menor
                if (etNumber.text.toString()==""){
                    Toast.makeText(this, resources.getString(R.string.requiere_inf), Toast.LENGTH_SHORT).show()
                    etNumber.error = getString(R.string.requiere_inf)
                }else {
                    val bundle = Bundle()
                    //val lista_mayor = lista_datos.sortedDescending()
                    //println(lista_datos.sortedDescending().toSet())
                    //textViewMayor.setText("$lista_mayor")//ver en pantalla la lista de numeros introducidos

                    bundle.putIntegerArrayList("lista_datos", lista_datos)
                    //bundle.putIntegerArrayList("lista_datos", lista_mayor)

                    val ventana_solicitud = Intent(this, MainActivity2::class.java)
                    ventana_solicitud.putExtras(bundle)
                    startActivity(ventana_solicitud)

                }
            }
            R.id.btMenor-> {//Menor a Mayor
                if (etNumber.text.toString()==""){
                    Toast.makeText(this, resources.getString(R.string.requiere_inf), Toast.LENGTH_SHORT).show()
                    etNumber.error = getString(R.string.requiere_inf)
                }else {
                    val bundle = Bundle()
                    //val lista_Menor = lista_datos.sorted()
                    println(lista_datos.sorted())

                    bundle.putIntegerArrayList("lista_menor", lista_datos)

                    val ventana_solicitud = Intent(this, MainActivity3::class.java)
                    ventana_solicitud.putExtras(bundle)
                    startActivity(ventana_solicitud)
                }
            }
        }
    }
}
