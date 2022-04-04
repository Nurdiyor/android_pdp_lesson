package uz.micro.star.lesson_17

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.micro.star.lesson_17.adapters.ContactAdapter
import uz.micro.star.lesson_17.database.Database
import uz.micro.star.lesson_17.databinding.ActivityMainBinding

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
        adapter.setAllContacts(Database.getDatabase().students)
//        binding.add.setOnClickListener {
//            val dialog = AddContactDialog(this)
//            dialog.setOnAddListener { name, number ->
//                adapter.addContact(Student(name, number))
//            }
//            dialog.show()
//        }
        adapter.setDeleteListener {
            adapter.deleteContact(it)
        }
//        adapter.setEditListener { pos, name, number ->
//            val dialog = EditContactDialog(this, name, number)
//            dialog.setOnAddListener { nameX, numberX ->
//                adapter.editContact(ContactData(nameX, numberX), pos)
//            }
//            dialog.show()
//        }
//        Database.getDatabase().students.forEach {
//            Log.d("RRRR", "student:${it.name} ${it.number}")
//        }
//        Database.getDatabase().deleteUser(4)
//        Log.d("RRRR", "--------------")
//        Database.getDatabase().students.forEach {
//            Log.d("RRRR", "student:${it.name} ${it.number}")
//        }
    }
}