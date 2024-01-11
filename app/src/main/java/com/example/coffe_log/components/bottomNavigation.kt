package com.example.coffe_log.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BarBottom(
    onAClicked: () -> Unit,
    onBClicked: () -> Unit,
    onCClicked: () -> Unit,
    onDClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .padding(bottom = 1.dp, start = 3.dp, end = 3.dp, top = 3.dp)
    ) {
        Row (
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Button(
                onClick = onAClicked,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(1.dp)
            ) {
                Icon(Icons.Filled.Create, contentDescription = "Aicon")
            }
            Button(
                onClick = onBClicked,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(1.dp)
            ) {
                Icon(Icons.Filled.List, contentDescription = "Bicon")
            }
            Button(
                onClick = onCClicked,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(1.dp)
            ) {
                Icon(Icons.Filled.Favorite, contentDescription = "Cicon")
            }
            Button(
                onClick = onDClicked,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(1.dp)
            ) {
                Icon(Icons.Filled.Settings, contentDescription = "Dicon")
            }
        }
    }
}


@Preview
@Composable
fun BarBottomPreview() {
    BarBottom(
        onAClicked = {},
        onBClicked = {},
        onCClicked = {},
        onDClicked = {}
    )
}