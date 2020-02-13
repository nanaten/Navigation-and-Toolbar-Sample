package com.nanaten.navigation_and_toolbar_sample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        go_to_second.setOnClickListener { findNavController().navigate(R.id.action_first_to_second) }
        go_to_third.setOnClickListener { findNavController().navigate(R.id.action_first_to_third) }
        go_to_fourth.setOnClickListener {
            val title = title_text.text.toString()
            val args = FirstFragmentDirections.actionFirstToFourth(title)
            findNavController().navigate(args)
        }
        go_to_fifth.setOnClickListener {
            val title = title_text.text.toString()
            val args = FirstFragmentDirections.actionFirstToFifth(title)
            findNavController().navigate(args)
        }
    }

}
