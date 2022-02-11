package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    private lateinit var trueButton:Button
    private lateinit var falseButton:Button
    private lateinit var questionTextView:TextView
    private lateinit var nextButton: Button
    private lateinit var backButton:Button

    private val questionBank = listOf(Question(R.string.question_russia, true),
        Question(R.string.name_france, true),
        Question(R.string.question_babamasha, false),
        Question(R.string.question_baikal, true),
        Question(R.string.question_usa, false)
        )

    private var currentIndex=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.app_name);
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show()
        trueButton=findViewById(R.id.true_button)
        falseButton=findViewById(R.id.false_button)
        questionTextView=findViewById(R.id.question_text_view)
        nextButton=findViewById(R.id.next_button)
        backButton=findViewById((R.id.back_button))

        updateQuestion()

        trueButton.setOnClickListener{view:View->
//            var toast:Toast = Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_LONG)
//            toast.setGravity(Gravity.TOP, 0, 0)
//            toast.show()
//
//            if(questionBank[currentIndex].answer==true){
//                var toast:Toast = Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG)
//                toast.setGravity(Gravity.TOP, 0, 0)
//                toast.show()
//            }

            CheckAnswer(true)
        }

        falseButton.setOnClickListener{view:View->
//            var toast:Toast = Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_LONG)
//            toast.setGravity(Gravity.TOP, 0, 0)
//            toast.show()
//
//            if(questionBank[currentIndex].answer==false){
//                var toast:Toast = Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG)
//                toast.setGravity(Gravity.TOP, 0, 0)
//                toast.show()
//            }
            CheckAnswer(false)
        }

        nextButton.setOnClickListener(){view:View ->
            currentIndex=(currentIndex+1)%questionBank.size
            updateQuestion()
        }

        backButton.setOnClickListener(){view:View ->
            currentIndex=(currentIndex-1)%questionBank.size
            updateQuestion()
        }
    }
    private fun updateQuestion(){
        val questionTextResId=questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun CheckAnswer(userAnswer:Boolean){
        val correctAnswer=questionBank[currentIndex].answer
        var messageResId=if(userAnswer==correctAnswer){
            R.string.correct_toast
        }
        else{
            R.string.incorrect_toast
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show()
    }
}