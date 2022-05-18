package com.example.repo_app_april_2022.ui.FragmentMain

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repo_app_april_2022.R
import com.example.repo_app_april_2022.app
import com.example.repo_app_april_2022.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    private val viewModel: RepoViewModel by activityViewModels() {
        RepoViewModelFactory(app.gitProjectRepo)
    }


    private val adapter = GitProjectAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMainBinding.bind(view)

        initViewEvent()
        initViewModelEvent()
        initView()
    }

    private fun initView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setHasStableIds(true)
        binding.recyclerView.adapter = adapter
    }

    private fun initViewModelEvent() {

        viewModel.repos.observe(requireActivity()) {
            adapter.setData(it)
        }
    }

    private fun initViewEvent() {
        binding.searchButton.setOnClickListener {
            val user = binding.loginEditText.text.toString()
            viewModel.onShowRepos(user)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}