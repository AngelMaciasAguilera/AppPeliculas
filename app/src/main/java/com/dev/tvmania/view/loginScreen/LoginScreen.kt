package com.dev.tvmania.view.loginScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dev.tvmania.R
import com.dev.tvmania.view.util.Screen
import com.dev.tvmania.viewModel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondoapp),
                contentScale = ContentScale.Crop,
                contentDescription = "Fondo app",
                modifier = Modifier.fillMaxSize()
            )

            Login(
                Modifier
                    .align(Alignment.Center)
                    .width(350.dp)
                    .height(350.dp)
                    .background(Color.Black), viewModel, navController
            )
        }
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, navController: NavHostController) {

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField(email) { viewModel.onLoginChanged(it, password) }
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(password) { viewModel.onLoginChanged(email, it) }
        Spacer(modifier = Modifier.padding(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton(loginEnable, navController)
    }

}

@Composable
fun LoginButton(loginEnable: Boolean, navController: NavHostController) {
    Button(
        onClick = { navController.navigate(Screen.HomeScreen.route) },
        modifier = Modifier
            .width(240.dp)
            .height(48.dp).padding(bottom = 5.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Blue,
            disabledBackgroundColor = Color.Gray,
            contentColor = Color.White,
            disabledContentColor = Color.White
        ), enabled = loginEnable
    ) {
        Text(text = "Iniciar sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Olvidaste la contraseña?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = {
            onTextFieldChanged(it)
        },
        placeholder = { Text(text = "Contraseña", color = Color(0xFF636262)) },
        modifier = Modifier.width(300.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick = { passwordVisible = !passwordVisible },
                modifier = Modifier.padding(4.dp),

            ) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = if (passwordVisible) "Hide Password" else "Show Password",
                    tint = Color(0xFF0E2BCC)
                )
            }
        }
    )
}

@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = email, onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.width(300.dp),
        placeholder = { Text(text = "Email", color = Color(0xFF636262)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color(0xFFDEDDDD),
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black
        )
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.tv_mania),
        contentDescription = "Header",
        modifier = modifier
    )
}