package com.example.firstfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.firstfragment.constants.PERSON_KEY

class DataEntryDialog : DialogFragment() {
    var etFirstName: EditText? = null
    var etLastName:EditText? = null
    var etAge:EditText? = null

    fun newInstance(person: Person): DataEntryDialog {
        val args = Bundle()
        args.putParcelable(PERSON_KEY, person)
        val fragment = DataEntryDialog()
        fragment.arguments = args
        return fragment
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.data_entry_dialog, container, false)

        etFirstName = rootView.findViewById<View>(R.id.textFirstName) as EditText
        etLastName = rootView.findViewById<View>(R.id.textLastName) as EditText
        etAge = rootView.findViewById<View>(R.id.textAge) as EditText

        val person = this.arguments?.getParcelable<Person>(PERSON_KEY)
        etFirstName!!.setText(person?.firstName)
        etLastName!!.setText(person?.lastName)
        etAge!!.setText(person?.age.toString())

        val btnOk = rootView.findViewById<View>(R.id.btnOk)
        btnOk.setOnClickListener { dismiss() }

        val btnCancel = rootView.findViewById<View>(R.id.btnCancel)
        btnCancel.setOnClickListener { dismiss() }

        return rootView
    }
}