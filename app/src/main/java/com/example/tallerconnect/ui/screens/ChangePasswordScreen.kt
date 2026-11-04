package com.example.tallerconnect.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tallerconnect.ui.components.LabeledTextField
import com.example.tallerconnect.ui.components.PrimaryButton
import com.example.tallerconnect.ui.components.TallerTopBar
import com.example.tallerconnect.ui.theme.ScreenBackground
import com.example.tallerconnect.ui.theme.TallerConnectTheme
import com.example.tallerconnect.ui.theme.TextMuted

/**
 * Cambiar contraseña (CU-19). Sin barra inferior ni flecha atrás: es obligatoria
 * en el primer acceso con contraseña temporal.
 */
@Composable
fun ChangePasswordScreen(
    modifier: Modifier = Modifier,
    message: String = "Tu cuenta tiene una contraseña temporal. Elige una nueva para continuar.",
    newPassword: String = "",
    onNewPasswordChange: (String) -> Unit = {},
    repeatPassword: String = "",
    onRepeatPasswordChange: (String) -> Unit = {},
    onSaveClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        containerColor = ScreenBackground,
        topBar = { TallerTopBar(title = "Cambiar contraseña") }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
        ) {
            Text(message, fontSize = 14.sp, color = TextMuted)
            Spacer(Modifier.height(20.dp))
            LabeledTextField(
                "Nueva contraseña", newPassword, onValueChange = onNewPasswordChange,
                placeholder = "••••••••", isPassword = true
            )
            Spacer(Modifier.height(14.dp))
            LabeledTextField(
                "Repetir nueva contraseña", repeatPassword, onValueChange = onRepeatPasswordChange,
                placeholder = "••••••••", isPassword = true
            )
            Spacer(Modifier.weight(1f))
            PrimaryButton(text = "Guardar contraseña", onClick = onSaveClick)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun ChangePasswordScreenPreview() {
    TallerConnectTheme { ChangePasswordScreen() }
}
