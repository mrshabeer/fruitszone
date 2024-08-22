package com.shabeer.fruitszone.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shabeer.fruitszone.data.models.NavigationItems

// bottom navigation list
private val bottomNavigationList = listOf<NavigationItems>(
    NavigationItems(
        itemName = "Home",
        selectedItemIcon = Icons.Filled.Home,
        unSelectedItemIcon = Icons.Outlined.Home
    ),
    NavigationItems(
        itemName = "Profile",
        selectedItemIcon = Icons.Filled.Person,
        unSelectedItemIcon = Icons.Outlined.Person
    ),
    NavigationItems(
        itemName = "Info",
        selectedItemIcon = Icons.Filled.Info,
        unSelectedItemIcon = Icons.Outlined.Info
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun BottomAppBarScreen() {

    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(bottomBar = {
        NavigationBar {
            bottomNavigationList.forEachIndexed { index, navigationItems ->
                val isSelected = if (selectedIndex == index) {
                    navigationItems.selectedItemIcon
                } else {
                    navigationItems.unSelectedItemIcon
                }
                NavigationBarItem(
                    selected = index == selectedIndex,
                    onClick = {
                        selectedIndex = index
                    },
                    icon = {
                        Icon(
                            imageVector = isSelected,
                            contentDescription = null
                        )
                    },
                    label = { Text(text = navigationItems.itemName) })
            }
        }
    }) {
        Box(modifier = Modifier.padding(it)) {

        }
    }
}