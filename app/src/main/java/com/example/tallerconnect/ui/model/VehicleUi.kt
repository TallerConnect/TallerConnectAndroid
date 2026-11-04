package com.example.tallerconnect.ui.model

data class VehicleUi(
    val modelo: String,
    val matricula: String,
    val estado: String,
    val enReparacion: Boolean
)

data class HistoryItemUi(
    val titulo: String,
    val fecha: String,
    val detalle: String
)