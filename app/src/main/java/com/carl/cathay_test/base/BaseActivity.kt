package com.carl.cathay_test.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.carl.cathay_test.R

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
        } catch (e: Exception) {

        }
    }

    fun addFragment(fragment: Fragment, bundle: Bundle?, isAllowingStateLoss: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        if (bundle != null) {
            fragment.arguments = bundle
        }
        if (isAllowingStateLoss) {
            transaction.add(R.id.frameLayout, fragment).addToBackStack("").commitAllowingStateLoss()
            return
        }
        transaction.add(R.id.frameLayout, fragment).addToBackStack("").commit()
    }

    fun replaceFragment(fragment: Fragment, bundle: Bundle?, isAllowingStateLoss: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        if (bundle != null) {
            fragment.arguments = bundle
        }
        if (isAllowingStateLoss) {
            transaction.replace(R.id.frameLayout, fragment).commitAllowingStateLoss()
            return
        }
        transaction.replace(R.id.frameLayout, fragment).commit()
    }
}