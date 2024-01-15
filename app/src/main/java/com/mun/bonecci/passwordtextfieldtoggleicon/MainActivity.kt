package com.mun.bonecci.passwordtextfieldtoggleicon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mun.bonecci.passwordtextfieldtoggleicon.components.PasswordTextField
import com.mun.bonecci.passwordtextfieldtoggleicon.components.isValidPassword
import com.mun.bonecci.passwordtextfieldtoggleicon.ui.theme.PasswordTextFieldToggleIconTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordTextFieldToggleIconTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PasswordTextFieldWithToggleIcon()
                }
            }
        }
    }
}

@Composable
fun PasswordTextFieldWithToggleIcon() {
    var password by remember { mutableStateOf(TextFieldValue()) }
    var isPasswordValid by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        // Column to arrange UI components vertically
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Text field for entering user password
            PasswordTextField(
                password = password,
                onPasswordChange = {
                    password = it
                    isPasswordValid = it.isValidPassword()
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    PasswordTextFieldToggleIconTheme {
        PasswordTextFieldWithToggleIcon()
    }
}