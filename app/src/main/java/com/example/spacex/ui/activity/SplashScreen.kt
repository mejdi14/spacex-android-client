package com.example.spacex.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
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
                triangle.animate().rotation(180f).setDuration(9000).start()
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
        Handler().postDelayed({
            hideRedAndShowWhite()
        }, 1000)

    }

    private fun hideRedAndShowWhite() {
        runOnUiThread {
            mars.alpha = 0f
            //mars.setImageDrawable(R.drawable.round_white_shape)
            Handler().postDelayed({
                border_circle.alpha = 0f
            }, 200)

            Handler().postDelayed({
                white_cercle.alpha = 1f
            }, 400)
            Handler().postDelayed({
                flag.alpha = 1f
            }, 700)

            Handler().postDelayed({
                triangle.alpha = 0f
                Glide.with(this).load(R.drawable.space_boy).into(gif_image)
                flag.alpha = 0f

                japan_holder.alpha = 1f
            }, 1000)

            Handler().postDelayed({
                border_circle.alpha = 1f
                japan_holder.alpha = 0f

            }, 1300)

            Handler().postDelayed({
                white_cercle.alpha = 1f

            }, 1500)

            Handler().postDelayed({
                big_mars.alpha = 1f

            }, 1700)

            Handler().postDelayed({
                white_cercle.alpha = 0f
                mars.alpha = 1f
                big_mars.alpha = 0f
                extra_border.alpha = 1f
                extra_border2.alpha = 1f


            }, 1900)

            Handler().postDelayed({
                white_cercle.alpha = 0f
                mars.alpha = 1f
                big_mars.alpha = 0f
                extra_border.alpha = 0f
                extra_border2.alpha = 0f
                triangle.alpha = 1f

            }, 2100)


            Handler().postDelayed({
                triangle.alpha = 0f
                yellow_cercle.alpha = 1f
                white_cercle.alpha = 1f


            }, 2300)

            Handler().postDelayed({
                white_cercle.animate().scaleX(50f).scaleY(50f).setDuration(1000).withEndAction {
                    mars.alpha = 1f
                    border_circle.alpha = 0f
                    yellow_cercle.alpha = 0f
                    white_cercle.alpha = 0f
                    welcome.alpha = 1f
                    cowboy.alpha = 1f
                    Glide.with(this).clear(gif_image)
                    white_cercle.animate().alpha(0f).setDuration(300).withEndAction {
                        Handler().postDelayed({
                            startNewsActivity()


                        }, 1000)
                    }.start()
                }.start()


            }, 2500)


        }

    }

    private fun startNewsActivity() {
        val intent = Intent(this, NewsActivity::class.java)
        val options =
            ActivityOptionsCompat.makeSceneTransitionAnimation(this, mars, "transition_image")
        startActivity(intent, options.toBundle())
    }


}
