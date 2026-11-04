package com.example.tallerconnect.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tallerconnect.ui.components.BottomTab
import com.example.tallerconnect.ui.screens.AccountScreen
import com.example.tallerconnect.ui.screens.AddVehicleScreen
import com.example.tallerconnect.ui.screens.ChangePasswordScreen
import com.example.tallerconnect.ui.screens.HistoryScreen
import com.example.tallerconnect.ui.screens.LoginScreen
import com.example.tallerconnect.ui.screens.RegisterScreen
import com.example.tallerconnect.ui.screens.RepairStatusScreen
import com.example.tallerconnect.ui.screens.VehiclesScreen

/**
 * Navegación de la app, equivalente al prototipo navegable de Figma.
 * Solo mueve al usuario de una pantalla a otra: no valida nada ni guarda datos.
 *
 * Para probar el flujo del primer acceso con contraseña temporal, cambia
 * startDestination a Routes.CHANGE_PASSWORD.
 */
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.LOGIN
) {
    // Ir a una pantalla vaciando todo lo anterior (tras iniciar sesión o cerrar sesión).
    val clearAndGo: (String) -> Unit = { route ->
        navController.navigate(route) {
            popUpTo(navController.graph.id) { inclusive = true }
            launchSingleTop = true
        }
    }

    // Cambiar de pestaña del menú inferior.
    val goToTab: (BottomTab) -> Unit = { tab ->
        navController.navigate(tab.route()) {
            popUpTo(Routes.VEHICLES) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginClick = { clearAndGo(Routes.VEHICLES) },
                onRegisterClick = { navController.navigate(Routes.REGISTER) }
            )
        }
        composable(Routes.REGISTER) {
            RegisterScreen(
                onBackClick = { navController.popBackStack() },
                onRegisterClick = { clearAndGo(Routes.VEHICLES) }
            )
        }
        composable(Routes.VEHICLES) {
            VehiclesScreen(
                onVehicleClick = { goToTab(BottomTab.Reparacion) },
                onAddVehicleClick = { navController.navigate(Routes.ADD_VEHICLE) },
                onLogoutClick = { clearAndGo(Routes.LOGIN) },
                onTabSelected = goToTab
            )
        }
        composable(Routes.ADD_VEHICLE) {
            AddVehicleScreen(
                onBackClick = { navController.popBackStack() },
                onSaveClick = { navController.popBackStack() },
                onCancelClick = { navController.popBackStack() }
            )
        }
        composable(Routes.REPAIR_STATUS) {
            RepairStatusScreen(
                onBackClick = { goToTab(BottomTab.Vehiculos) },
                onHistoryClick = { goToTab(BottomTab.Historial) },
                onTabSelected = goToTab
            )
        }
        composable(Routes.HISTORY) {
            HistoryScreen(
                onBackClick = { goToTab(BottomTab.Reparacion) },
                onTabSelected = goToTab
            )
        }
        composable(Routes.ACCOUNT) {
            AccountScreen(
                onChangePasswordClick = { navController.navigate(Routes.CHANGE_PASSWORD) },
                onLogoutClick = { clearAndGo(Routes.LOGIN) },
                onTabSelected = goToTab
            )
        }
        composable(Routes.CHANGE_PASSWORD) {
            ChangePasswordScreen(
                onSaveClick = { clearAndGo(Routes.VEHICLES) }
            )
        }
    }
}
