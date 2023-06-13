package com.matesdev.cargamospersonas

import android.content.Intent
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    private lateinit var personasList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        personasList = findViewById(R.id.lsPersonas)
        // Aca guardo el array que recibo del activityMain 1
        val listaPersona = intent.getStringArrayListExtra("personas")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPersona!!)
        personasList.adapter = adapter

        personasList.setOnItemClickListener{ parent, view, position, id ->
            var item = listaPersona[position]

            item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, item, Toast.LENGTH_LONG).show()
        }

    }
}