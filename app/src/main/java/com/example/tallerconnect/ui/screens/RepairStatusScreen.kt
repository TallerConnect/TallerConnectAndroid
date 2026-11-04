package com.example.tallerconnect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tallerconnect.ui.components.BottomTab
import com.example.tallerconnect.ui.components.ScreenCard
import com.example.tallerconnect.ui.components.SecondaryButton
import com.example.tallerconnect.ui.components.StatusChip
import com.example.tallerconnect.ui.components.TallerBottomBar
import com.example.tallerconnect.ui.components.TallerTopBar
import com.example.tallerconnect.ui.model.IncidenceUi
import com.example.tallerconnect.ui.theme.BorderGray
import com.example.tallerconnect.ui.theme.Primary
import com.example.tallerconnect.ui.theme.ScreenBackground
import com.example.tallerconnect.ui.theme.TallerConnectTheme
import com.example.tallerconnect.ui.theme.TextDark
import com.example.tallerconnect.ui.theme.TextMuted

/** Estado de la reparación (CU-14). */
@Composable
fun RepairStatusScreen(
    modifier: Modifier = Modifier,
    title: String = "Seat León · 1234ABC",
    status: String = "En curso",
    remaining: String = "Tiempo estimado restante: 20 min",
    progress: Float = 0.5f,
    progressText: String = "1 de 2 incidencias completadas",
    estimatedDelivery: String = "Entrega estimada: 12:30",
    incidences: List<IncidenceUi> = listOf(
        IncidenceUi("Cambio de aceite", "Completada", true),
        IncidenceUi("Revisión de neumáticos", "Pendiente", false)
    ),
    onBackClick: () -> Unit = {},
    onHistoryClick: () -> Unit = {},
    onTabSelected: (BottomTab) -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        containerColor = ScreenBackground,
        topBar = { TallerTopBar(title = title, showBack = true, onBackClick = onBackClick) },
        bottomBar = { TallerBottomBar(selected = BottomTab.Reparacion, onTabSelected = onTabSelected) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            ScreenCard {
                StatusChip(text = status, active = true)
                Spacer(Modifier.height(10.dp))
                Text(remaining, fontSize = 14.sp, color = TextDark)
                Spacer(Modifier.height(10.dp))
                LinearProgressIndicator(
                    progress = { progress },
                    color = Primary,
                    trackColor = BorderGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                )
                Spacer(Modifier.height(8.dp))
                Text(progressText, fontSize = 13.sp, color = TextMuted)
                Text(estimatedDelivery, fontSize = 13.sp, color = TextMuted)
            }
            Spacer(Modifier.height(20.dp))
            Text("Incidencias", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Spacer(Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(incidences) { incidence -> IncidenceRow(incidence) }
            }
            Spacer(Modifier.height(12.dp))
            SecondaryButton(text = "Ver historial", onClick = onHistoryClick)
        }
    }
}

@Composable
private fun IncidenceRow(incidence: IncidenceUi) {
    ScreenCard {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // onCheckedChange = null: solo se muestra, el cliente no puede marcarlas.
            Checkbox(checked = incidence.completada, onCheckedChange = null)
            Spacer(Modifier.padding(horizontal = 6.dp))
            Text(incidence.nombre, fontSize = 15.sp, color = TextDark, modifier = Modifier.weight(1f))
            Text(incidence.estado, fontSize = 13.sp, color = TextMuted)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun RepairStatusScreenPreview() {
    TallerConnectTheme { RepairStatusScreen() }
}
