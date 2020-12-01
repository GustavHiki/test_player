package com.gustavhiki.testplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListenerOnButtomNavigationView()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PlayerFragment())
            .commit()
    }

    private fun setListenerOnButtomNavigationView() {
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_home -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.page_music_list -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.page_main -> {
                    // Respond to navigation item 3 click
                    true
                }
                R.id.page_history -> {
                    // Respond to navigation item 4 click
                    true
                }
                R.id.page_search -> {
                    // Respond to navigation item 5 click
                    true
                }
                else -> false
            }
        }
    }
}