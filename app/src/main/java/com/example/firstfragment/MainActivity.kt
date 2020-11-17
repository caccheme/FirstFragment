package com.example.firstfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(),
    DataEntryDialog.DataEntryListener {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { showDialog() }
    }

    private fun showDialog() {

        val p = Person("Mickey", "Mouse", 35)

        val dialog = DataEntryDialog().newInstance(p)
        dialog.show(supportFragmentManager, "DIALOG_FRAGMENT")
    }

    override fun onDataEntryComplete(person: Person){
        Toast.makeText(this, "You entered ${person.firstName} ${person.lastName}",
            Toast.LENGTH_SHORT).show()
    }

}