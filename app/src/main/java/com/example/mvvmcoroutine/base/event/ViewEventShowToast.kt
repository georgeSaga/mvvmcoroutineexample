package com.example.mvvmcoroutine.base.event

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mvvmcoroutine.base.utils.StringOrResId

class ViewEventShowToast(private val message: StringOrResId) : ViewEvent {

    override fun execute(fragment: Fragment) = fragment.context!!.let { toastShort(it, message.get(it)) }

    private fun toastShort(context: Context, content: String) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
    }
}