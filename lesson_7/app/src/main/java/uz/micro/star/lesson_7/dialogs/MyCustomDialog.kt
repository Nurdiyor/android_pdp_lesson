package uz.micro.star.lesson_7.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast

import androidx.appcompat.app.AlertDialog
import uz.micro.star.lesson_7.databinding.DialogMyCustomBinding

class MyCustomDialog(context: Context) : AlertDialog(context) {
    private val binding = DialogMyCustomBinding.inflate(LayoutInflater.from(context))

    init {
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setCancelable(false)
        setView(binding.root)
        binding.okay.setOnClickListener {
            Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}