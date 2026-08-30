package com.example.practicaguiada1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaguiada1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombreRecibido = intent.getStringExtra("EXTRA_NOMBRE") ?: "Invitado"
        binding.tvTituloDetalle.text = "!Bienvenido a la pantalla de detalle, $nombreRecibido"

        }
    }
