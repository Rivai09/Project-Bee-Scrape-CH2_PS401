package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dicoding.beescape.R
import com.dicoding.beescape.api.response.ItemsDetailItem
import com.dicoding.beescape.ui.theme.poppinsFamily
import com.dicoding.beescape.view_model.MainViewModel
import com.dicoding.beescape.view_model.ViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Detail(id: String?) {

    if (id != null) {
        if (id.isNotEmpty()) {
            Log.d("id detailL", id.toString())
        }
    }

    val viewModel: MainViewModel =
        viewModel(factory = ViewModelFactory.getInstance(LocalContext.current))
    val userState by viewModel.getSession().observeAsState(initial = null)
    LaunchedEffect(true) {
//        viewModel.detailData(userState?.token.toString(), id.toString())
        viewModel.detailData(userState?.token.toString(), "657c20d9d44899b419a77a3f")
    }
    val dataResponse by viewModel.getDataDetail.collectAsState()

    val data = dataResponse?.items?.flatMap { it?.itemsDetail.orEmpty() }
    if (data != null && data.isNotEmpty()) {
        val detailItem = data.firstOrNull() ?: ItemsDetailItem()
        contentDetail(
            id = detailItem?.id,
            location = detailItem?.location.toString(),
            jumlahData = detailItem?.jumlahData.toString(),
            jumlahMerk = detailItem?.jumlahMerk.toString(),
            ketTotalProduk = detailItem?.ketTotalProduct.toString(),
            topProduct = detailItem?.topProduct.toString(),
            rangeHarga = detailItem?.rangeHarga.toString(),
            rangeJumlahTerjual = detailItem?.rangeJumlahTerjual.toString(),
            imgPersebaranData = detailItem?.persebaranData.toString(),
            imgPenjualan = detailItem?.productTerjual.toString()
        )
    }else{
        Text(text = "null")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun contentDetail(
    id: String?,
    location: String,
    jumlahData: String,
    jumlahMerk: String,
    ketTotalProduk: String,
    topProduct: String,
    rangeHarga: String,
    rangeJumlahTerjual:String,
    imgPersebaranData:String,
    imgPenjualan:String

) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.salesDetail),
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
                        text = stringResource(R.string.locationDetail) + " $location",
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = stringResource(R.string.totalSearch) + " $jumlahData",
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = stringResource(R.string.merk) + " $jumlahMerk",
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )

                    Spacer(modifier = Modifier.padding(top = 24.dp))
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current.applicationContext)
                            .data(imgPersebaranData)
                            .crossfade(true)
                            .build(),
                        contentDescription = "photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()

                    )
                    Spacer(modifier = Modifier.padding(top = 24.dp))
                    Text(
                        text = stringResource(R.string.ketTotalProduct) + " $ketTotalProduk",
                        fontFamily = poppinsFamily,
                        fontSize = 14.sp
                    )
                    Text(
                        text = stringResource(R.string.topProduct) + " $topProduct",
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )

                    Spacer(modifier = Modifier.padding(top = 24.dp))
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current.applicationContext)
                            .data(imgPenjualan)
                            .crossfade(true)
                            .build(),
                        contentDescription = "photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()

                    )
                    Spacer(modifier = Modifier.padding(top = 24.dp))
                    Text(
                        text = stringResource(R.string.rangeHarga) + " $rangeHarga}",
                        fontFamily = poppinsFamily,
                        fontSize = 14.sp
                    )
                    Text(
                        text = stringResource(R.string.rangeJumlahTerjual) + " $rangeJumlahTerjual",
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )

                    Spacer(modifier = Modifier.padding(top = 24.dp))
                    Text(
                        text = stringResource(R.string.hargaPenjualanTerbanyak) + " $rangeJumlahTerjual",
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = stringResource(R.string.hargaTermahal) + " $rangeJumlahTerjual",
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
        }
}