package com.example.firstfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.firstfragment.constants.LIFECYCLE_TAG

class SimpleFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(LIFECYCLE_TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(LIFECYCLE_TAG, "onCreate")
    }

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

        Log.i(LIFECYCLE_TAG, "onCreateView")
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

    override fun onResume() {
        super.onResume()
        Log.i(LIFECYCLE_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LIFECYCLE_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LIFECYCLE_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LIFECYCLE_TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(LIFECYCLE_TAG, "onDetach")
    }

}