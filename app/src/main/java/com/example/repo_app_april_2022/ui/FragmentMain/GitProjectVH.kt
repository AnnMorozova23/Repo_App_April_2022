package com.example.repo_app_april_2022.ui.FragmentMain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.repo_app_april_2022.data.DTO.GitHubUserDTO
import com.example.repo_app_april_2022.databinding.ItemGitProjectBinding
import com.example.repo_app_april_2022.domain.entity.GitHubUser


class GitProjectVH(private val binding: ItemGitProjectBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun createView(parent: ViewGroup): GitProjectVH {
            val inflater = LayoutInflater.from(parent.context)
            return GitProjectVH(ItemGitProjectBinding.inflate(inflater))
        }
    }


    fun bind(item: GitHubUser) {
        binding.itemGitRepoId.text = item.id.toString()
        binding.itemGitRepoName.text = item.name
        binding.itemImageView.load(item.avatarUrl)


    }

}