package uz.micro.star.lesson_26.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import uz.micro.star.lesson_26.R

fun FragmentActivity.startMainFragment(fr: Fragment) {
    val manager = this.supportFragmentManager
    val transaction = manager.beginTransaction()
//        transaction.replace(R.id.group, fr)
//        transaction.add(R.id.group,fr)
    transaction.replace(R.id.container, fr)
//    transaction.add(R.id.container, fr)
//        if (tag.length > 0) transaction.addToBackStack(tag)
//        transaction.addToBackStack(fr.toString())//bu kod stackka qoshadi
    transaction.commit()
}

fun FragmentActivity.startFragment(fr: Fragment) {
    val manager = this.supportFragmentManager
    val transaction = manager.beginTransaction()
    transaction.replace(R.id.container, fr)
    transaction.addToBackStack(fr.toString())
    transaction.commit()
}