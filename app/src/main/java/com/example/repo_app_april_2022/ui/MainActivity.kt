package com.example.repo_app_april_2022.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repo_app_april_2022.app
import com.example.repo_app_april_2022.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: RepoViewModel by viewModels{RepoViewModelFactory(app.gitProjectRepo)}
    private val adapter = GitProjectAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewEvent()
        initViewModelEvent()
        initView()



    }

    private fun initView() {
        binding.recyclerViw.layoutManager = LinearLayoutManager(this)
        adapter.setHasStableIds(true)
        binding.recyclerViw.adapter = adapter
    }

    private fun initViewModelEvent() {

        viewModel.repos.observe(this) {
            adapter.setData(it)
        }
    }

    private fun initViewEvent() {
        binding.searchGitBtn.setOnClickListener {
            val username = binding.editLoginText.text.toString()
            viewModel.onShowRepos(username)
        }
    }
}