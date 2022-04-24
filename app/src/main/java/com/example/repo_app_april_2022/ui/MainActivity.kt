package com.example.repo_app_april_2022.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repo_app_april_2022.app
import com.example.repo_app_april_2022.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: RepoViewModel by viewModels { RepoViewModelFactory(app.gitProjectRepo) }
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
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setHasStableIds(true)
        binding.recyclerView.adapter = adapter
    }

    private fun initViewModelEvent() {

        viewModel.repos.observe(this) {
            adapter.setData(it)
        }
    }

    private fun initViewEvent() {
        binding.searchButton.setOnClickListener {
            val username = binding.loginEditText.text.toString()
            viewModel.onShowRepos(username)
        }
    }
}