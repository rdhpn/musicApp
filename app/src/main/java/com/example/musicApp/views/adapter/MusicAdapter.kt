package com.example.musicApp.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.musicApp.model.items.Result
import androidx.recyclerview.widget.RecyclerView
import com.example.musicApp.R
import com.example.musicApp.databinding.MusicItemBinding

class MusicAdapter(
    private val itemSet: MutableList<Result> = mutableListOf(),
    private val onItemClick: (itemId: Result) -> Unit
) : RecyclerView.Adapter<MusicViewHolder>() {

    fun updateItems(newItems: List<com.example.musicApp.model.items.Result>) {
        if (itemSet != newItems) {
            itemSet.clear()
            itemSet.addAll(newItems)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder =
        MusicViewHolder(
            MusicItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) =
        holder.bind(itemSet[position], onItemClick)

    override fun getItemCount(): Int = itemSet.size
}

class MusicViewHolder(
    private val binding: MusicItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: com.example.musicApp.model.items.Result, onItemClick: (Result) -> Unit) {
        Glide
            .with(binding.root)
            .load(item.artworkUrl60)
            .centerCrop()
            .placeholder(R.drawable.baseline_image_search_24)
            .error(R.drawable.baseline_broken_image_24)
            .into(binding.artworkUrl)

        binding.artistName.text = item.artistName ?: "NO NAME PROVIDED"
        binding.collectionName.text = item.collectionName ?: "NO NAME PROVIDED"
        binding.trackPrice.text = (item.trackPrice.toString() ?: "Null") + " USD"

        itemView.setOnClickListener { onItemClick(item) }
    }
}
