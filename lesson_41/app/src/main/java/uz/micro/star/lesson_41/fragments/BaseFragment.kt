package uz.micro.star.lesson_41.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment
import uz.micro.star.lesson_41.viewmodels.ActivityViewModel
import uz.micro.star.lesson_41.viewmodels.DaggerViewModelFactory
import javax.inject.Inject

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : DaggerFragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!

    lateinit var viewModel: ActivityViewModel
    lateinit var navController: NavController

    @Inject
    lateinit var providerFactory: DaggerViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()

        viewModel = ViewModelProvider(
            requireActivity(),
            providerFactory
        )[ActivityViewModel::class.java]

        onViewCreate()
    }

    abstract fun onViewCreate()

}
