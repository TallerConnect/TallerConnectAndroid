package com.example.tallerconnect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.example.tallerconnect.ui.components.PrimaryButton
import com.example.tallerconnect.ui.components.ScreenCard
import com.example.tallerconnect.ui.components.StatusChip
import com.example.tallerconnect.ui.components.TallerBottomBar
import com.example.tallerconnect.ui.components.TallerTopBar
import com.example.tallerconnect.ui.model.VehicleUi
import com.example.tallerconnect.ui.theme.ScreenBackground
import com.example.tallerconnect.ui.theme.TallerConnectTheme
import com.example.tallerconnect.ui.theme.TextDark
import com.example.tallerconnect.ui.theme.TextMuted

/** Mis vehículos (CU-13, CU-14). */
@Composable
fun VehiclesScreen(
    modifier: Modifier = Modifier,
    vehicles: List<VehicleUi> = listOf(
        VehicleUi("Seat León", "1234ABC", "En reparación · 20 min restantes", true),
        VehicleUi("Peugeot 208", "4321XYZ", "Sin reparaciones activas", false)
    ),
    onVehicleClick: (VehicleUi) -> Unit = {},
    onAddVehicleClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {},
    onTabSelected: (BottomTab) -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        containerColor = ScreenBackground,
        topBar = { TallerTopBar(title = "Mis vehículos", actionText = "Salir", onActionClick = onLogoutClick) },
        bottomBar = { TallerBottomBar(selected = BottomTab.Vehiculos, onTabSelected = onTabSelected) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(vehicles) { vehicle ->
                    VehicleCard(vehicle = vehicle, onClick = { onVehicleClick(vehicle) })
                }
            }
            Spacer(Modifier.height(12.dp))
            PrimaryButton(text = "Añadir vehículo", onClick = onAddVehicleClick)
        }
    }
}

@Composable
private fun VehicleCard(vehicle: VehicleUi, onClick: () -> Unit) {
    // Para que toda la tarjeta sea pulsable más adelante: Modifier.clickable(onClick = onClick)
    ScreenCard {
        Text(vehicle.modelo, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
        Text(vehicle.matricula, fontSize = 14.sp, color = TextMuted)
        Spacer(Modifier.height(8.dp))
        StatusChip(text = vehicle.estado, active = vehicle.enReparacion)
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun VehiclesScreenPreview() {
    TallerConnectTheme { VehiclesScreen() }
}
