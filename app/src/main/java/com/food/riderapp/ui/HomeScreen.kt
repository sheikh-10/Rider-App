package com.food.riderapp.ui

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.food.riderapp.ui.theme.RiderAppTheme
import com.food.riderapp.R
import com.food.riderapp.data.Datasource
import com.food.riderapp.model.MenuOption

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

        Row(modifier = modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {

            Text(text = "Welcome KABIB",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                modifier = modifier
                    .weight(1f)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                )

            Image(painter = painterResource(id = R.drawable.bella),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50)))
        }

        Spacer(modifier = modifier.height(32.dp))
        MenuOptionCardList()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MenuOptionCardList(modifier: Modifier = Modifier,
                               menuOption: List<MenuOption> = Datasource.loadOptions()) {
    LazyVerticalGrid(cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(menuOption.size) { index ->
            MenuOptionCard(menuOption = menuOption[index])
        }
    }
}

@Composable
private fun MenuOptionCard(modifier: Modifier = Modifier,
                           menuOption: MenuOption = Datasource.loadOptions()[0]) {
    Card(elevation = 4.dp, shape = RoundedCornerShape(20)) {
        Column(modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp, horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {

            Icon(painter = painterResource(id = menuOption.optionImage),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .size(50.dp)
                    .clip(RoundedCornerShape(50)),
                tint = MaterialTheme.colors.onSurface
                )

            Text(text = menuOption.optionName,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)

            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenLightThemeScreen() {
    RiderAppTheme(darkTheme = false) {
        HomeScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenDarkThemePreview() {
    RiderAppTheme(darkTheme = true) {
        HomeScreen()
    }
}