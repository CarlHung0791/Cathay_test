package com.carl.cathay_test.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carl.cathay_test.R
import com.carl.cathay_test.base.BaseFragment
import com.carl.cathay_test.callBack.PlantItemCallBack
import com.carl.cathay_test.config.Const
import com.carl.cathay_test.model.DataPlant
import com.carl.cathay_test.model.ResultDataPlant
import com.carl.cathay_test.model.ResultZoo
import com.carl.cathay_test.presenter.PlantInfoPresenter
import com.carl.cathay_test.presenter.ZooCategoryPresenter
import com.carl.cathay_test.presenter.ZooPresenter
import com.google.gson.Gson

class PlantInfoFragment : BaseFragment() {

    private lateinit var plantInfoPresenter: PlantInfoPresenter
    private lateinit var fragment : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragment = inflater.inflate(R.layout.fragment_plant_info, container, false)
        return fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plantInfoPresenter = PlantInfoPresenter(this)
        arguments?.getString(Const.dataPlant,null)?.let {
            plantInfoPresenter.initData(Gson().fromJson(it, DataPlant::class.java))
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.ivBack -> {
                activity?.onBackPressed()
            }
        }
    }

}