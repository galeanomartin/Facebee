package com.mag.facebee.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AbsListView
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mag.facebee.R

class AuthenticationActivity : AppCompatActivity() {

   /* private lateinit var txtUser: EditText
    private lateinit var txtPassword: EditText

    private lateinit var progressBar:ProgressBar
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        //reemplaza al login

        txtUser=findViewById(R.id.txtUser)
        txtPassword=findViewById(R.id.txtPassword)

        progressBar = findViewById(R.id.progressBar)
        auth=FirebaseAuth.getInstance()
    }

    fun forgotPassword (view: View){

    }

    fun register (view: View){
        startActivity(Intent(this,RegisterActivity::class.java))
    }

    fun login (){
        loginUser()

    }

    fun loginUser (){

        val user:String=txtUser.text.toString()
        val password:String=txtPassword.text.toString()

        if (!TextUtils.isEmpty(user)&& !TextUtils.isEmpty(password)){
            progressBar.visibility=View.VISIBLE

            auth.signInWithEmailAndPassword(user,password)
                .addOnCompleteListener(this){
                    task->

                    if (task.isSuccessful){
                        action()

                    }
                    else{
                        Toast.makeText(this, "Error en la autenticacion", Toast.LENGTH_LONG).show()
                    }
                }
        }

    }

    private fun action(){
        startActivity(Intent(this, LoginActivity::class.java))

    }*/


}