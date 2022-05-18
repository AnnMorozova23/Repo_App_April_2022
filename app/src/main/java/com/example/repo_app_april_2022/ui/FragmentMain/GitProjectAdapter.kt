package com.example.repo_app_april_2022.ui.FragmentMain

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repo_app_april_2022.domain.entity.GitHubUser

class GitProjectAdapter : RecyclerView.Adapter<GitProjectVH>() {
    private var data: List<GitHubUser> = emptyList()


    fun setData(repos: List<GitHubUser>) {
        data = repos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitProjectVH {
        return GitProjectVH.createView(parent)
    }

    override fun onBindViewHolder(holder: GitProjectVH, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(pos: Int): GitHubUser = data[pos]


    override fun getItemCount(): Int = data.size


}