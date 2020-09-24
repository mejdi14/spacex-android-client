package com.example.spacex.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.spacex.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        showTheMoonManWithMagic()
    }

    private fun showTheMoonManWithMagic() {
        moon_man.animate().translationX(0f).translationY(0f).setDuration(2700).start()
        Handler().postDelayed({
            startActivity(Intent(this, NewsActivity::class.java))
        }, 3000)
        finish()


    }
}