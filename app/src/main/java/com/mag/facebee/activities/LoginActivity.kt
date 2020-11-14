package com.mag.facebee.activities

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.mag.facebee.R
import com.mag.facebee.fragments.HomeFragment
import com.mag.facebee.login.ForgotPassActivityLogin
import com.mag.facebee.login.MainActivityLogin
import com.mag.facebee.login.RegisterActivityLogin


class LoginActivity : AppCompatActivity() {


    private lateinit var txtUser: TextView
    private lateinit var txtPassword: EditText

    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    txtUser=findViewById(R.id.txtUser)
    txtPassword=findViewById(R.id.txtPassword)
    progressBar = findViewById(R.id.progressBar)
    auth=FirebaseAuth.getInstance()
}

fun forgotPassword (view: View){
    startActivity(Intent(this, ForgotPassActivity::class.java))

}

fun register (view: View){
    startActivity(Intent(this, RegisterActivity::class.java))
}

fun login (view: View){
    loginUser()

}

fun loginUser (){

    val user:String=txtUser.text.toString()
    val password:String=txtPassword.text.toString()

    if (!TextUtils.isEmpty(user)&& !TextUtils.isEmpty(password)){
        progressBar.visibility= View.VISIBLE

        auth.signInWithEmailAndPassword(user,password)
            .addOnCompleteListener(this){
                    task->

                if (task.isSuccessful){
                    action()
                    Toast.makeText(this, "Bienvenido a Facebee.", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "Error en la autenticación.", Toast.LENGTH_LONG).show()
                    progressBar.visibility= View.INVISIBLE
                }
            }
    }

}

private fun action(){
    startActivity(Intent(this, MainActivity::class.java))
    finish()
}

}







