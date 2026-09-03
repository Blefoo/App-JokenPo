package br.gov.sp.etec.jokenpo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var txtResultado : TextView
    private lateinit var imagemComputador : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imagemComputador = findViewById<ImageView>(R.id.imageView)
        txtResultado = findViewById<TextView>(R.id.textResultado)
        val pedra = findViewById<ImageView>(R.id.imagePedra)
        pedra.setOnClickListener {
            jogar("pedra")
        }
        val papel = findViewById<ImageView>(R.id.imagePapel)
        papel.setOnClickListener {
            jogar("papel")
        }
        val tesoura = findViewById<ImageView>(R.id.imageTesoura)
        tesoura.setOnClickListener {
            jogar("tesoura")
        }
    }

    fun jogar(jogador : String) {
        val opcoes = arrayOf("papel", "tesoura", "pedra")
        val computador = opcoes[Random.nextInt(opcoes.size)]
        when(computador) {
            "papel" -> imagemComputador.setImageResource(R.drawable.papel)
            "tesoura" -> imagemComputador.setImageResource(R.drawable.tesoura)
            "pedra" -> imagemComputador.setImageResource(R.drawable.pedra)
        }
        when {
            (jogador == computador) -> {txtResultado.text = "Empate!"}
            (jogador == "pedra" && computador == "tesoura") -> {txtResultado.text = "Você venceu!"}
            (jogador == "papel" && computador == "pedra") -> {txtResultado.text = "Você venceu!"}
            (jogador == "tesoura" && computador == "papel") -> {txtResultado.text = "Você venceu!"}
            else ->{txtResultado.text = "Você perdeu!"}
        }
    }
}