package com.example.viewhomework


import Adapter1
import Cache.Cache1
import Modul.MyDataClass
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.item_rv.*
import kotlinx.android.synthetic.main.item_rv.view.*
import java.lang.reflect.Field


class ListFragment : Fragment() {

    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_list, container, false)

        Cache1.init(root.context)





                return root
            }

            override fun onResume() {
                super.onResume()

                root.recycler_list.adapter = Adapter1(root.context, Cache1.objectString)

            }
        }




   

