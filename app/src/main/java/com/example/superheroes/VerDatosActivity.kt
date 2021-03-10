//JUAN CAMILO GONZALEZ BERRIO
//COD: 1735277-2711
package com.example.superheroes

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toBitmap
import com.example.superheroes.databinding.ActivityVerDatosBinding

class VerDatosActivity : AppCompatActivity() {
    private  lateinit var viewBinding: ActivityVerDatosBinding
    companion object{
        const val HERO_KEY = "heroe_key"   //declaramos las variables constantes con las que definimos los valores que se le va a dar
        const val POWER_KEY = "power_key"
        const val IMAGE_KEY = "image_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityVerDatosBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val intent:Bundle = intent.extras!!   //el bundle me almacena los datos en clave,valor
        viewBinding.tvSentName.text = intent.getString(HERO_KEY) //le decimos al viewbinding que ponga en el textView la info que coge de la constante HERO_KEY
        viewBinding.ratingBar.rating = intent.getFloat(POWER_KEY)
        viewBinding.sentPhoto.setImageBitmap(intent.getParcelable<Bitmap>(IMAGE_KEY))
    }
}