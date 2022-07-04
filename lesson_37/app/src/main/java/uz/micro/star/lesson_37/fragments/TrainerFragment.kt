package uz.micro.star.lesson_37.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import uz.micro.star.lesson_37.databinding.TrainerFragmentBinding
import uz.micro.star.lesson_37.viewmodels.DaggerViewModelFactory
import uz.micro.star.lesson_37.viewmodels.TrainerViewModel
import javax.inject.Inject

class TrainerFragment : DaggerFragment() {

    lateinit var binding: TrainerFragmentBinding
    lateinit var viewModel: TrainerViewModel

    @Inject
    lateinit var providerFactory: DaggerViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TrainerFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            providerFactory
        )[TrainerViewModel::class.java]


    }

}