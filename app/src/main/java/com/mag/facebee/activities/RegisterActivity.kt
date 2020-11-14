package com.mag.facebee.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mag.facebee.R
import com.mag.facebee.login.LoginActivityLogin

class RegisterActivity : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtLastName: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText
    //private lateinit var txtRepeatPassword: EditText
    private lateinit var progressbar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txtName = findViewById(R.id.txtName)
        //txtLastName = findViewById(R.id.txtLastName)
        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)

        progressbar = findViewById(R.id.progressBar)

        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        dbReference = database.reference.child("User")


    }

    fun register(view: View) {
        createNewAccount()

    }

    private fun createNewAccount() {
        val name: String = txtName.text.toString()
        //val lastName: String = txtLastName.text.toString()
        val email: String = txtEmail.text.toString()
        val password: String = txtPassword.text.toString()

        if (!TextUtils.isEmpty(name)  && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)
           // && !TextUtils.isEmpty(lastName)
        ) {
            progressbar.visibility = View.VISIBLE

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->

                    if (task.isSuccessful) {
                        //if (task.isComplete){
                        val user: FirebaseUser? = auth.currentUser
                        verifyEmail(user)


                        //     LINEAS ORIGINALES !!!!!!!!!!!!!!!!!!!!
                        //val currentUserDb = dbReference.child(user?.uid)
                        //currentUserDb.child("Name").setValue(name)
                        //currentUserDb.child("lastName").setValue(lastName)

                        //TIRABA ERROR Y SE SOLUCIONO ASI !!!!!!!!!!!!!!!
                        val userBD = user?.uid?.let { dbReference.child(it) }

                        userBD?.child("Name")?.setValue(name)
                        //userBD?.child("lastName")?.setValue(lastName)
                        action()


                        //PROBANDO GUARDANDO DATOS


                    }
                }
        }
    }

    private fun action() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()



    }


    private fun verifyEmail(user: FirebaseUser?) {
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this) { task ->

                if (task.isComplete) {
                    Toast.makeText(this, "La cuenta ha sido creada correctamente.", Toast.LENGTH_LONG).show()
                    //Toast.makeText(this, "Email enviado", Toast.LENGTH_LONG).show()

                } else {

                    Toast.makeText(this, "Error al enviar el email", Toast.LENGTH_LONG).show()
                }
            }

    }

}