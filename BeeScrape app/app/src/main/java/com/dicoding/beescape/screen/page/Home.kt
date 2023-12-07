package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.dicoding.beescape.R
import com.dicoding.beescape.screen.Screen
import com.dicoding.component.suggestCategory

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(text = stringResource(R.string.welcome ), fontWeight = FontWeight.Light, fontSize = 12.sp)
                        Text(text = stringResource(R.string.username ), fontWeight = FontWeight.Medium, fontSize = 16.sp)
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp, start = 10.dp, end = 10.dp)
            ) {
                Search()
                CategoryRow(navController = navController)
                ItemRow(modifier = Modifier)
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

        Button(onClick = {navController.navigate(Screen.SelectMarketplace.route)}) {
            Text(text = stringResource(category.toInt()))
        }
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp)) {
        Text(
            text = stringResource(R.string.category),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(suggestCategory) { category ->
                CategoryItem(category.toString(), navController = navController)
            }
        }
    }
}

@Composable
fun ItemRow( modifier: Modifier) {
    Column(modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp)) {
        Text(
            text = stringResource(R.string.popular),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
//            ganti parameter item dari data api
//            misal model=it.photo
           items(suggestCategory){
               AsyncImage(
                   model = "", contentDescription = "photo", contentScale = ContentScale.Crop,
                   modifier = Modifier
                       .padding(8.dp)
                       .size(60.dp)
               )
               Text(text = "")
           }
        }
    }
}
