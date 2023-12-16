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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
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
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
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
                            text = userState!!.email,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 72.dp, start = 18.dp, end = 18.dp)
            ) {
                Search()
                ItemRow(
                    modifier = Modifier,
                    navController = navController, viewModel = mainViewModel
                )
            }
        }
    )
}

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
            containerColor = lgray
        ),
        modifier = modifier
            .padding(top = 4.dp, start = 0.dp, end = 0.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
    ) {
    }
}


@Composable
fun ItemRow(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: MainViewModel

) {
    Column(modifier.padding(top = 12.dp, start = 0.dp, end = 0.dp)) {

        val userState by viewModel.getSession().observeAsState(initial = null)
        val listState = rememberLazyListState()

        Box(modifier.padding(top = 10.dp, start = 0.dp, end = 0.dp)) {
            Text(
                text = stringResource(R.string.popular),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )

            val getToken = viewModel.getDataPaging(userState?.token ?: "")
            val data = getToken.collectAsLazyPagingItems()

            Log.d("cek isi","${data.itemCount}")

            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(horizontal = 0.dp),
                modifier = modifier.padding(top = 40.dp)
            ) {
                if(data!=null){
                    items(data) {
                        Log.d("data", "Item: $it")
                        dataItem(img = it?.persebaranData ?: "", teks = it?.topProduct.toString()) {
                            navController.navigate(
                                Screen.SelectMarketplace.route
                            )
                        }
                    }
                }
                else{
                    Log.d("data:","data kosong bro")
                }

            }
        }
    }
}

@Composable
fun dataItem(
    img: String, teks: String, sendSelectmarket: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .shadow(3.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(img)
                    .crossfade(true)
                    .build(),
                contentDescription = "photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(bottom = 0.dp, top = 0.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable {
                        sendSelectmarket()
                    }
            )
            Text(
                text = teks,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = poppinsFamily,
                modifier = Modifier
                    .padding(vertical = 20.dp, horizontal = 15.dp)
            )
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
}