package dev.ren.mathnz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class finalScore : AppCompatActivity() {

    lateinit var Score : TextView
    lateinit var PlayAgain : Button
    lateinit var Exit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_score)

        Score = findViewById(R.id.textViewFinalScore)
        PlayAgain = findViewById(R.id.buttonPlayAgain)
        Exit = findViewById(R.id.buttonExit)

        val score = intent.getIntExtra("Score",0)
        Score.text = score.toString()


        PlayAgain.setOnClickListener{

            val intent = Intent(this@finalScore,MainActivity::class.java)
            startActivity(intent)

        }

        Exit.setOnClickListener{

            val intent = Intent(this@finalScore,MainActivity::class.java)
            startActivity(intent)

        }


    }
}