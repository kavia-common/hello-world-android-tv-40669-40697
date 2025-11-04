package com.example.android_tv_frontend

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

/**
 * PUBLIC_INTERFACE
 * MainActivity
 *
 * Purpose:
 * - Entry point Activity for the Android TV app using Leanback-friendly FragmentActivity.
 * - Displays a centered "Hello World" message with the Ocean Professional theme.
 *
 * Params:
 * - savedInstanceState: Bundle? - instance state provided by Android runtime.
 *
 * Returns:
 * - None. Sets the content view and handles TV remote key events.
 */
class MainActivity : FragmentActivity() {

    private lateinit var titleText: TextView
    private lateinit var rootContainer: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootContainer = findViewById(R.id.root_container)
        titleText = findViewById(R.id.title_text)

        // Ensure root is focusable to avoid D-pad focus traps on TVs
        rootContainer.isFocusable = true
        rootContainer.isFocusableInTouchMode = true
        rootContainer.requestFocus()

        // Set the display text
        titleText.text = "Hello World"
        titleText.isFocusable = true
        titleText.isFocusableInTouchMode = true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Handle TV remote control inputs gracefully
        return when (keyCode) {
            KeyEvent.KEYCODE_DPAD_CENTER,
            KeyEvent.KEYCODE_ENTER -> {
                // Acknowledge selection on hero text without side effects
                true
            }
            KeyEvent.KEYCODE_BACK -> {
                // Exit activity on back
                finish()
                true
            }
            else -> super.onKeyDown(keyCode, event)
        }
    }
}
