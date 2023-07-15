package com.dariwan.suitmediatestapk.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dariwan.suitmediatestapk.databinding.ItemUserBinding
import com.dariwan.suitmediatestapk.response.AllUsersResponse

class AllUsersAdapter:
    PagingDataAdapter<AllUsersResponse.ListUsers, AllUsersAdapter.MaterialViewHolder>(DIFF_CALLBACK){


    class MaterialViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(material: AllUsersResponse.ListUsers){
            binding.tvItemName.text = "${material.first_name} ${material.last_name}"
            binding.tvItemEmail.text = material.email
            Glide.with(itemView.context)
                .load(material.avatar)
                .into(binding.imgItemPhoto)
        }

    }

    override fun onBindViewHolder(holder: AllUsersAdapter.MaterialViewHolder, position: Int) {
        val material = getItem(position)
        if (material != null){
            holder.bind(material)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllUsersAdapter.MaterialViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MaterialViewHolder(binding)
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<AllUsersResponse.ListUsers>(){
            override fun areItemsTheSame(
                oldItem: AllUsersResponse.ListUsers,
                newItem: AllUsersResponse.ListUsers
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: AllUsersResponse.ListUsers,
                newItem: AllUsersResponse.ListUsers
            ): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}