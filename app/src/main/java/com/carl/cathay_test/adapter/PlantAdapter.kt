package com.carl.cathay_test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carl.cathay_test.R
import com.carl.cathay_test.presenter.ZooCategoryPresenter

class PlantAdapter(private val presenter: ZooCategoryPresenter) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_zoo, parent, false)
        )
    }

    override fun getItemCount(): Int {
        presenter.getList().let {
            return it.size
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        presenter.onBindViewHolder(holder as ViewHolder, position)
    }
}
