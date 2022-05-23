package uz.micro.star.lesson_34.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import uz.micro.star.lesson_34.R
import uz.micro.star.lesson_34.mvvm.ActivityViewModel

class BlankFragment : Fragment() {
    private lateinit var viewmodel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(this)[ActivityViewModel::class.java]
//        viewmodel.listViewModel.observe(this){
//            adapter.setUserList(it)
//        }
        viewmodel.getAllTrainer()
    }
}