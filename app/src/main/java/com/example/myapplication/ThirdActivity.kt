package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {
    private lateinit var emailEditText : EditText
    private lateinit var emailButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        emailEditText = findViewById(R.id.email_edit_text)
        emailButton = findViewById(R.id.email_button)

        val name = intent.extras?.getString("name", "name")
        val age  = intent.extras?.getInt("age", 20)

        emailButton.setOnClickListener {
            val email = emailEditText.text.toString()
            if(validateEmail(email)) {
                val intent = Intent(this, FinishActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("age",age)
                intent.putExtra("email",email)
                startActivity(intent)

            }else {
                emailEditText.error = "Invalid Email"
            }

        }
    }
    private fun validateEmail(email: CharSequence) : Boolean {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}