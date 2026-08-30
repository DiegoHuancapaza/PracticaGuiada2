package com.example.practicaguiada1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaguiada1.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEvaluar.setOnClickListener {
            evaluarEstudiante()
        }

        binding.btnNavegar.setOnClickListener {
            navegarADetalle()
        }
    }

    private fun evaluarEstudiante(){
        val nombre = binding.etNombre.text.toString().trim()
        val notaTexto = binding.etNota.text.toString().trim()

        if (nombre.isEmpty() || notaTexto.isEmpty()){
            Toast.makeText(this, "Porfavor Complete todos los Campos", Toast.LENGTH_SHORT).show()
            return
        }

        val nota = notaTexto.toDoubleOrNull()

        if (nota == null || nota !in 0.0 .. 20.0){
            binding.tvResultado.text = "Error: ingrese una nota valida entre 0 y 20"
            return
        }

        val estado = if (nota >= 10.5) "APROVADO" else "DESAPROBADO"
        binding.tvResultado.text = "Estudiante: $nombre\nNota: $nota\nEstado: $estado"
    }

    private fun navegarADetalle() {
        val nombre = binding.etNombre.text.toString().trim()

        if(nombre.isEmpty()){
            Toast.makeText(this, "Escriba un nombre para enviar", Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(this, DetailActivity::class.java).apply{
            putExtra("EXTRA_NOMBRE",nombre)
        }
        startActivity(intent)
    }
}