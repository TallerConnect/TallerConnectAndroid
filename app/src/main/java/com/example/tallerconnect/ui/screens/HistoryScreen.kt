package com.example.tallerconnect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tallerconnect.ui.components.BottomTab
import com.example.tallerconnect.ui.components.ScreenCard
import com.example.tallerconnect.ui.components.TallerBottomBar
import com.example.tallerconnect.ui.components.TallerTopBar
import com.example.tallerconnect.ui.model.HistoryItemUi
import com.example.tallerconnect.ui.theme.ScreenBackground
import com.example.tallerconnect.ui.theme.TallerConnectTheme
import com.example.tallerconnect.ui.theme.TextDark
import com.example.tallerconnect.ui.theme.TextMuted

/** Historial de reparaciones de un vehículo (CU-15). */
@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    title: String = "Historial · Seat León",
    historyItems: List<HistoryItemUi> = listOf(
        HistoryItemUi("#07 · Entregada", "12/10/2026", "Cambio de aceite, Revisión de neumáticos"),
        HistoryItemUi("#03 · Entregada", "03/09/2026", "Revisión general"),
        HistoryItemUi("#01 · Entregada", "20/06/2026", "Cambio de batería")
    ),
    onBackClick: () -> Unit = {},
    onTabSelected: (BottomTab) -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        containerColor = ScreenBackground,
        topBar = { TallerTopBar(title = title, showBack = true, onBackClick = onBackClick) },
        bottomBar = { TallerBottomBar(selected = BottomTab.Historial, onTabSelected = onTabSelected) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(historyItems) { item ->
                ScreenCard {
                    Text(item.titulo, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
                    Text(item.fecha, fontSize = 13.sp, color = TextMuted)
                    Text(item.detalle, fontSize = 14.sp, color = TextDark)
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun HistoryScreenPreview() {
    TallerConnectTheme { HistoryScreen() }
}
