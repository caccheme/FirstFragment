package com.example.firstfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.firstfragment.constants.FRAGMENT_TAG
import com.example.firstfragment.constants.PERSON_KEY

class DataEntryDialog : DialogFragment() {
    var etFirstName: EditText? = null
    var etLastName:EditText? = null
    var etAge:EditText? = null
    private lateinit var mListener: DataEntryListener

    fun newInstance(person: Person): DataEntryDialog {
        val args = Bundle()
        args.putParcelable(PERSON_KEY, person)
        val fragment = DataEntryDialog()
        fragment.arguments = args
        return fragment
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is DataEntryListener) {
            mListener = context
        }
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
        btnOk.setOnClickListener {
            saveData() }

        val btnCancel = rootView.findViewById<View>(R.id.btnCancel)
        btnCancel.setOnClickListener { dismiss() }

        return rootView
    }

    private fun saveData() {
        val person = Person("", "", 0)
        person.firstName = etFirstName?.text.toString()
        person.lastName = etLastName?.text.toString()
        person.age = Integer.valueOf(etAge?.text.toString())

        mListener.onDataEntryComplete(person)
        dismiss()
    }

    interface DataEntryListener {
        fun onDataEntryComplete(person: Person) {
            Log.i(FRAGMENT_TAG, "onDataEntryDialogFinish: ${person.firstName}, ${person.lastName}, ${person.age}")
        }
    }
}