package com.unannoying.app

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView

import com.unannoying.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null

    @SuppressLint("NonConstantResourceId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.getRoot())
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set the default selected item
        bottomNavigationView.selectedItemId = R.id.navigation_home
        bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            val fragment: Fragment
            when (item.itemId) {
                R.id.navigation_inspect ->                     // Load the inspect fragment
                    fragment = InspectFragment()
                R.id.navigation_home ->                     // Load the home fragment
                    fragment = HomeFragment()
                R.id.navigation_settings ->                     // Load the settings fragment
                    fragment = SettingsFragment()
                else -> return@setOnItemSelectedListener false
            }
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment)
                .commit()
            true
        }

        // Load the default fragment in onCreate
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HomeFragment())
                .commit()
        }

        // Permissions for SMS functionality and notifications
        val permission = arrayOf(
            Manifest.permission.RECEIVE_SMS,
            Manifest.permission.POST_NOTIFICATIONS,
            Manifest.permission.ACCESS_NOTIFICATION_POLICY
        )
        requestPermissions(permission, 200)
    }
}