package com.example.superheroes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.superheroes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(LayoutInflater)   // <<<<---------ERROOOOR----------------
        setContentView(viewBinding.root)
        //setContentView(R.layout.activity_main)

        //var NombreHeroe = findViewById<EditText>(R.id.etNombreHeroe)
        //var boton = findViewById<Button>(R.id.btSend)

        viewBinding.btSend.setOnClickListener {
            //Toast.makeText(this, "enviaste tu heroe + $Personaje", Toast.LENGTH_LONG).show()
            var personaje:String = getString(R.string.notification, viewBinding.etNombreHeroe.text.toString())

            Snackbar.make(it,personaje, Snackbar.LENGTH_LONG).setAnchorView(R.id.btSend).show()
        }
    }
}