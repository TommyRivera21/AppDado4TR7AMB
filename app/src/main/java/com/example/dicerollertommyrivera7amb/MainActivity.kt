package com.example.dicerollertommyrivera7amb

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**

    Esta actividad permite al usuario tirar un dado y ver el resultado.
    en la pantalla.

 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
        /** Hace una tirada de dados cuando se inicie la aplicación */
        rollDice()
    }

    /**
     *
     *  Tira el dado el dado y muestra su resultado
     * */
    private fun rollDice() {
        /** Crea un nuevo objeto dado de 6 lados y lo lanza */
        val dice = Dice(6)
        val diceRoll = dice.roll()

        /** Encuentra la imagen acorde al numero */
        val diceImage: ImageView = findViewById(R.id.imageView)

        /** Determina qué ID de recurso extraíble usar en función de la tirada de dados */
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        /** Actualiza ImageView con el ID de recurso dibujable correcto */
        diceImage.setImageResource(drawableResource)

        /** Actualizar la descripción del contenido */
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}