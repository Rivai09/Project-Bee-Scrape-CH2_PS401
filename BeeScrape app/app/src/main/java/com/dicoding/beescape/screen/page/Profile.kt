package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

import com.dicoding.beescape.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen() {
    Scaffold(topBar = { stringResource(R.string.title_profile) }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, start = 10.dp, end = 10.dp)
        ) {
            AsyncImage(
                model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRZlenrvKQMmh4Z4b935QSM-7n-4MzN4mDXQ&usqp=CAU",
                contentDescription = "photoProfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(R.string.username),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Box(modifier = Modifier.padding(top = 20.dp)) {
                Column() {
                    Text(
                        text = stringResource(R.string.moreInfo),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .clickable { })
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.baseline_lock_24),
                            contentDescription = ""
                        )
                        Text(
                            text = stringResource(R.string.terms),
                            textDecoration = TextDecoration.Underline,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 10.dp)
                                .clickable { }
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.baseline_lock_24),
                            contentDescription = ""
                        )
                        Text(
                            text = stringResource(R.string.guide),
                            textDecoration = TextDecoration.Underline,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 10.dp)
                                .clickable { }
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.baseline_lock_24),
                            contentDescription = ""
                        )
                        Text(
                            text = stringResource(R.string.cs),
                            textDecoration = TextDecoration.Underline,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 10.dp)
                                .clickable { }
                        )
                    }
                }
//                Spacer(modifier = Modifier.height(16.dp))
//
//                Box(modifier = Modifier.padding(top = 20.dp)) {
//                    Column {
//                        Text(
//                            text = stringResource(R.string.accountSettings),
//                            fontSize = 10.sp,
//                            fontWeight = FontWeight.Light,
//                            modifier = Modifier
//                                .padding(top = 10.dp)
//                                .clickable { })
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Image(
//                                painter = painterResource(R.drawable.baseline_lock_24),
//                                contentDescription = ""
//                            )
//                            Text(
//                                text = stringResource(R.string.username),
//                                textDecoration = TextDecoration.Underline,
//                                fontSize = 15.sp,
//                                fontWeight = FontWeight.Medium,
//                                modifier = Modifier
//                                    .padding(top = 10.dp, start = 10.dp)
//                                    .clickable { }
//                            )
//                        }
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Image(
//                                painter = painterResource(R.drawable.baseline_lock_24),
//                                contentDescription = ""
//                            )
//                            Text(
//                                text = stringResource(R.string.email),
//                                textDecoration = TextDecoration.Underline,
//                                fontSize = 15.sp,
//                                fontWeight = FontWeight.Medium,
//                                modifier = Modifier
//                                    .padding(top = 10.dp, start = 10.dp)
//                                    .clickable { }
//                            )
//                        }
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Image(
//                                painter = painterResource(R.drawable.baseline_lock_24),
//                                contentDescription = ""
//                            )
//                            Text(
//                                text = stringResource(R.string.pw),
//                                textDecoration = TextDecoration.Underline,
//                                fontSize = 15.sp,
//                                fontWeight = FontWeight.Medium,
//                                modifier = Modifier
//                                    .padding(top = 10.dp, start = 10.dp)
//                                    .clickable { }
//                            )
//                        }
//                    }
//
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Row(verticalAlignment = Alignment.CenterVertically) {
//                        Image(
//                            painter = painterResource(R.drawable.baseline_logout_24),
//                            contentDescription = ""
//                        )
//                        Text(
//                            text = stringResource(R.string.logOut),
//                            textDecoration = TextDecoration.Underline,
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Medium,
//                            modifier = Modifier
//                                .padding(top = 10.dp, start = 10.dp)
//                                .clickable { }
//                        )
//                    }
//                }

            }
        }
    })
}
