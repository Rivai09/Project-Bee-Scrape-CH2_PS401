package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dicoding.beescape.R
import com.dicoding.beescape.screen.Screen
import com.dicoding.beescape.ui.theme.lgray
import com.dicoding.beescape.ui.theme.poppinsFamily
import com.dicoding.beescape.view_model.MainViewModel
import com.dicoding.beescape.view_model.ViewModelFactory


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(true) }
    val mainViewModel: MainViewModel =
        viewModel(factory = ViewModelFactory.getInstance(LocalContext.current))
    val userState by mainViewModel.getSession().observeAsState(initial = null)

    Log.d("token","${userState?.token}")

    Scaffold(topBar = {
        TopAppBar(title = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(top = 40.dp, bottom = 27.dp)
            ) {
                Text(
                    text = stringResource(R.string.welcome),
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 14.sp,
                )
                Text(
                    text = userState!!.email, fontWeight = FontWeight.SemiBold, fontSize = 16.sp
                )
            }
        })
    }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp, start = 18.dp, end = 18.dp)
        ) {
            Search()
            ItemRow(
                modifier = Modifier, navController = navController, viewModel = mainViewModel
            ) { navController.navigate(Screen.SelectMarketplace.route) }
        }
    })
}


@Composable
fun ItemRow(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: MainViewModel,
    sendSelectmarket: (String) -> Unit
) {
    val listState = rememberLazyListState()

    val userState by viewModel.getSession().observeAsState(initial = null)
    LaunchedEffect(true) {
        viewModel.fetchData(userState?.token ?: "")
        Log.d("isi token launch", "${userState?.token}")
    }

    Box(modifier.padding(top = 10.dp, start = 0.dp, end = 0.dp)) {
        Text(
            text = stringResource(R.string.popular),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(horizontal = 0.dp),
            modifier = modifier.padding(top = 40.dp)
        ) {
            val data = viewModel.data.value?.product?.flatMap { it?.items.orEmpty() }

            items(data ?: emptyList()) { item ->
                dataItem(
                    id=item?.id.toString(),
                    img = item?.persebaranData ?: "",
                    teks = item?.category ?: "",
                    modifier.clickable {
                        Log.d("home kirim id",item?.id.toString())
                        sendSelectmarket(item?.id.toString())
                    },
                    navController
                )
                Text(text = item?.id.toString())
            }
        }
    }
}


@Composable
fun dataItem(id:String,
    img: String, teks: String, modifier: Modifier ,navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .shadow(3.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable {
                        navController.navigate(Screen.SelectMarketplace.createRoute1(id))
                        Log.d("home click", id)
                    }
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current.applicationContext)
                        .data(img)
                        .crossfade(true)
                        .build(),
                    contentDescription = "photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()

                )
            }

            Text(
                text = teks,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = poppinsFamily,
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(modifier: Modifier = Modifier) {
    SearchBar(query = "",
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
            containerColor = lgray
        ),
        modifier = modifier
            .padding(top = 4.dp, start = 0.dp, end = 0.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
    ) {}
}





//@Composable
//fun SearchScreen(viewModel: MainViewModel) {
//    var query by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        TextField(
//            value = query,
//            onValueChange = { query = it },
//            label = { Text("Enter search query") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        )
//
//        Button(
//            onClick = { viewModel.search(query) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        ) {
//            Text("Search")
//        }
//
//        when {
//            viewModel.isLoading.observeAsState().value == true -> {
//                // Display loading indicator
//                CircularProgressIndicator()
//            }
//            viewModel.error.observeAsState().value != null -> {
//                // Display the error message
//                Text("Error: ${viewModel.error.observeAsState().value}", color = Color.Red)
//            }
//            else -> {
//                // Display the search results
//                val searchResults = viewModel.searchResults.observeAsState().value
//                // Render the search results in your Compose UI
//            }
//        }
//    }
//}
//
//@Composable
//fun FullScreenAlertDialog(showDialog: Boolean, onDismiss: () -> Unit) {
//    if (showDialog) {
//        AlertDialog(onDismissRequest = {
//            onDismiss()
//        }, title = { Text("Attention") }, text = { Text("blabalblaba") }, confirmButton = {
//            Button(onClick = {
//                onDismiss()
//            }) {
//                Text(text = "Confirm")
//            }
//        })
//    }
//}
