package com.example.repo_app_april_2022.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.repo_app_april_2022.databinding.ActivityMainBinding
import com.example.repo_app_april_2022.ui.FragmentMain.MainFragment

class MainActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val masterFragment:Fragment = MainFragment()
            supportFragmentManager
                .beginTransaction()
                .add(binding.fragmentMainContainer.id, masterFragment)
                .commit()
        }
    }
}