package com.example.firstjetpackcompose.screen.map

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstjetpackcompose.screen.common.AppBarCommon
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun TrackingScreen(navController: NavController) {
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 15f)
    }

    RequestLocationPermission {
        Box {
            Column {
                GoogleMap(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    cameraPositionState = cameraPositionState, onMyLocationButtonClick = { true },
                    properties = MapProperties(
                        isMyLocationEnabled = true // Bật vị trí hiện tại
                    ),
                    uiSettings = MapUiSettings(
                        myLocationButtonEnabled = true // Bật nút quay về vị trí
                    ),
                ) {
                    Marker(
                        state = MarkerState(position = singapore),
                        title = "Marker in Singapore",
                        snippet = "This is a marker example"
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    InformationDeliveryView()
                }
            }

            AppBarCommon(navController = navController, title = "Tracking")
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestLocationPermission(onGranted: @Composable () -> Unit) {
    val context = LocalContext.current
    val permissionState = rememberPermissionState(
        permission = android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    LaunchedEffect(Unit) {
        permissionState.launchPermissionRequest()
    }

    when {
        permissionState.status.isGranted -> {
            onGranted()
        }
        permissionState.status.shouldShowRationale -> {
            Toast.makeText(context, "Ứng dụng cần quyền vị trí để hoạt động", Toast.LENGTH_SHORT).show()
        }

        else -> {
            // Đợi người dùng cho phép
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DraggableBottomSheetExample() {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    val isSheetOpen = remember { mutableStateOf(true) }

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val maxSheetHeight = screenHeight / 2

    // Hiển thị Bottom Sheet nếu true
    if (isSheetOpen.value) {
        ModalBottomSheet(
            onDismissRequest = { isSheetOpen.value = false },
            sheetState = sheetState
        ) {
            Column(modifier = Modifier.heightIn(max = maxSheetHeight)) {
                InformationDeliveryView()
            }
        }
    }
}