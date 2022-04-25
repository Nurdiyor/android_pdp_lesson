package uz.micro.star.lesson_26.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import uz.micro.star.lesson_26.databinding.FragmentFirstBinding
import uz.micro.star.lesson_26.databinding.FragmentSecondBinding
import uz.micro.star.lesson_26.utils.startFragment

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "First", Toast.LENGTH_SHORT).show()
        binding = FragmentFirstBinding.inflate(layoutInflater)
//        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
//            binding.text.text = "Helo hello"
            val frSecond = SecondFragment()
//            val bundle = Bundle()
//            bundle.putString("TITLE", binding.text.text.toString())
//            frSecond.arguments = bundle
            frSecond.arguments = bundleOf(
                "TITLE" to binding.text.text.toString(),
                "SEC" to 23
            )
            requireActivity().startFragment(frSecond)
        }
    }
}