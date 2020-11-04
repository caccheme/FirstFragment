package com.example.firstfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class DetailFragment : Fragment() {

    private lateinit var mListener: FragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        //check if context is fragment listener
        if (context is FragmentListener) {
            mListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
//        var textFirstName = rootView.findViewById<View>(R.id.textFirstName) as EditText
//        var textLastName = rootView.findViewById<View>(R.id.textLastName) as EditText
//        var textAge = rootView.findViewById<View>(R.id.textAge) as EditText
        val doneButton = rootView.findViewById<View>(R.id.done_button) as Button
        doneButton.setOnClickListener { done() }
        return rootView
    }

    private fun done() {
        //send message to the containing activity
    }

    interface FragmentListener {
        fun onFragmentFinish(firstName: String, lastName: String, age: Int)
    }

}