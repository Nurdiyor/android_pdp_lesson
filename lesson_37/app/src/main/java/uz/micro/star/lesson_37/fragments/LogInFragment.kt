package uz.micro.star.lesson_37.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import uz.micro.star.lesson_37.R
import uz.micro.star.lesson_37.databinding.LogInFragmentBinding
import uz.micro.star.lesson_37.viewmodels.DaggerViewModelFactory
import uz.micro.star.lesson_37.viewmodels.LogInViewModel
import javax.inject.Inject

class LogInFragment : DaggerFragment() {

    lateinit var binding: LogInFragmentBinding
    lateinit var viewModel: LogInViewModel

    @Inject
    lateinit var providerFactory: DaggerViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LogInFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            providerFactory
        )[LogInViewModel::class.java]
    binding.register.setOnClickListener {
        findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
    }

    }
}