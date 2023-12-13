package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.dicoding.beescape.R
import com.dicoding.beescape.data_user.DataUser
import com.dicoding.beescape.screen.Screen
import com.dicoding.beescape.ui.theme.poppinsFamily
import com.dicoding.beescape.view_model.MainViewModel
import com.dicoding.beescape.view_model.ViewModelFactory
import com.dicoding.component.suggestCategory
import androidx.lifecycle.viewmodel.compose.viewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(true) }
    val mainViewModel: MainViewModel =
        viewModel(factory = ViewModelFactory.getInstance(LocalContext.current))
    val userState by mainViewModel.getSession().observeAsState(initial = null)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = stringResource(R.string.welcome),
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                        )
                        Text(
                            text = userState!!.email,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    }
                }
            )
        },
        content = {
//            LaunchedEffect(showDialog) {
//                if (showDialog) {
//                    showDialog = false // Set to false to avoid showing the dialog repeatedly
//                    // Show the alert dialog
//                    FullScreenAlertDialog(function = { showDialog = true })
//                }
//            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp, start = 10.dp, end = 10.dp)
            ) {
                Search()
//                CategoryRow(navController = navController)
                ItemRow(
                    modifier = Modifier,
                    { navController.navigate(Screen.SelectMarketplace.route) },
                    navController = navController
                )


            }
        }
    )
}
//private fun getUser(){
//    val dataUser=DataUser()
//    dataUser.email
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(modifier: Modifier = Modifier) {
    SearchBar(
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        placeholder = {
            Text(stringResource(R.string.search))
        },
        shape = MaterialTheme.shapes.large,
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = modifier
            .padding(top = 30.dp, start = 0.dp, end = 0.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
    ) {
    }
}

@Composable
fun CategoryItem(
    category: String,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { navController.navigate(Screen.SelectMarketplace.route) }) {
            Text(text = stringResource(category.toInt()))
        }
    }
}

@Composable
fun ItemRow(modifier: Modifier, sendSelectmarket: () -> Unit, navController: NavHostController) {
    Column(modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)) {

        val listState = rememberLazyListState()

        Box(modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp)) {
            Text(
                text = stringResource(R.string.popular),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = modifier.padding(top = 30.dp)
            ) {
//            ganti parameter item dari data api
//            misal model=it.photo
                items(suggestCategory) {
                    AsyncImage(
                        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRZlenrvKQMmh4Z4b935QSM-7n-4MzN4mDXQ&usqp=CAU",
                        contentDescription = "photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .clickable {
                                sendSelectmarket()
                            }
                    )
                    Text(text = "Amount of data: 1000")
                }
            }
        }

    }
}

@Composable
fun FullScreenAlertDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            title = { Text("Attention") },
            text = { Text("blabalblaba") },
            confirmButton = {
                Button(onClick = {
                    onDismiss()
                }) {
                    Text(text = "Confirm")
                }
            }
        )
    }
}
