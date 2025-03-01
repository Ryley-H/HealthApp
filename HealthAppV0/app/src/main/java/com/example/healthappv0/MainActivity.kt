package com.example.healthappv0

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        // Load the first fragment by default
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            TextFragment()
        ).commit()
    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_text -> selectedFragment = TextFragment()
                R.id.nav_lr -> selectedFragment = LRFragment()
                R.id.nav_colors -> selectedFragment = ColorsFragment()
                R.id.nav_profile -> selectedFragment = ProfileFragment()
                R.id.nav_choices -> selectedFragment = ChoicesFragment()
                R.id.nav_todo -> selectedFragment = ToDoFragment()
            }

            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                selectedFragment!!
            ).commit()
            true
        }
}