package com.example.repo_app_april_2022.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repo_app_april_2022.domain.GitProjectEntity

class GitProjectAdapter : RecyclerView.Adapter<GitProjectVH>() {
    private var data: List<GitProjectEntity> = emptyList()


    fun setData(repos: List<GitProjectEntity>) {
        data = repos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitProjectVH {
        return GitProjectVH.createView(parent)
    }

    override fun onBindViewHolder(holder: GitProjectVH, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(pos:Int): GitProjectEntity= data[pos]


    override fun getItemCount(): Int = data.size


}