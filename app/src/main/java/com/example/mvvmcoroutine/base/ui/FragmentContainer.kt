package com.example.mvvmcoroutine.base.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

interface FragmentContainer {

    val activity: FragmentActivity
    val frameId: Int

//    fun replaceFragment(newFragment: Fragment, withBackStack: Boolean = true) =
//        activity.replaceFragment(frameId, newFragment, withBackStack)
//
//    fun replaceFragmentForResult(reqCode: Int, newFragment: Fragment, withBackStack: Boolean = true) {
//        newFragment.reqCode = reqCode
//        replaceFragment(newFragment, withBackStack)
//    }
}