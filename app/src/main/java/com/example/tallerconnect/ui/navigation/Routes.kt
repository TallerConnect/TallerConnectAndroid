package com.example.tallerconnect.ui.navigation

import com.example.tallerconnect.ui.components.BottomTab

/** Nombres de las pantallas (rutas) de la app. */
object Routes {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val VEHICLES = "vehicles"
    const val ADD_VEHICLE = "add_vehicle"
    const val REPAIR_STATUS = "repair_status"
    const val HISTORY = "history"
    const val ACCOUNT = "account"
    const val CHANGE_PASSWORD = "change_password"
}

/** Ruta a la que lleva cada pestaña del menú inferior. */
fun BottomTab.route(): String = when (this) {
    BottomTab.Vehiculos -> Routes.VEHICLES
    BottomTab.Reparacion -> Routes.REPAIR_STATUS
    BottomTab.Historial -> Routes.HISTORY
    BottomTab.Cuenta -> Routes.ACCOUNT
}
