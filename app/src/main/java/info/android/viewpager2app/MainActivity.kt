package info.android.viewpager2app


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*


class MainActivity : FragmentActivity() {

    private var badge_position: Int = 3
    private val TAG = "MainActivity"

    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private val tabNames: Array<String> = arrayOf(
        "Пн",
        "Вт",
        "Ср",
        "Чт",
        "Пт"
    )
    private val tabNumbers: Array<Int> = arrayOf(
        R.drawable.baseline_looks_one_black_48,
        R.drawable.baseline_looks_two_black_48,
        R.drawable.baseline_looks_3_black_48,
        R.drawable.baseline_looks_4_black_48,
        R.drawable.baseline_looks_5_black_48
    )

    override fun onResume() {
        super.onResume()
        val calendar: Calendar = Calendar.getInstance()
        val day: Int = calendar.get(Calendar.DAY_OF_WEEK)
        if (day >= 7) {
            viewPager.currentItem = 0
        } else
            viewPager.currentItem = day - 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = NumberAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]
            tab.setIcon(tabNumbers[position])

            if (position == badge_position) {
                val badge = tab.getOrCreateBadge()
                badge.number = 1
                //tab1.removeBadge()
            }

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab1: TabLayout.Tab?) {
                    // Handle tab select
                    if(position == badge_position){
                        tab1?.removeBadge()
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                   println(tab)
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    println(tab)
                }
            })

//            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageScrollStateChanged(state: Int) {
//                    println(state)
//                }
//
//                override fun onPageScrolled(
//                    position: Int,
//                    positionOffset: Float,
//                    positionOffsetPixels: Int
//                ) {
//                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
//                    println(position)
//                }
//
//
//                override fun onPageSelected(position: Int) {
//                    super.onPageSelected(position)
//                    println(position)
//                    //tab.removeBadge();
//                }
//            })

            val calendar: Calendar = Calendar.getInstance()
            val day: Int = calendar.get(Calendar.DAY_OF_WEEK)
            if (day >= 6) {
                viewPager.currentItem = 0
            } else
                viewPager.currentItem = day - 2
            Log.e(TAG, day.toString())

        }.attach()

    }

}