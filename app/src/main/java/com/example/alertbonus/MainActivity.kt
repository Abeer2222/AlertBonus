package com.example.alertbonus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button)

        button.setOnClickListener {
            customalert()
        }
    }

    private fun customalert(){
        val builder= AlertDialog.Builder(this@MainActivity)
        val dialogView= LayoutInflater.from(this@MainActivity).inflate(R.layout.alert,null)

        builder.setView(dialogView)
        val editAlert=dialogView.findViewById<EditText>(R.id.editAlert)
        val show=dialogView.findViewById<Button>(R.id.btnshow)
        val go=dialogView.findViewById<Button>(R.id.btngo)
        val viewAlert=dialogView.findViewById<TextView>(R.id.viewAlert)


        show.setOnClickListener {
            viewAlert.text=editAlert.text.toString()
        }

        go.setOnClickListener {
            val input=editAlert.text.toString()
            val intent= Intent(this@MainActivity,MainActivity2::class.java)
            intent.putExtra("input",input)
            startActivity(intent)
        }
        builder.show()

    }
}