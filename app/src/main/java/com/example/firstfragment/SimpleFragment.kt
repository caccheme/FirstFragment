package com.example.firstfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SimpleFragment : Fragment() {

    companion object {
        const val MESSAGE_KEY = "message_key"
    }

    fun newInstance(message: String): SimpleFragment {
        val args = Bundle()
        args.putString(MESSAGE_KEY, message)

        val fragment = SimpleFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_simple, container, false)

        arguments
        if (arguments != null) {
            val m = arguments!!.getString(MESSAGE_KEY)
            val tvMessage: TextView = view.findViewById(R.id.message)
            tvMessage.text = m
        }

        return view
    }

}