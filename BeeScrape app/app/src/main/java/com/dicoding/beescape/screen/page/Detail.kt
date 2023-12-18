package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.dicoding.beescape.R
import com.dicoding.beescape.ui.theme.poppinsFamily
import com.dicoding.beescape.view_model.MainViewModel
import com.dicoding.beescape.view_model.ViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Detail (id:String?) {

    if (id != null) {
        if (id.isNotEmpty()){
            Log.d("id detailL",id.toString())
        }
    }

    val viewModel: MainViewModel =
        viewModel(factory = ViewModelFactory.getInstance(LocalContext.current))
    val userState by viewModel.getSession().observeAsState(initial = null)
    LaunchedEffect(true ){
        viewModel.detailData(userState?.token.toString(), id.toString())
    }
    val data = viewModel.getDataDetail.value

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
                       text = stringResource(R.string.salesDetail)+" ${data?.category}",
                       fontSize = 17.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.SemiBold,
                   )
                   Text(
                       text = stringResource(R.string.sourceDetail)+" ${data?.category}",
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
                   Text(
                       text = stringResource(R.string.locationDetail)+" ${data?.location}",
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
                   Text(
                       text = stringResource(R.string.totalSearch)+" ${data?.jumlahData}",
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
                   Text(
                       text = stringResource(R.string.merk)+" ${data?.jumlahMerk}",
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
                       text = stringResource(R.string.ketTotalProduct)+" ${data?.ketTotalProduct}",
                       fontFamily = poppinsFamily,
                       fontSize = 14.sp
                   )
                   Text(
                       text = stringResource(R.string.topProduct)+" ${data?.topProduct}",
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
                       text = stringResource(R.string.rangeHarga)+" ${data?.rangeHarga}",
                       fontFamily = poppinsFamily,
                       fontSize = 14.sp
                   )
                   Text(
                       text = stringResource(R.string.rangeJumlahTerjual)+" ${data?.rangeJumlahTerjual}",
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )

                   Spacer(modifier = Modifier.padding(top = 24.dp))
                   Text(
                       text = stringResource(R.string.hargaPenjualanTerbanyak)+" ${data?.rangeJumlahTerjual}",
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
                   Text(
                       text = stringResource(R.string.hargaTermahal)+" ${data?.rangeJumlahTerjual}",
                       fontSize = 14.sp,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Normal,
                   )
               }
           }
       }
   }
}