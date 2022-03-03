package com.carl.cathay_test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carl.cathay_test.R
import com.carl.cathay_test.presenter.ZooPresenter

class ZooAdapter(private val presenter: ZooPresenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_zoo, parent, false)
        )
    }

    override fun getItemCount(): Int {
        presenter.getZooList()?.let {
            return it.result.results.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        presenter.onBindViewHolder(holder as ViewHolder, position)
    }
}
