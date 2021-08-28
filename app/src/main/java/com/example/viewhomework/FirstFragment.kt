package com.example.viewhomework

import Cache.Cache1
import Modul.MyDataClass
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment : Fragment() {

    lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_first, container, false)


        root.btn_save.setOnClickListener {

            val name = root.edit_name.text.toString().trim()
            val number = root.edit_number.text.toString().trim()



            root.edit_number.text.clear()
            root.edit_name.text.clear()


            if(name != "" && number != ""){
                val list = Cache1.objectString

                list.add(MyDataClass(name, number))

                Cache1.objectString = list


                Toast.makeText(root.context, "Saved!!!", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(root.context, "Something is missing, please check and try again", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    }
