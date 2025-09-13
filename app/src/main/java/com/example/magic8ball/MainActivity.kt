package com.example.magic8ball

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var shakeButton: Button
    private lateinit var responseText: TextView

    private val viewModel: Magic8BallViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shakeButton = findViewById(R.id.shake_8_ball)
        responseText = findViewById(R.id.response_text)

        // Load fade-in animation
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        // Observe LiveData and animate response
        viewModel.response.observe(this) { text ->
            responseText.text = text
            responseText.startAnimation(fadeIn)
        }

        shakeButton.setOnClickListener {
            viewModel.getRandomResponse()
        }
    }
}
