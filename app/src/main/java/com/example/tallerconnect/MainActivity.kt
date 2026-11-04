package com.example.tallerconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tallerconnect.ui.theme.TallerConnectTheme
import com.example.tallerconnect.ui.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TallerConnectTheme {
                LoginScreen()
            }
        }
    }
}