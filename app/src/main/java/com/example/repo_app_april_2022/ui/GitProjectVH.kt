package com.example.repo_app_april_2022.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.repo_app_april_2022.R
import com.example.repo_app_april_2022.databinding.ItemGitProjectBinding
import com.example.repo_app_april_2022.domain.GitProjectEntity
import com.example.repo_app_april_2022.domain.GitUserEntity


class GitProjectVH(private val binding:ItemGitProjectBinding) :RecyclerView.ViewHolder(binding.root) {

    companion object{
        fun createView(parent:ViewGroup):GitProjectVH{
            val inflater = LayoutInflater.from(parent.context)
            return GitProjectVH(ItemGitProjectBinding.inflate(inflater))
        }
    }


    fun bind(item: GitProjectEntity) {

        binding.itemGitRepoId.text = item.fact.id.toString()
        binding.itemGitRepoName.text = item.fact.name
        binding.itemGitRepoDescription.text = item.fact.description
        binding.itemImageView.load(item.fact.avatar_url)


    }

}