package com.mag.facebee.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mag.facebee.R
import com.mag.facebee.login.LoginActivityLogin

class ForgotPassActivity : AppCompatActivity() {

    private lateinit var txtEmail: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var progressbar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        txtEmail=findViewById(R.id.txtEmail)
        auth = FirebaseAuth.getInstance()

        progressbar= findViewById(R.id.progressBar)
    }

    fun send(view: View){

        val email=txtEmail.text.toString()

        if (!TextUtils.isEmpty(email)){
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this){
                        task ->
                    if (task.isSuccessful){
                        progressbar.visibility= View.VISIBLE
                        startActivity(Intent(this, LoginActivity::class.java))
                        Toast.makeText(this, "Se ha enviado un mail para reestablecer su contraseña.", Toast.LENGTH_LONG).show()
                        progressbar.visibility=View.INVISIBLE
                        finishAffinity()

                    }else{
                        Toast.makeText(this, "Error al enviar el email", Toast.LENGTH_LONG).show()
                        progressbar.visibility=View.INVISIBLE

                    }

                }
        }
    }
 }
