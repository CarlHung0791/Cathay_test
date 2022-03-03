package com.carl.cathay_test.presenter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carl.cathay_test.R
import com.carl.cathay_test.adapter.PlantAdapter
import com.carl.cathay_test.callBack.PlantItemCallBack
import com.carl.cathay_test.config.DataConfig
import com.carl.cathay_test.model.DataPlant
import com.carl.cathay_test.model.ResultZoo
import com.carl.cathay_test.view.ZooCategoryFragment

class ZooCategoryPresenter(fragment: ZooCategoryFragment) {

    var plantItemCallBack: PlantItemCallBack? = null
    var rvZoo: RecyclerView? = null
    var ivBack: ImageView? = null
    var tvTitle: TextView? = null
    var ivImg: ImageView? = null
    var tvInfo: TextView? = null
    var tvTime: TextView? = null
    var tvInOut: TextView? = null
    var tvWeb: TextView? = null
    var plantAdapter: PlantAdapter
    var plantList: MutableList<DataPlant> = ArrayList()
    var webUrl: String? = null

    init {
        plantItemCallBack = fragment
        rvZoo = fragment.view?.findViewById(R.id.rvZoo)
        ivBack = fragment.view?.findViewById(R.id.ivBack)
        tvTitle = fragment.view?.findViewById(R.id.tvTitle)
        ivImg = fragment.view?.findViewById(R.id.ivImg)
        tvInfo = fragment.view?.findViewById(R.id.tvInfo)
        tvTime = fragment.view?.findViewById(R.id.tvTime)
        tvInOut = fragment.view?.findViewById(R.id.tvInOut)
        tvWeb = fragment.view?.findViewById(R.id.tvWeb)
        ivBack?.setOnClickListener(fragment)
        tvWeb?.setOnClickListener(fragment)
        plantAdapter = PlantAdapter(this)
        rvZoo?.layoutManager =
            LinearLayoutManager(fragment.context, LinearLayoutManager.VERTICAL, false)
        rvZoo?.adapter = plantAdapter

    }

    fun initData(zoo: ResultZoo) {
        tvTitle?.text = zoo.E_Name
        tvInfo?.text = zoo.E_Info
        tvInOut?.text = zoo.E_Category
        webUrl = zoo.E_URL
        DataConfig.dataPlant?.forEach {
            if (it.F_Location.indexOf(zoo.E_Name) != -1) {
                plantList.add(it)
            }
        }
    }

    fun getList(): MutableList<DataPlant> {
        return plantList
    }

    fun getUrl(): String? {
        return webUrl
    }


    fun onBindViewHolder(holder: PlantAdapter.ViewHolder, position: Int) {
        val clItem = holder.itemView.findViewById<ConstraintLayout>(R.id.clItem)
        val tvName = holder.itemView.findViewById<TextView>(R.id.tvName)
        val tvInfo = holder.itemView.findViewById<TextView>(R.id.tvInfo)
        val tvTime = holder.itemView.findViewById<TextView>(R.id.tvTime)
        val ivImg = holder.itemView.findViewById<ImageView>(R.id.ivImg)
        plantList?.let {
            tvName.text = it[position].F_Name_Ch
            tvInfo.text = it[position].F_AlsoKnown
            tvTime.visibility = View.GONE
            Glide.with(ivImg.context).load(it[position].F_Pic01_URL).into(ivImg)
            clItem.setOnClickListener { view ->
                plantItemCallBack?.onItemClick(it[position])
            }
        }
    }


}