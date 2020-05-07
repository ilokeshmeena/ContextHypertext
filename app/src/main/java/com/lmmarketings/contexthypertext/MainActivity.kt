package com.lmmarketings.contexthypertext

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.lmmarketings.contexthypertext.pages.*
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {
    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (bottom_navigation.visibility == View.GONE) {
            bottom_navigation.visibility = View.VISIBLE
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, page1()).addToBackStack("0").commit()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_back -> {
                    onBackPressed()
                }
                R.id.action_home -> {
                    val i = backButtonKeys.last()
                    if (i != 1) {
                        endTime = System.currentTimeMillis()
                        timeTaken[i] = timeTaken[i] + ((endTime!! - startTime!!).toDouble() / 1000)
                        supportFragmentManager!!.beginTransaction().replace(R.id.container, page1())
                            .addToBackStack(i.toString()).commit()
                    } else {
                        Toast.makeText(this, "Your'e on home page", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.action_end -> {
                    if (isVisitedToAll()) {
                        endTime = System.currentTimeMillis()
                        timeTaken[backButtonKeys.last()] =
                            timeTaken[backButtonKeys.last()] + ((endTime!! - startTime!!).toDouble() / 1000)
                        bottom_navigation.visibility = View.GONE
                        supportFragmentManager!!.beginTransaction()
                            .replace(R.id.container, Result())
                            .addToBackStack(backButtonKeys.last().toString()).commit()
                    } else {
                        Toast.makeText(this, "You've not visited all pages yet", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                R.id.action_next -> {
                    onForwardButtonPressed()
                }
            }
            true
        }

    }

    @ExperimentalStdlibApi
    override fun onBackPressed() {
        if (isLastPage) {
            Toast.makeText(this, "Click on buttons below", Toast.LENGTH_SHORT).show()
        } else if (backButtonKeys.isNotEmpty() && backButtonKeys.last()>1) {
            super.onBackPressed()
            onBackButtonPressed()
        } else {
            Toast.makeText(this, "Your'e on the first page", Toast.LENGTH_SHORT).show()
        }

    }

    @ExperimentalStdlibApi
    fun onForwardButtonPressed() {
        if (backButtonKeys.isNotEmpty()) {
            when (backButtonKeys.last()) {
                1 -> {
                    endTime = System.currentTimeMillis()
                    timeTaken[1] = timeTaken[1] + ((endTime!! - startTime!!).toDouble() / 1000)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page2())
                        .addToBackStack("1").commit()
                }
                2 -> {
                    endTime = System.currentTimeMillis()
                    timeTaken[2] = timeTaken[2] + ((endTime!! - startTime!!).toDouble() / 1000)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page3())
                        .addToBackStack("2").commit()
                }
                3 -> {
                    endTime = System.currentTimeMillis()
                    timeTaken[3] = timeTaken[3] + ((endTime!! - startTime!!).toDouble() / 1000)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page4())
                        .addToBackStack("3").commit()
                }
                4 -> {
                    endTime = System.currentTimeMillis()
                    timeTaken[4] = timeTaken[4] + ((endTime!! - startTime!!).toDouble() / 1000)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page5())
                        .addToBackStack("4").commit()
                }
                5 -> {
                    endTime = System.currentTimeMillis()
                    timeTaken[5] = timeTaken[5] + ((endTime!! - startTime!!).toDouble() / 1000)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page6())
                        .addToBackStack("5").commit()
                }
                6 -> {
                    endTime = System.currentTimeMillis()
                    timeTaken[6] = timeTaken[6] + ((endTime!! - startTime!!).toDouble() / 1000)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page7())
                        .addToBackStack("6").commit()
                }
                7 -> {
                    endTime = System.currentTimeMillis()
                    timeTaken[7] = timeTaken[7] + ((endTime!! - startTime!!).toDouble() / 1000)
                    supportFragmentManager!!.beginTransaction().replace(R.id.container, page8())
                        .addToBackStack("7").commit()
                }
                8 -> {
                    if (isVisitedToAll()) {
                        endTime = System.currentTimeMillis()
                        timeTaken[8] = timeTaken[8] + ((endTime!! - startTime!!).toDouble() / 1000)
                        bottom_navigation.visibility = View.GONE
                        supportFragmentManager!!.beginTransaction()
                            .replace(R.id.container, Result())
                            .addToBackStack("8").commit()
                    } else {
                        Toast.makeText(this, "You've not visited all pages yet", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.container, page1())
                .commit()
        }
    }

    @ExperimentalStdlibApi
    fun onBackButtonPressed() {
        val lastElement = backButtonKeys.last()
        backButtonKeys.removeLast()
        when (lastElement) {
            1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, page1())
                    .commit()
            }
            2 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, page2())
                    .commit()
            }
            3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, page3())
                    .commit()
            }
            4 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, page4())
                    .commit()
            }
            5 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, page5())
                    .commit()
            }
            6 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, page6())
                    .commit()
            }
            7 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, page7())
                    .commit()
            }
            8 -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, page8())
                    .commit()
            }
        }
    }

    private fun isVisitedToAll(): Boolean {
        for (i in 1..8) {
            if (isVisited[i] == 0) {
                return false
            }
        }
        return true
    }
}