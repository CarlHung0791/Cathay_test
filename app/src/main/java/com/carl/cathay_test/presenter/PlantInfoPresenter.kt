package com.carl.cathay_test.presenter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.carl.cathay_test.R
import com.carl.cathay_test.adapter.PlantAdapter
import com.carl.cathay_test.config.DataConfig
import com.carl.cathay_test.model.DataPlant
import com.carl.cathay_test.model.ResultZoo
import com.carl.cathay_test.view.PlantInfoFragment
import com.carl.cathay_test.view.ZooCategoryFragment

class PlantInfoPresenter(private val fragment: PlantInfoFragment) {

    var ivBack: ImageView? = null
    var tvTitle: TextView? = null
    var ivImg: ImageView? = null
    var tvChName: TextView? = null
    var tvEnName: TextView? = null
    var tvNickName: TextView? = null
    var tvInfo: TextView? = null
    var tvModel: TextView? = null
    var tvFun: TextView? = null
    var tvUpdate: TextView? = null

    init {
        ivBack = fragment.view?.findViewById(R.id.ivBack)
        tvTitle = fragment.view?.findViewById(R.id.tvTitle)
        ivImg = fragment.view?.findViewById(R.id.ivImg)
        tvInfo = fragment.view?.findViewById(R.id.tvInfo)
        tvChName = fragment.view?.findViewById(R.id.tvChName)
        tvEnName = fragment.view?.findViewById(R.id.tvEnName)
        tvNickName = fragment.view?.findViewById(R.id.tvNickName)
        tvInfo = fragment.view?.findViewById(R.id.tvInfo)
        tvModel = fragment.view?.findViewById(R.id.tvModel)
        tvFun = fragment.view?.findViewById(R.id.tvFun)
        tvUpdate = fragment.view?.findViewById(R.id.tvUpdate)
        ivBack?.setOnClickListener(fragment)

    }

    fun initData(plant: DataPlant) {
        tvTitle?.text = plant.F_Name_Ch
        tvChName?.text = plant.F_Name_Ch
        tvEnName?.text = plant.F_Name_En
        tvNickName?.text = plant.F_AlsoKnown
        tvInfo?.text = plant.F_Brief
        tvModel?.text = plant.F_Feature
        tvFun?.text = plant.`F_Function＆Application`
        tvUpdate?.text = fragment.getString(R.string.update,plant.F_Update)
    }


}