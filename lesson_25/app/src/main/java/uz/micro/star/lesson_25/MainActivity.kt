package uz.micro.star.lesson_25
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import uz.micro.star.lesson_25.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.apply {
//            myBtn2.setOnClickListener {
//                val animationX = image.animate()
//                animationX
//                    .scaleX(1.3f)
//                    .scaleY(1.3f)
//                    .setDuration(500)
//                    .setListener(object : Animator.AnimatorListener {
//                        override fun onAnimationStart(p0: Animator?) {
//                            Toast.makeText(
//                                this@MainActivity,
//                                "onAnimationStart",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//
//                        override fun onAnimationEnd(p0: Animator?) {
//                            image.animate()
//                                .scaleX(1.0f)
//                                .scaleY(1.0f)
//                                .setDuration(500)
//                                .setListener(object : Animator.AnimatorListener {
//                                    override fun onAnimationStart(p0: Animator?) {
//                                        Toast.makeText(
//                                            this@MainActivity,
//                                            "onAnimationStart",
//                                            Toast.LENGTH_SHORT
//                                        ).show()
//                                    }
//
//                                    override fun onAnimationEnd(p0: Animator?) {
//                                       animationX.start()
//                                    }
//
//                                    override fun onAnimationCancel(p0: Animator?) {
//                                        Toast.makeText(
//                                            this@MainActivity,
//                                            "onAnimationCancel",
//                                            Toast.LENGTH_SHORT
//                                        ).show()
//                                    }
//
//                                    override fun onAnimationRepeat(p0: Animator?) {
//                                        Toast.makeText(
//                                            this@MainActivity,
//                                            "onAnimationRepeat",
//                                            Toast.LENGTH_SHORT
//                                        ).show()
//                                    }
//
//                                })
//                            animationX.start()
//                        }
//
//                        override fun onAnimationCancel(p0: Animator?) {
//                            Toast.makeText(
//                                this@MainActivity,
//                                "onAnimationCancel",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//
//                        override fun onAnimationRepeat(p0: Animator?) {
//                            Toast.makeText(
//                                this@MainActivity,
//                                "onAnimationRepeat",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//
//                    })
//                    .start()
//            }
//
//        }
        binding.myBtn2.setOnClickListener {
            val connectingAnimation: Animation =
                AnimationUtils.loadAnimation(this, R.anim.heart_anim)
            val connectingAnimation2: Animation =
                AnimationUtils.loadAnimation(this, R.anim.heart_ani2)
            connectingAnimation.setAnimationListener(object :Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                    binding.image.startAnimation(connectingAnimation2)
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }

            })
            connectingAnimation2.setAnimationListener(object :Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                    binding.image.startAnimation(connectingAnimation)
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }

            })
            binding.image.startAnimation(connectingAnimation)
        }
    }
//    myBtn.animate()
//    .setInterpolator(BounceInterpolator())
//    .x(20f)
//    .y(20f)
//    .setDuration(500)
//    .start()

    fun alpha() {
//    myBtn.alpha=1.0f
        //                .alpha(0.5f)
//                .alphaBy(0.5f)
    }

    fun scale() {
//        .scaleX(2f)
//            .scaleY(2f)
//            .scaleXBy(1.5f)
//            .scaleYBy(1.5f)
//        myBtn.scaleX=0.5f
//        myBtn.scaleY=0.5f
    }

    fun rotation() {
//        myBtn.z=0f
        //                 myBtn.rotationX=45f
//                 myBtn.rotationY=45f
//                myBtn.rotation=90f
//        .rotationXBy(3600f)
//            .rotationY(3600f)
//            .rotation(3600f)
    }

    fun xyz() {
//        myBtn.x=0f
//        myBtn.y=0f
//        myBtn.z=100f
    }

    fun translation() {
//        .translationX(100f)
//            .translationY(100f)
        //                myBtn.translationX=100f
//                myBtn.translationY=100f
//                myBtn.translationZ=100f
    }
}