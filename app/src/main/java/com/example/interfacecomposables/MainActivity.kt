package com.example.interfacecomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interfacecomposables.ui.theme.InterfaceComposablesTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfaceComposablesTheme {
                App()
            }
        }
    }
}

//Função App (Inserindo componentes na interface)
@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Adicionando composables
            SimpleCenterAlignedTopAppBar() //barra superior
            Entradas()
        }
    }
}

//Criando preview da função App
@Preview
@Composable //função composta que cria uma parte da interface usando a biblioteca Compose
fun AppPreview(){
    App()
}

//Criando barra superior da interface
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleCenterAlignedTopAppBar() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Thainá",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "description"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    Entradas()
                    OutlinedButtonSample()
                }
            }
        }
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Entradas() {

    val nome = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val cidade = remember { mutableStateOf("") }
    val estado = remember { mutableStateOf("") }
    val cep = remember { mutableStateOf("") }
    val endereco = remember { mutableStateOf("") }
    val cpf = remember { mutableStateOf("") }
    val bairro = remember { mutableStateOf("") }
    val datanascimento = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(35.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Preencha os campos abaixo:",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 50.dp)
        )


        TextField(
            value = nome.value,
            onValueChange = { nome.value = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = cidade.value,
            onValueChange = { cidade.value = it },
            label = { Text("Cidade") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = estado.value,
            onValueChange = { estado.value = it },
            label = { Text("Estado") },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = cep.value,
            onValueChange = { cep.value = it },
            label = { Text("CEP") },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = endereco.value,
            onValueChange = { estado.value = it },
            label = { Text("Endereco") },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = cpf.value,
            onValueChange = { estado.value = it },
            label = { Text("CPF") },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = bairro.value,
            onValueChange = { estado.value = it },
            label = { Text("Bairro") },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = datanascimento.value,
            onValueChange = { estado.value = it },
            label = { Text("Data de nascimento") },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun OutlinedButtonSample() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .wrapContentHeight(Alignment.CenterVertically)
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        OutlinedButton(onClick = { /* Do something! */ }) {
            Text("Finalizar")
        }
    }
}