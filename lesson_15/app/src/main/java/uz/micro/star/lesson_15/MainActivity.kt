package uz.micro.star.lesson_15

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.micro.star.lesson_15.adapters.ContactAdapter
import uz.micro.star.lesson_15.databinding.ActivityMainBinding
import uz.micro.star.lesson_15.dialogs.AddContactDialog
import uz.micro.star.lesson_15.dialogs.EditContactDialog
import uz.micro.star.lesson_15.models.ContactData

class MainActivity : AppCompatActivity() {
    private val adapter by lazy {
        ContactAdapter()
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = adapter
        binding.add.setOnClickListener {
            val dialog = AddContactDialog(this)
            dialog.setOnAddListener { name, number ->
                adapter.addContact(ContactData(name, number))
            }
            dialog.show()
        }
        adapter.setDeleteListener {
            adapter.deleteContact(it)
        }
        adapter.setEditListener { pos, name, number ->
            val dialog = EditContactDialog(this, name, number)
            dialog.setOnAddListener { nameX, numberX ->
                adapter.editContact(ContactData(nameX, numberX), pos)
            }
            dialog.show()
        }
    }
}