package com.food.riderapp.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.food.riderapp.ui.theme.RiderAppTheme

@Composable
fun SignupScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
        .wrapContentSize(align = Alignment.Center)
        .padding(top = 32.dp, start = 32.dp, end = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {

        Icon(imageVector = Icons.Outlined.Person,
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .size(120.dp)
        )

        InputField(modifier = modifier.fillMaxWidth(), label = "Name")
        InputField(modifier = modifier.fillMaxWidth(), label = "Email")
        InputField(modifier = modifier.fillMaxWidth(), label = "Password")
        InputField(modifier = modifier.fillMaxWidth(), label = "Confirm password")
        InputField(modifier = modifier.fillMaxWidth(), label = "Phone number")
        InputField(modifier = modifier.fillMaxWidth(), label = "Current address", iconEnabled = true)

        Button(onClick = {},
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally),
            shape = RoundedCornerShape(100)) {
            Text(text = "SIGN UP",
                style = MaterialTheme.typography.body1
                )
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)) {
            Text(text = "Already have an account?",
                style = MaterialTheme.typography.body1)
            Text(text = "Login", style = MaterialTheme.typography.body1)
        }
    }
}

@Composable
private fun InputField(modifier: Modifier = Modifier,
                       value: String = "",
                       onValueChange: (String) -> Unit = {},
                       label: String = "",
                       iconEnabled: Boolean = false
                       ) {
    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = modifier,
        textStyle = MaterialTheme.typography.body1,
        trailingIcon = {
            if (iconEnabled) {
                Icon(imageVector = Icons.Outlined.LocationOn,
                    contentDescription = null,
                    tint = Color.Red)
            }
        })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignupScreenLightThemeScreen() {
    RiderAppTheme(darkTheme = false) {
        SignupScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun SignupScreenDarkThemePreview() {
    RiderAppTheme(darkTheme = true) {
        SignupScreen()
    }
}