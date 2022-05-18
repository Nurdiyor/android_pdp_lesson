package uz.micro.star.lesson_33.mvvm

import androidx.lifecycle.LiveData

class MyLivedata: LiveData<String>() {
    public override  fun setValue(value: String?) {
        super.setValue(value)
    }

    override fun getValue(): String? {
        return super.getValue()
    }
}