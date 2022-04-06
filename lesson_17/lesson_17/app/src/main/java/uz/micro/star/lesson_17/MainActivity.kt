package uz.micro.star.lesson_17

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import uz.micro.star.lesson_17.adapters.ContactAdapter
import uz.micro.star.lesson_17.database.Database
import uz.micro.star.lesson_17.databinding.ActivityMainExBinding


class MainActivity : AppCompatActivity() {
    private val adapter by lazy {
        ContactAdapter()
    }
    lateinit var binding: ActivityMainExBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainExBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = adapter
        adapter.setAllContacts(Database.getDatabase().students)
        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                Toast.makeText(this@MainActivity,"onQueryTextSubmit ${query}", Toast.LENGTH_SHORT).show()
//                Log.d("YYYYY", "onQueryTextSubmit ${query}")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(
                    this@MainActivity,
                    "onQueryTextChange ${newText}",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("YYYYY", "onQueryTextChange ${newText}")
                return true
            }

        })
//        binding.add.setOnClickListener {
//            val dialog = AddContactDialog(this)
//            dialog.setOnAddListener { name, number ->
//                adapter.addContact(Student(name, number))
//            }
//            dialog.show()
//        }
        adapter.setDeleteListener {
            adapter.deleteContact(it)
            Database.getDatabase().deleteUser(it)
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