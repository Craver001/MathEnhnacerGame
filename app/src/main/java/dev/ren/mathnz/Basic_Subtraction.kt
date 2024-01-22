package dev.ren.mathnz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.random.Random

class Basic_Subtraction : AppCompatActivity() {

    lateinit var textScore: TextView
    lateinit var textLife: TextView
    lateinit var textTimer: TextView

    lateinit var textQuestion: TextView
    lateinit var textAnswer: EditText
    lateinit var buttonOK: Button
    lateinit var buttonNext: Button

    lateinit var Timer: CountDownTimer
    private val startTimerInMillis: Long = 60000
    var timeLeftInMillis: Long = startTimerInMillis

    var correctAnswer = 0
    var userScore = 0
    var userLife = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_asm)



        textScore = findViewById(R.id.textViewZero)
        textLife = findViewById(R.id.textView3)
        textTimer = findViewById(R.id.textView60)
        textQuestion = findViewById(R.id.textViewQuestion)
        textAnswer = findViewById(R.id.editTextNumber)
        buttonNext = findViewById(R.id.next)
        buttonOK = findViewById(R.id.ok)


        PrimaryGameAddition()



        buttonOK.setOnClickListener {

            val input = textAnswer.text.toString()

            if (input == "") Toast.makeText(
                applicationContext, "Please Write your answer",
                Toast.LENGTH_LONG
            ).show() else {
                val userAnswer = input.toIntOrNull()
                if (userAnswer == correctAnswer) {


                    textQuestion.text = "Congratulation, your answer is correct"
                    userScore = userScore + 1
                    textScore.text = userScore.toString()

                    textAnswer.setText("")

                    pauseTimer()
                    resetTimer()

                } else {
                    textQuestion.text = "Sorry your answer is wrong"
                    userLife--
                    textLife.text = userLife.toString()

                    textAnswer.setText("")

                    pauseTimer()
                    resetTimer()

                }

                if (userLife == 0) {

                    Toast.makeText(applicationContext, "Game Over", Toast.LENGTH_LONG).show()

                    val intent = Intent(this@Basic_Subtraction, finalScore::class.java)
                    intent.putExtra("Score", userScore)
                    startActivity(intent)
                } else {


                }

            }
        }

        buttonNext.setOnClickListener {

            if (userLife == 0) {
                Toast.makeText(applicationContext, "Game Over", Toast.LENGTH_LONG).show()

                val intent = Intent(this@Basic_Subtraction, finalScore::class.java)
                intent.putExtra("Score", userScore)
                startActivity(intent)
            } else {


                textAnswer.setText("")
                textQuestion.setText("")

                PrimaryGameAddition()


            }
        }
        buttonNext.setOnClickListener {

            if (userLife == 0) {
                Toast.makeText(applicationContext, "Game Over", Toast.LENGTH_LONG).show()

                val intent = Intent(this@Basic_Subtraction, finalScore::class.java)
                intent.putExtra("Score", userScore)
                startActivity(intent)
            } else {


                textAnswer.setText("")
                textQuestion.setText("")

                PrimaryGameAddition()

            }

        }


    }

    fun PrimaryGameAddition() {

        val number2 = Random.nextInt(0, 100)
        val number1 = Random.nextInt(0, 100)



        textQuestion.text = "$number1 - $number2"

        correctAnswer = number1 - number2

        startTimer()
    }

    fun startTimer() {

        Timer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                timeLeftInMillis = millisUntilFinished
                Updatetext()
            }

            override fun onFinish() {

                textQuestion.text = "Time's Up"
                userLife--
                textLife.text = userLife.toString()


            }


        }.start()

    }

    fun Updatetext() {

        val remainingTime: Int = (timeLeftInMillis / 1000).toInt()
        textTimer.text = String.format(Locale.getDefault(), "%02d", remainingTime)

    }

    fun resetTimer() {

        timeLeftInMillis = startTimerInMillis
        Updatetext()
    }

    fun pauseTimer() {

        Timer.cancel()

    }
}