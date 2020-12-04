package com.example.spacex.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.app.ActivityOptionsCompat
import com.bumptech.glide.Glide
import com.example.spacex.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        // showTheMoonManWithMagic()
        Handler().postDelayed({
            startAnimation()
        }, 2000)
    }

    private fun startAnimation() {
        motion.transitionToState(R.id.collapsed)
        motion.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.d("nice", "onTransitionStarted: ")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                Log.d("nice", "onTransitionStarted: ")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                startSecondPartAnimation()
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.d("nice", "onTransitionStarted: ")
            }

        })
    }

    private fun startSecondPartAnimation() {
        Glide.with(this).load(R.drawable.cubes).into(gif_image)
        motion.transitionToState(R.id.explode)
        motion.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.d("nice", "onTransitionStarted: ")
                triangle.animate().rotation(180f).setDuration(2000).start()
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                Log.d("nice", "onTransitionStarted: ")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
             //   startNewsActivity()
                startTheFuckingParty()
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.d("nice", "onTransitionStarted: ")
            }

        })
    }

    private fun startTheFuckingParty() {


    }

    private fun startNewsActivity() {
        val intent = Intent(this, NewsActivity::class.java)
        val options =
            ActivityOptionsCompat.makeSceneTransitionAnimation(this, mars, "transition_image")
        startActivity(intent, options.toBundle())
    }


}
