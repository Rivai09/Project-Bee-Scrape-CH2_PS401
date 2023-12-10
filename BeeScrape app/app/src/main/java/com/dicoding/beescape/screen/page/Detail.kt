package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dicoding.beescape.R
import com.dicoding.beescape.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Detail () {
   Scaffold (
       topBar = {
           TopAppBar(
               title = {
                   Text(
                       text = ("Detail Data"),
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Medium,
                       fontSize = 18.sp
                   )
               },
               navigationIcon = {
                   IconButton(onClick = {  /*navController.popBackStack()*/ }) {
                       Icon(
                           imageVector = Icons.Default.ArrowBack,
                           contentDescription = "Go Back"
                       )
                   }
               }
           )
       },
   ){ paddingValues ->
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(start = 16.dp, end = 16.dp)
               .verticalScroll(rememberScrollState()),
       ) {
           Box(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(paddingValues)
           ) {
               Column {
                   Spacer(modifier = Modifier.padding(top = 24.dp))
                   AsyncImage(
                       model = "https://images.unsplash.com/photo-1523381294911-8d3cead13475?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                       contentDescription = "photo detail",
                       contentScale = ContentScale.Crop,
                       modifier = Modifier
                           .fillMaxSize()
                           .clip(RoundedCornerShape(24.dp))
                   )
                   Spacer(modifier = Modifier.padding(top = 24.dp))
                   Text(
                       text = "Title",
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.SemiBold,
                       fontSize = 24.sp
                   )
                   Text(
                       text = "Description",
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
               }
           }
       }
   }
}