package com.matesdev.cargamospersonas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //Declaracion de ojbetos lateint var: Declara variables que no se inicializan hasta que sean usadas
    private lateinit var nombre: EditText
    private lateinit var apellido: EditText
    private lateinit var buttonSend: Button
    private lateinit var buttonEnviar: Button
    private lateinit var listPerson: ListView


    private val personList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById<EditText>(R.id.edNombre)
        apellido = findViewById<EditText>(R.id.edApellido)
        buttonSend = findViewById<Button>(R.id.btSend)
        buttonEnviar = findViewById<Button>(R.id.btEnviar)


        // para trabajar con el adapter
        listPerson = findViewById<ListView>(R.id.idListView)

        buttonSend.setOnClickListener {
            val firstName = nombre.text.toString()
            val lastName = apellido.text.toString()

            //declaro la variable del adapter y le asigno el array deseado para luego **agregar datos**
            var adapterPersonas = ArrayAdapter(this, android.R.layout.simple_list_item_1, personList)
            //se da la orden para que, lo que suceda dentro del adapter, seguarde dentro de listPerson y pueda ser mostrado en el list view
            listPerson.adapter = adapterPersonas



            if( nombre.text.isEmpty() || apellido.text.isEmpty()){
                Toast.makeText(this, "Por favor ingrese el nombre y/o apellido", Toast.LENGTH_SHORT).show()

            }else{
                val persona = " $firstName $lastName"

                // se **agregan datos al array que a su vez está dentro del adapter**
                personList.add(persona)

                //Comentario de lo sucedido
                Toast.makeText(this, "Persona agregada: $persona", Toast.LENGTH_SHORT).show()

                //Guardo cambios en el adapter para que se vea reflejado dentro del listPerson y se muestre en el listView
                adapterPersonas.notifyDataSetChanged()

                // Clear EditText
                nombre.text.clear()
                apellido.text.clear()


            }

            buttonEnviar.setOnClickListener {
                // Llamo a la actividad 2
                val intent = Intent(this, MainActivity2::class.java)
                intent.putStringArrayListExtra("personas", personList)
                startActivity(intent)
            }





        }



    }
}