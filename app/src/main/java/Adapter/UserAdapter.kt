package Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewhomework.FirstFragment
import com.example.viewhomework.ListFragment

class UserAdapter( fragmentManager: FragmentManager, private var number: Int):
FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return number
    }

    override fun getItem(position: Int): Fragment {
        return if (position==0){
            FirstFragment()
        } else ListFragment()
    }
}


