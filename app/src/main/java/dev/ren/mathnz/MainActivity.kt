package dev.ren.mathnz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    lateinit var Primary : Button
    lateinit var Secondary: Button
    lateinit var exit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Primary = findViewById(R.id.ButtonPrimary)
        exit = findViewById(R.id.buttonTer)

        Primary.setOnClickListener{

            val intent = Intent(this@MainActivity,PrimaryActivity::class.java)
            startActivity(intent)
        }

        exit.setOnClickListener{


        }
    }
}