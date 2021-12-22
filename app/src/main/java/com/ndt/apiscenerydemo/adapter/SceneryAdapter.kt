package com.ndt.apiscenery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ndt.apiscenery.model.Scenery
import com.ndt.apiscenerydemo.databinding.ItemSceneryBinding


class SceneryAdapter(private var sceneryList: List<Scenery>, private var context: Context) :
    RecyclerView.Adapter<SceneryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SceneryAdapter.ViewHolder {
        return ViewHolder(
            ItemSceneryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), context
        )
    }

    override fun onBindViewHolder(holder: SceneryAdapter.ViewHolder, position: Int) {
        holder.bind(sceneryList[position])
    }

    override fun getItemCount(): Int = sceneryList.size

    class ViewHolder(private var binding: ItemSceneryBinding, private var context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(scenery: Scenery) {
            binding.tvID.text = "ID " + scenery.id.toString()
            binding.tvName.text = "Name: " + scenery.title
            binding.tvDescription.text = "Description: " + scenery.description
            Glide.with(context).load(scenery.image).into(binding.imgThumb)
        }
    }
}