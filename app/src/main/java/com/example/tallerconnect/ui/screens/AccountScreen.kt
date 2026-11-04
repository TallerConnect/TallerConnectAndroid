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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tallerconnect.ui.components.BottomTab
import com.example.tallerconnect.ui.components.PrimaryButton
import com.example.tallerconnect.ui.components.ScreenCard
import com.example.tallerconnect.ui.components.SecondaryButton
import com.example.tallerconnect.ui.components.TallerBottomBar
import com.example.tallerconnect.ui.components.TallerTopBar
import com.example.tallerconnect.ui.theme.ScreenBackground
import com.example.tallerconnect.ui.theme.TallerConnectTheme
import com.example.tallerconnect.ui.theme.TextDark
import com.example.tallerconnect.ui.theme.TextMuted

/** Pestaña "Cuenta" del menú inferior. Pantalla añadida para tener dónde cambiar la contraseña y cerrar sesión. */
@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    name: String = "María López",
    email: String = "maria.lopez@email.com",
    onChangePasswordClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {},
    onTabSelected: (BottomTab) -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        containerColor = ScreenBackground,
        topBar = { TallerTopBar(title = "Cuenta") },
        bottomBar = { TallerBottomBar(selected = BottomTab.Cuenta, onTabSelected = onTabSelected) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            ScreenCard {
                Text(name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
                Text(email, fontSize = 14.sp, color = TextMuted)
            }
            Spacer(Modifier.height(20.dp))
            PrimaryButton(text = "Cambiar contraseña", onClick = onChangePasswordClick)
            Spacer(Modifier.height(12.dp))
            SecondaryButton(text = "Cerrar sesión", onClick = onLogoutClick)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun AccountScreenPreview() {
    TallerConnectTheme { AccountScreen() }
}
