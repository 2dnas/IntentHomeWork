package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class FinishActivity : AppCompatActivity() {
    private lateinit var nameText: TextView
    private lateinit var ageText: TextView
    private lateinit var emailText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        nameText = findViewById(R.id.textView)
        ageText = findViewById(R.id.textView2)
        emailText = findViewById(R.id.email_text_view)


        nameText.text = intent.extras?.getString("name")
        ageText.text = intent.extras?.getInt("age").toString()
        emailText.text = intent.extras?.getString("email","mail")

    }
}