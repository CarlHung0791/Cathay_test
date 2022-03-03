package com.carl.cathay_test.presenter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carl.cathay_test.MainActivity
import com.carl.cathay_test.R
import com.carl.cathay_test.adapter.ZooAdapter
import com.carl.cathay_test.callBack.ZooItemCallBack
import com.carl.cathay_test.config.DataConfig
import com.carl.cathay_test.model.ApiGetPlant
import com.carl.cathay_test.model.ApiGetZoo
import com.carl.cathay_test.model.ResZoo

class ZooPresenter(private val activity: MainActivity) {

    var zooItemCallBack: ZooItemCallBack? = null
    var rvZoo: RecyclerView? = null
    var zooAdapter: ZooAdapter
    var resZoo: ResZoo? = null

    init {
        zooItemCallBack = activity
        rvZoo = activity.findViewById(R.id.rvZoo)
        zooAdapter = ZooAdapter(this)
        rvZoo?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvZoo?.adapter = zooAdapter
        getApiPlant()
        getApiZoo()

    }

    fun getApiZoo() {
        ApiGetZoo(activity).call("resourceAquire", null, null, null, back = {
            resZoo = it
            zooAdapter.notifyDataSetChanged()
        })
    }

    fun getApiPlant() {
        ApiGetPlant(activity).call("resourceAquire", null, null, null, back = {
            DataConfig.dataPlant = it.result.results
        })
    }

    fun getZooList(): ResZoo? {
        return resZoo
    }


    fun onBindViewHolder(holder: ZooAdapter.ViewHolder, position: Int) {
        val clItem = holder.itemView.findViewById<ConstraintLayout>(R.id.clItem)
        val tvName = holder.itemView.findViewById<TextView>(R.id.tvName)
        val tvInfo = holder.itemView.findViewById<TextView>(R.id.tvInfo)
        val tvTime = holder.itemView.findViewById<TextView>(R.id.tvTime)
        val ivImg = holder.itemView.findViewById<ImageView>(R.id.ivImg)
        resZoo?.let {
            tvName.text = it.result.results[position].E_Name
            tvInfo.text = it.result.results[position].E_Info
            Glide.with(ivImg.context).load(it.result.results[position].E_Pic_URL).into(ivImg)
//            DownloadImg(ivImg).execute(it.result.results[position].E_Pic_URL)
            clItem.setOnClickListener { view ->
                zooItemCallBack?.onItemClick(it.result.results[position])
            }
        }

    }

    @SuppressLint("StaticFieldLeak")
    @Suppress("DEPRECATION")
    private inner class DownloadImg(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
        override fun doInBackground(vararg urls: String): Bitmap? {
            val imageURL = urls[0]
            var image: Bitmap? = null
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return image
        }

        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
        }
    }


}