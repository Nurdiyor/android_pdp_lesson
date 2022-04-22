package uz.micro.star.lesson_25.utils

import android.content.res.Resources

fun Float.dpToPx(): Float {
    return (this * Resources.getSystem().displayMetrics.density)
}

fun Float.pxToDp(): Float {
    return (this / Resources.getSystem().displayMetrics.density)
}