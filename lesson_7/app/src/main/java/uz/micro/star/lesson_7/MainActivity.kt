package uz.micro.star.lesson_7

import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import uz.micro.star.lesson_7.databinding.ActivityMainBinding
import uz.micro.star.lesson_7.dialogs.MyCustomDialog


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var doubleBackToExitPressedOnce = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.simpleDialog.setOnClickListener {
            showSimpleAlertDialog()
        }
        binding.customDialog.setOnClickListener {
            val dialog = MyCustomDialog(this)
            dialog.show()
        }
        binding.snackbar.setOnClickListener {

        }
    }

    fun showSimpleAlertDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("This is title")
        dialog.setMessage("This is message")
        dialog.setCancelable(false)
        dialog.setPositiveButton("OKay", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(this@MainActivity, "OKay", Toast.LENGTH_SHORT).show()
            }

        })
        dialog.setNegativeButton(
            "Cancel"
        ) { p0, p1 -> Toast.makeText(this@MainActivity, "Cancel", Toast.LENGTH_SHORT).show() }
        dialog.setNeutralButton(
            "Neytral"
        ) { p0, p1 -> Toast.makeText(this@MainActivity, "Neytral", Toast.LENGTH_SHORT).show() }
        dialog.show()
//        dialog.create().dismiss()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            val snackbar = Snackbar.make(
                binding.snackbar,
                "Do you want to exit from app ?",
                Snackbar.LENGTH_LONG
            )
            snackbar.setAction("Okay", object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    Toast.makeText(this@MainActivity, "Exit successfully", Toast.LENGTH_LONG).show()
                    snackbar.dismiss()
                    finish()
                }
            })
            snackbar.show()
        } else {
            this.doubleBackToExitPressedOnce = true
            Handler(Looper.getMainLooper()).postDelayed(
                { doubleBackToExitPressedOnce = false },
                2000
            )
        }

    }
}