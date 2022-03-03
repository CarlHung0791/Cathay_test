package com.carl.cathay_test.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carl.cathay_test.R
import com.carl.cathay_test.base.BaseFragment
import com.carl.cathay_test.callBack.PlantItemCallBack
import com.carl.cathay_test.config.Const
import com.carl.cathay_test.model.DataPlant
import com.carl.cathay_test.model.ResultZoo
import com.carl.cathay_test.presenter.ZooCategoryPresenter
import com.google.gson.Gson

class ZooCategoryFragment : BaseFragment(), PlantItemCallBack {

    private lateinit var zooCategoryPresenter: ZooCategoryPresenter
    private lateinit var fragment: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragment = inflater.inflate(R.layout.fragment_zoo_category, container, false)
        return fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        zooCategoryPresenter = ZooCategoryPresenter(this)
        arguments?.getString(Const.dataZoo, null)?.let {
            zooCategoryPresenter.initData(Gson().fromJson(it, ResultZoo::class.java))
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ivBack -> {
                activity?.onBackPressed()
            }
            R.id.tvWeb -> {
                zooCategoryPresenter.getUrl()?.let {
                    val intent = Intent()
                    intent.action = Intent.ACTION_VIEW
                    intent.data = Uri.parse(it)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onItemClick(dataPlant: DataPlant?) {
        dataPlant?.let {
            val bundle = Bundle()
            bundle.putString(Const.dataPlant, Gson().toJson(it))
            replaceFragment(PlantInfoFragment(), bundle)
        }
    }
}