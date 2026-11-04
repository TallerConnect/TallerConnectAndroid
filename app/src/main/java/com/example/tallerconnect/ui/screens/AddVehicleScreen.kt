package com.example.tallerconnect.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tallerconnect.ui.components.LabeledTextField
import com.example.tallerconnect.ui.components.PrimaryButton
import com.example.tallerconnect.ui.components.SecondaryButton
import com.example.tallerconnect.ui.components.TallerTopBar
import com.example.tallerconnect.ui.theme.ScreenBackground
import com.example.tallerconnect.ui.theme.TallerConnectTheme

/** Añadir vehículo (CU-13). */
@Composable
fun AddVehicleScreen(
    modifier: Modifier = Modifier,
    plate: String = "",
    onPlateChange: (String) -> Unit = {},
    brand: String = "",
    onBrandChange: (String) -> Unit = {},
    model: String = "",
    onModelChange: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {},
    onCancelClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        containerColor = ScreenBackground,
        topBar = { TallerTopBar(title = "Añadir vehículo", showBack = true, onBackClick = onBackClick) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
        ) {
            LabeledTextField("Matrícula", plate, onValueChange = onPlateChange, placeholder = "1234ABC")
            Spacer(Modifier.height(14.dp))
            LabeledTextField("Marca", brand, onValueChange = onBrandChange, placeholder = "Seat")
            Spacer(Modifier.height(14.dp))
            LabeledTextField("Modelo", model, onValueChange = onModelChange, placeholder = "León")
            Spacer(Modifier.weight(1f))
            PrimaryButton(text = "Guardar", onClick = onSaveClick)
            Spacer(Modifier.height(12.dp))
            SecondaryButton(text = "Cancelar", onClick = onCancelClick)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun AddVehicleScreenPreview() {
    TallerConnectTheme { AddVehicleScreen() }
}
