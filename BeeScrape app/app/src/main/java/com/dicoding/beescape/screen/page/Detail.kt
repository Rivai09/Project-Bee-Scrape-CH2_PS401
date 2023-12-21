package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
               .padding(start = 16.dp, end = 16.dp, top = 16.dp)
               .verticalScroll(rememberScrollState()),
       ) {
           Box(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(paddingValues)
           ) {
               Column {
                   Text(
                       text = stringResource(R.string.salesDetail)+"",
                       fontSize = 17.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.SemiBold,
                   )
                   Text(
                       text = stringResource(R.string.sourceDetail),
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
                   Text(
                       text = stringResource(R.string.locationDetail),
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
                   Text(
                       text = stringResource(R.string.totalSearch),
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
                   Text(
                       text = stringResource(R.string.merk),
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )

                   Spacer(modifier = Modifier.padding(top = 24.dp))
                   AsyncImage(
                       model = "https://images.unsplash.com/photo-1523381294911-8d3cead13475?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                       contentDescription = "photo detail",
                       contentScale = ContentScale.Crop,
                       modifier = Modifier
                           .fillMaxSize()
                           .clip(RoundedCornerShape(16.dp))
                   )
                   Spacer(modifier = Modifier.padding(top = 24.dp))
                   Text(
                       text = stringResource(R.string.ketTotalProduct),
                       fontFamily = poppinsFamily,
                       fontSize = 14.sp
                   )
                   Text(
                       text = stringResource(R.string.topProduct),
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )

                   Spacer(modifier = Modifier.padding(top = 24.dp))
                   AsyncImage(
                       model = "https://images.unsplash.com/photo-1523381294911-8d3cead13475?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                       contentDescription = "photo detail",
                       contentScale = ContentScale.Crop,
                       modifier = Modifier
                           .fillMaxSize()
                           .clip(RoundedCornerShape(16.dp))
                   )
                   Spacer(modifier = Modifier.padding(top = 24.dp))
                   Text(
                       text = stringResource(R.string.rangeHarga),
                       fontFamily = poppinsFamily,
                       fontSize = 14.sp
                   )
                   Text(
                       text = stringResource(R.string.rangeJumlahTerjual),
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )

                   Spacer(modifier = Modifier.padding(top = 24.dp))
                   Text(
                       text = stringResource(R.string.tryAi),
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
                   MyTextInput()
               }
           }
       }
   }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyTextInput() {
    var text by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it.filter { char -> char.isDigit() }
//                result = text.toIntOrNull()?.times(2) ?: 0
            },
            label = { Text(stringResource(R.string.predictSalesHint)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Predict")
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(stringResource(R.string.enterNumber)+"$text")
//        Text(stringResource(R.string.predictSales)+"$result")
    }
}
