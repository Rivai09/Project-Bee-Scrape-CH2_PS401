package com.dicoding.beescape.screen.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.dicoding.beescape.R
import com.dicoding.beescape.screen.Screen
import com.dicoding.component.suggestCategory

@Composable
fun AnalysisScreen(navController: NavHostController) {
    AnalysisContent({navController.navigate(Screen.SelectMarketplace.route)}, navController)
}

@Composable
fun AnalysisContent(sendSelectmarket: () -> Unit, navController: NavHostController) {
    val listState = rememberLazyListState()
    val suggestedProductListState = rememberLazyListState()

    Box(
        modifier = Modifier
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
    ) {
        Column {
            Text(
                text = stringResource(R.string.suggestedProduct),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            LazyRow(
                state = suggestedProductListState,
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.padding(top = 30.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(suggestCategory) {
                    Column(
                        modifier = Modifier.clickable {
                            sendSelectmarket()
                        }
                    ) {
                        AsyncImage(
                            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRZlenrvKQMmh4Z4b935QSM-7n-4MzN4mDXQ&usqp=CAU",
                            contentDescription = "photo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .height(150.dp)
                        )
                        Text(
                            text = stringResource(R.string.priceRec),
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}