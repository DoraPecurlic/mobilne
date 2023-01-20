package com.example.helporlearn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import com.example.helporlearn.Adapter.InstructorAdapter


class InstructorsListFragment : Fragment() {

   // private lateinit var instructorAdapter: InstructorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instructors_list, container, false)
    }


}