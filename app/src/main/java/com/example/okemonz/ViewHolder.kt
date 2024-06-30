package com.example.okemonz

import androidx.recyclerview.widget.RecyclerView
import com.example.okemonz.databinding.CharactersItemsBinding

class ViewHolder(
        private var binding: CharactersItemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: SampleModel, onClick: (SampleModel) -> Unit) {
            binding.apply {
                button1.setOnClickListener {
                    onClick(item)
                }
                profileImage.setImageResource(item.imageRes)
                tvCharacterName.text = item.name
            }
        }
    }