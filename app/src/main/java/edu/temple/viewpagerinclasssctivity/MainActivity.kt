package edu.temple.viewpagerinclasssctivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    var numPages = 0

    private val button: Button by lazy {
        findViewById(R.id.button)
    }

    private val viewPager: ViewPager2 by lazy {
        findViewById(R.id.viewPager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            numPages++
            viewPager.adapter?.notifyItemInserted(numPages - 1)

            viewPager.setCurrentItem(numPages - 1, false)
        }

        //supportFragmentManager.findFragmentByTag("fPosition")

        viewPager.adapter = object: FragmentStateAdapter(this) {
            override fun getItemCount() = numPages

            override fun createFragment(position: Int) = TextFragment.newInstance((position + 1).toString())
        }
    }
}