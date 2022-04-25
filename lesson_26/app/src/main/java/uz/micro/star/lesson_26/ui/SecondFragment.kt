package uz.micro.star.lesson_26.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import uz.micro.star.lesson_26.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "Second", Toast.LENGTH_SHORT).show()
//        binding = FragmentSecondBinding.inflate(layoutInflater)
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            binding.btn2.text = it.getString("TITLE")
        }
        binding.btn2.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}