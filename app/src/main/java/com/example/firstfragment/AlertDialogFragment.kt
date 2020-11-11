package com.example.firstfragment

import android.app.AlertDialog.Builder
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AlertDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Builder(activity)
            .setMessage("Here's some important info!")
            .setPositiveButton("Ok") { dialog, id ->
                dialog.dismiss()
            }
            .show()
    }
}