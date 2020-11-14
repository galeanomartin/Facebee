package com.mag.facebee.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.mag.facebee.R
import kotlinx.android.synthetic.main.activity_main.*


//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1-ACTUALMENTE SE LOGUEA Y PASAS POR LOS MENUS PERO NO LEVANTA LOS FRAGMENTS!!!!!!!!!!!!!!


        //2- SI AGREGO LA BARRA DIRECTAMENTE NO ENTRA AL HOME !!!!!!!!!!!!!!!!!!!!
        //toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //val toolbar: Toolbar = findViewById<View>(R.id.toolbarMain) as Toolbar
        //setActionBar(findViewById(R.id.toolbarMain))

        //3- SI AGREGO LA FUNCION AL TOCAR EL MENU SE APAGA LA APP !!!!!!!!!!
       // configNav()

    }

    //SI AGREGO LA FUNCION AL TOCAR EL MENU SE APAGA LA APP
    //fun configNav() {
      //  NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this, R.id.fragContent))

    //}


    }

    /*private fun setContent(content: String) {
        setTitle(content)
        //tvLabel.text = content
    }*/

       //AGREGADO EN CLASES
        //setActionBar(findViewById(R.id.toolbarMain))

       // configNav()

  //  }

    //AGREGADO EN CLASES
   /* fun configNav() {
       // NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this, R.id.fragContent))
        NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this, R.id.fragContent))
    }*/


//}