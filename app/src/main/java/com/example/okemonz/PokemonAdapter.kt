package com.example.okemonz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.okemonz.databinding.CharactersItemsBinding

class PokemonAdapter : RecyclerView.Adapter<ViewHolder>() {
    var onClick: (SampleModel) -> Unit = { }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CharactersItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position], onClick)
        holder.setIsRecyclable(false)
    }

    override fun getItemCount() = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<SampleModel>() {
        override fun areItemsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)
}