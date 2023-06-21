package com.thus.redditpost.ui.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.google.androidbrowserhelper.trusted.TwaLauncher
import com.thus.redditpost.R
import org.koin.core.component.KoinComponent

class WebUtil : KoinComponent {

    fun launchCustomTab(context: Context, url: String) {
        val uri = Uri.parse(url)

        try {
            val launcher = TwaLauncher(context)
            launcher.launch(
                uri
            )
        } catch (exception: ActivityNotFoundException) {
            // this exception received when chrome not installed
            launchUriWithChooser(context, uri)
        }
    }

    private fun launchUriWithChooser(context: Context, uri: Uri) {
        // let user choose external browser
        val browserIntent = Intent(Intent.ACTION_VIEW, uri)
        val chooserIntent = Intent.createChooser(
            browserIntent,
            context.getString(R.string.choose_your_browser)
        )
        try {
            context.startActivity(chooserIntent)
        } catch (exception: ActivityNotFoundException) {
            Toast.makeText(
                context,
                context.getString(R.string.no_browser_found),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}