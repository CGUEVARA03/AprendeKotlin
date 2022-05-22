package com.example.aprendekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

data class cursos(val nombre:String,val url:String)

class MainActivity : AppCompatActivity() {
    val react=cursos("React","react")
    val kot=cursos("Kotlin","kotlin")
    var cursoActual=react.copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton=findViewById(R.id.botincitoxd)as Button
        boton.setOnClickListener{
            view->switchCurso(cursoActual)
        }
        boton.setText(todosLosCusos())

    }
    fun switchCurso(curso: cursos)
    {
        cursoActual=curso.copy()
        when (curso.url)
        {
            "react"->cursoActual=kot.copy()
            "kotlin"->cursoActual=react.copy()
            else-> print("Esto nunca va pasar")
        }
        verEnPantall("Curso de : ${cursoActual.nombre} en example.com/${cursoActual.url}")
    }
    fun verEnPantall(s:String)
    {
        val txt=findViewById(R.id.mensaje)as TextView
        txt.setText(s)
    }
    fun todosLosCusos():String="${react.nombre} y  ${kot.nombre}"
}