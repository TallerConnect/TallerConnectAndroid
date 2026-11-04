package com.example.tallerconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tallerconnect.R
import com.example.tallerconnect.ui.components.BrandTitle
import com.example.tallerconnect.ui.components.LabeledTextField
import com.example.tallerconnect.ui.components.PrimaryButton
import com.example.tallerconnect.ui.theme.ScreenBackground
import com.example.tallerconnect.ui.theme.TallerConnectTheme
import com.example.tallerconnect.ui.theme.TextMuted

/**
 * Inicio de sesión (CU-12). Sirve también para el primer acceso con contraseña temporal:
 * la pantalla es la misma, solo cambia el flujo que viene después.
 */
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    password: String = "",
    onPasswordChange: (String) -> Unit = {},
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_tallerconnect),
            contentDescription = "Logo TallerConnect",
            modifier = Modifier.size(56.dp)
        )
        Spacer(Modifier.height(16.dp))
        BrandTitle()
        Text("Sigue la reparación de tu vehículo", fontSize = 14.sp, color = TextMuted)
        Spacer(Modifier.height(24.dp))
        LabeledTextField(
            label = "Email",
            value = email,
            onValueChange = onEmailChange,
            placeholder = "tu@email.com",
            keyboardType = KeyboardType.Email
        )
        Spacer(Modifier.height(14.dp))
        LabeledTextField(
            label = "Contraseña",
            value = password,
            onValueChange = onPasswordChange,
            placeholder = "••••••••",
            isPassword = true
        )
        Spacer(Modifier.height(20.dp))
        PrimaryButton(text = "Iniciar sesión", onClick = onLoginClick)
        TextButton(onClick = onRegisterClick) {
            Text("¿No tienes cuenta? Crear cuenta")
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun LoginScreenPreview() {
    TallerConnectTheme { LoginScreen() }
}
