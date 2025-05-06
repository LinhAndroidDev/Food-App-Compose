package com.example.firstjetpackcompose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpackcompose.R
import com.example.firstjetpackcompose.ui.theme.BackGroundCommon
import com.example.firstjetpackcompose.ui.theme.Green

enum class BottomNavigationItem(
    val icon: Int,
    val iconSelected: Int,
    val label: String
) {
    HOME(R.drawable.ic_home, R.drawable.ic_home_fill, "Home"),
    FAVOURITE(R.drawable.ic_favourite, R.drawable.ic_favourite_fill, "Favourite"),
    STORE(R.drawable.ic_store, R.drawable.ic_store_fill, "Store"),
    EXTENSION(R.drawable.ic_extension, R.drawable.ic_extension_fill, "Extension"),
    PROFILE(R.drawable.ic_profile, R.drawable.ic_profile_fill, "Profile");
}

@Composable
fun BottomNavigationBar(onClick: (BottomNavigationItem) -> Unit = {}, itemSelected: BottomNavigationItem = BottomNavigationItem.HOME) {
    BottomAppBar(
        actions = {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(horizontal = 20.dp)
                        .background(color = Color.White)
                        .align(Alignment.Center)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .border(
                                width = 4.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .background(color = if (itemSelected == BottomNavigationItem.HOME) Green else BackGroundCommon, shape = RoundedCornerShape(50.dp))
                            .padding(start = 25.dp, end = 30.dp, top = 17.dp, bottom = 17.dp)
                            .clickable {
                                onClick.invoke(BottomNavigationItem.HOME)
                            },
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = BottomNavigationItem.HOME.iconSelected),
                            contentDescription = "",
                            tint = if (itemSelected == BottomNavigationItem.HOME) Color.White else Color.Gray,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = BottomNavigationItem.HOME.label,
                            color = if (itemSelected == BottomNavigationItem.HOME) Color.White else Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                    IconBottomNavigation(
                        resourceId = BottomNavigationItem.FAVOURITE.icon,
                        selected = itemSelected == BottomNavigationItem.FAVOURITE,
                        onClick = { onClick.invoke(BottomNavigationItem.FAVOURITE) })
                    IconBottomNavigation(
                        resourceId = R.drawable.ic_store,
                        selected = itemSelected == BottomNavigationItem.STORE,
                        onClick = { onClick.invoke(BottomNavigationItem.STORE) })
                    IconBottomNavigation(
                        resourceId = R.drawable.ic_extension,
                        selected = itemSelected == BottomNavigationItem.EXTENSION,
                        onClick = { onClick.invoke(BottomNavigationItem.EXTENSION) })
                    IconBottomNavigation(
                        resourceId = R.drawable.ic_profile,
                        selected = itemSelected == BottomNavigationItem.PROFILE,
                        onClick = { onClick.invoke(BottomNavigationItem.PROFILE) })
                }
            }
        },
        containerColor = Color.Transparent,
    )
}

@Composable
fun IconBottomNavigation(resourceId: Int, selected: Boolean = false, onClick: () -> Unit) {
    IconButton(
        onClick = { onClick.invoke() }, modifier = Modifier
            .border(width = 4.dp, color = Color.White, shape = CircleShape)
            .background(color = if (selected) Green else BackGroundCommon, shape = CircleShape)
            .padding(5.dp)
    ) {
        Icon(
            painter = painterResource(id = resourceId),
            contentDescription = "",
            tint = if (selected) Color.White else Color.Gray
        )
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}