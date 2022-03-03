package com.carl.cathay_test.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carl.cathay_test.R

abstract class BaseFragment : Fragment(), View.OnClickListener {

    fun replaceFragment(fragment: Fragment, bundle: Bundle?) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        if (bundle != null) {
            fragment.arguments = bundle
        }
        transaction?.add(R.id.frameLayout, fragment)?.addToBackStack("")?.commit()
    }

    fun addFragment(fragment: Fragment, bundle: Bundle?){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        if (bundle != null) {
            fragment.arguments = bundle
        }
        transaction?.add(R.id.frameLayout, fragment)?.commitAllowingStateLoss()

    }
}