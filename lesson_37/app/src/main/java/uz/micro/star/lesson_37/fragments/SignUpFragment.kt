package uz.micro.star.lesson_37.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.micro.star.lesson_37.R
import uz.micro.star.lesson_37.databinding.SignUpFragmentBinding
import uz.micro.star.lesson_37.viewmodels.DaggerViewModelFactory
import uz.micro.star.lesson_37.viewmodels.SignUpViewModel
import javax.inject.Inject

class SignUpFragment : DaggerFragment() {
    lateinit var binding: SignUpFragmentBinding
    lateinit var viewModel: SignUpViewModel

    @Inject
    lateinit var providerFactory: DaggerViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            providerFactory
        )[SignUpViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.whenStarted {
                viewModel.logUpFlow.collect {
                    if (it) {
                        findNavController().navigate(
                            R.id.action_signUpFragment_to_logInFragment
                        )
                    }
                }
            }
        }
        binding.enter.setOnClickListener {
            viewModel.signUp(
                binding.name.text.toString(),
                binding.username.text.toString(),
                binding.email.text.toString(),
                binding.password.text.toString(),
                binding.confirmPassword.text.toString(),
            )
        }
    }
}