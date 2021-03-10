//JUAN CAMILO GONZALEZ BERRIO
//COD: 1735277-2711
package com.example.superheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.graphics.drawable.toBitmap
import com.example.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding:ActivityMainBinding  //llamado al viewbinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //esta parte es un intent EXPLICITO porque le estamos diciend oque vamos a coger y pa donde lo vamos a mandar
        viewBinding = ActivityMainBinding.inflate(layoutInflater)   // aca se le dice al viewbinding de donde saca las cosas
        setContentView(viewBinding.root)

        viewBinding.btnSend.setOnClickListener {
            val intent = Intent(this,VerDatosActivity::class.java)  //aqui ponemos de donde se saca y a donde entra (sale de this y enta en verdatos)
            val hero:String = viewBinding.etHeroName.text.toString()   //aca le decimos al viewbinding que saque la info del editText y lo conevierta en string y lo guarde en hero
            val power:Float = viewBinding.rbPower.rating
            val bitmap:Bitmap = viewBinding.ivPhoto.drawable.toBitmap()  //aca estamos sacando la imagen del componete grafico  *1
            intent.putExtra(VerDatosActivity.HERO_KEY, hero)  //con esto se sacan los datos que necesitamos
            intent.putExtra(VerDatosActivity.POWER_KEY, power)
            intent.putExtra(VerDatosActivity.IMAGE_KEY, bitmap)  //aca recibimos el objeto que definimos en                     *1
            startActivity(intent)  //con esto se ejecuta

        }
        //en esta parte vamos a hacer un intent IMPLICITO
        viewBinding.ivPhoto.setOnClickListener{  //declaramos al binding para acceder a la camara
            val intentImplicito = Intent(MediaStore.ACTION_IMAGE_CAPTURE)  //le decimos al intent que necesitamos acceder a la camara y tomar
            startActivityForResult(intentImplicito, 8)  //con este ejecutadar podemos ejecutarlo y luego volver a la MainActivity
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==8 && resultCode==Activity.RESULT_OK){  //aca le decimos que si coincide con el codigo y resulta ok pos puede continuar
            val imagen:Bundle? = data?.extras    //aca estamos creando donde vamos a almacenar la imagen obtenida
            val heroImage:Bitmap? = imagen?.getParcelable<Bitmap>("data")    //aca le asignamos a nuestro heroImage lo que obtuvimos anteriormente
            viewBinding.ivPhoto.setImageBitmap(heroImage)  //aca le asignamos al imageView de la fotico pos la foto que acabamos de guardar

        }
    }
}