package dev.ren.mathnz
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PrimaryActivity : AppCompatActivity() {


    lateinit var addition : Button
    lateinit var subtraction : Button
    lateinit var multiplication : Button
    lateinit var division : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primary)


        addition = findViewById(R.id.paddition)
        subtraction = findViewById(R.id.psubstraction)
        multiplication = findViewById(R.id.pmultiplication)
        division = findViewById(R.id.pdivision)

        addition.setOnClickListener{

            val intent = Intent(this@PrimaryActivity,Basic_Addition::class.java)
            startActivity(intent)

        }

        subtraction.setOnClickListener{

            val intent = Intent(this@PrimaryActivity,Basic_Subtraction::class.java)
            startActivity(intent)


        }

        multiplication.setOnClickListener{

            val intent = Intent(this@PrimaryActivity,Basic_Multiplication::class.java)
            startActivity(intent)
        }

        division.setOnClickListener{

            val intent = Intent(this@PrimaryActivity,Basic_Division::class.java)
            startActivity(intent)

        }

    }
}