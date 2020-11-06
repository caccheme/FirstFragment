@file:Suppress("UNUSED_VARIABLE")

package com.example.firstfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private var mListener: FragmentListener? = null

    companion object{
        // Use this function to create instance of your fragment
        fun newInstance(person: Person): DetailFragment {
            val args = Bundle()
            args.putParcelable("PERSON_KEY", person)
            val fragment = DetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

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
        val textFirstName = rootView.findViewById<View>(R.id.textFirstName) as EditText
        val textLastName = rootView.findViewById<View>(R.id.textLastName) as EditText
        val textAge = rootView.findViewById<View>(R.id.textAge) as EditText

        val person = this.arguments?.getParcelable<Person>("PERSON_KEY")
        textFirstName.setText(person?.firstName)
        textLastName.setText(person?.lastName)
        textAge.setText(person?.age.toString())

        val doneButton = rootView.findViewById<View>(R.id.done_button) as Button
        doneButton.setOnClickListener { done() }
        return rootView
    }

    private fun done() {

        if(mListener == null){
            throw AssertionError("mListener must not be null")
            //this is always thrown when device is width is less than 820dp
            //will need to update for when using fragment detail activity and not fragment in the main activity
        }
        //send message to the containing activity
        val firstName: String = textFirstName.text.toString()
        val lastName: String = textLastName.text.toString()
        val age: Int = Integer.valueOf(textAge.text.toString())

        val person = Person(firstName, lastName, age)
        mListener?.onFragmentFinish(person)
    }

    interface FragmentListener {
        fun onFragmentFinish(person: Person)
    }

}