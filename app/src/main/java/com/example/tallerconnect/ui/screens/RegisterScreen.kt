package com.example.tallerconnect.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tallerconnect.ui.components.LabeledTextField
import com.example.tallerconnect.ui.components.PrimaryButton
import com.example.tallerconnect.ui.theme.ScreenBackground
import com.example.tallerconnect.ui.theme.TallerConnectTheme
import com.example.tallerconnect.ui.components.TallerTopBar

/** Registro de cliente (CU-11). */
@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    name: String = "",
    onNameChange: (String) -> Unit = {},
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    password: String = "",
    onPasswordChange: (String) -> Unit = {},
    repeatPassword: String = "",
    onRepeatPasswordChange: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        containerColor = ScreenBackground,
        topBar = { TallerTopBar(title = "Crear cuenta", showBack = true, onBackClick = onBackClick) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ScreenBackground)
                .padding(padding)
                .padding(20.dp)
        ) {
            LabeledTextField("Nombre", name, onValueChange = onNameChange, placeholder = "Tu nombre")
            Spacer(Modifier.height(14.dp))
            LabeledTextField(
                "Email", email, onValueChange = onEmailChange,
                placeholder = "tu@email.com", keyboardType = KeyboardType.Email
            )
            Spacer(Modifier.height(14.dp))
            LabeledTextField(
                "Contraseña", password, onValueChange = onPasswordChange,
                placeholder = "••••••••", isPassword = true
            )
            Spacer(Modifier.height(14.dp))
            LabeledTextField(
                "Repetir contraseña", repeatPassword, onValueChange = onRepeatPasswordChange,
                placeholder = "••••••••", isPassword = true
            )
            Spacer(Modifier.weight(1f))
            PrimaryButton(text = "Registrarme", onClick = onRegisterClick)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun RegisterScreenPreview() {
    TallerConnectTheme { RegisterScreen() }
}
