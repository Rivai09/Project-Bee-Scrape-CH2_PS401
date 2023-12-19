package com.dicoding.beescape.screen.page.component

import android.content.Context
import android.content.Intent
import android.widget.Toast

fun sendEmail(context: Context, subject: String, message: String, recipient: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, message)
    }

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(Intent.createChooser(intent, "Choose Email Client"))
    } else {
        Toast.makeText(context, "No email app found", Toast.LENGTH_SHORT).show()
    }

}
