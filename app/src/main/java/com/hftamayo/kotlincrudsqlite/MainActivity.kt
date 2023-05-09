package com.hftamayo.kotlincrudsqlite

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var edName: EditText
    private lateinit var edEmail: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button

    private lateinit var sqLiteHelper: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        sqLiteHelper = SQLiteHelper(this)
        btnAdd.setOnClickListener { addStudent() }
        btnView.setOnClickListener{ getStudents() }
    }

    private fun getStudents(){
        val stdList = sqLiteHelper.getAllStudent()
        Log.e("testing:", "${stdList.size}")
    }

    private fun addStudent(){
        val name = edName.text.toString()
        val email = edEmail.text.toString()

        if(name.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Please enter required field", Toast.LENGTH_SHORT).show()
        }else {
            val std = StudentModel(name = name, email = email)
            val status = sqLiteHelper.insertStudent(std)
            //checking for the status of the operation
            if(status > -1 ){
                Toast.makeText(this, "Student Added!", Toast.LENGTH_SHORT ).show()
                clearEditText()
            } else {
                Toast.makeText(this, "An error ocurred during record insertion", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearEditText(){
        edName.setText("")
        edEmail.setText("")
        edName.requestFocus()
    }

    private fun initView(){
        edName = findViewById(R.id.edName)
        edEmail = findViewById(R.id.edEmail)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)
    }




}