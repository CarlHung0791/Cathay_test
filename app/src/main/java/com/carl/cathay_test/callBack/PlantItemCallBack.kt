package com.carl.cathay_test.callBack

import com.carl.cathay_test.model.DataPlant

interface PlantItemCallBack {
    fun onItemClick(dataPlant: DataPlant?)
}