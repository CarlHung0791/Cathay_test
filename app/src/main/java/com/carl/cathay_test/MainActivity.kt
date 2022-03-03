package com.carl.cathay_test

import android.os.Bundle
import android.view.View
import com.carl.cathay_test.base.BaseActivity
import com.carl.cathay_test.callBack.ZooItemCallBack
import com.carl.cathay_test.config.Const
import com.carl.cathay_test.model.ResultZoo
import com.carl.cathay_test.presenter.ZooPresenter
import com.carl.cathay_test.view.ZooCategoryFragment
import com.google.gson.Gson

class MainActivity : BaseActivity(), ZooItemCallBack {

    private lateinit var zooPresenter: ZooPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        zooPresenter = ZooPresenter(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

        }
    }

    override fun onItemClick(resultZoo: ResultZoo?) {
        resultZoo?.let {
            val bundle = Bundle()
            bundle.putString(Const.dataZoo, Gson().toJson(it))
            addFragment(ZooCategoryFragment(), bundle)
        }
    }
}