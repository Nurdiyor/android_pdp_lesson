package uz.micro.star.lesson_27.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import uz.micro.star.lesson_27.R
import uz.micro.star.lesson_27.controller.FragmentController

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!
    private val controller = FragmentController.controller

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreated()
    }

    abstract fun onViewCreated()

    fun replaceFragment(secondFragment: SecondFragment) {
        controller?.replaceFragment(secondFragment)
    }
    //https://github.com/kakajika/FragmentAnimations
    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return if (enter) {
            AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in_right)
        } else {
            AnimationUtils.loadAnimation(requireContext(), R.anim.slide_out_left)
        }
    }

}
