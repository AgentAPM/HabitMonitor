package com.example.habitmonitor

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HabitsList : Fragment() {

    companion object {
        fun newInstance() = HabitsList()
    }

    private lateinit var viewModel: HabitsListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var binding = inflater.inflate(R.layout.habits_list_fragment, container, false)
        return binding
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HabitsListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}