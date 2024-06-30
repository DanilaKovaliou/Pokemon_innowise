package com.example.okemonz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.okemonz.databinding.ActivityMainBinding
import com.example.okemonz.databinding.SecondMainBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: SecondMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.buttonBack.setOnClickListener {
            finish()
        }
        val id = intent.getIntExtra("id", 1)
        val pokemon = Repository.pokemons.find { it.id == id }!!
        binding.textView.text = pokemon.name
        binding.imageView.setImageResource(pokemon.imageRes)
        binding.textView2.text="Height: "+pokemon.height

    }

 }