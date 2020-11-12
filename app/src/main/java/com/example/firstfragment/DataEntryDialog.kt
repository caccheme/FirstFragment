package com.example.firstfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class DataEntryDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.data_entry_dialog, container, false)

        val btnOk = rootView.findViewById<View>(R.id.btnOk)
        btnOk.setOnClickListener { dismiss() }

        val btnCancel = rootView.findViewById<View>(R.id.btnCancel)
        btnCancel.setOnClickListener { dismiss() }

        return rootView
    }
}