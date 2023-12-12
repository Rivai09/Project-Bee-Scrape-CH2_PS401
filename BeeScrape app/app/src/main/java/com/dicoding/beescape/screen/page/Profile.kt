package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

import com.dicoding.beescape.R
import com.dicoding.beescape.screen.Screen
import com.dicoding.beescape.view_model.MainViewModel
import com.dicoding.beescape.view_model.ViewModelFactory

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController) {

    val context = LocalContext.current
    val viewModel: MainViewModel = viewModel(factory = ViewModelFactory.getInstance(context))

    Scaffold(topBar = { stringResource(R.string.title_profile) }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, start = 10.dp, end = 10.dp)
                .verticalScroll(rememberScrollState())
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
                        lineHeight = 10.sp,
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
                            lineHeight = 10.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 10.dp)
                                .clickable { navController.navigate(Screen.TermsCondition.route) }
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
                            lineHeight = 10.sp,
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
                            lineHeight = 10.sp,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 10.dp)
                                .clickable { }
                        )
                    }

                    //accountsetting
                    Text(
                        text = stringResource(R.string.accountSettings),
                        fontSize = 10.sp,
                        lineHeight = 10.sp,
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
                            text = stringResource(R.string.username),
                            textDecoration = TextDecoration.Underline,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 10.sp,
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
                            text = stringResource(R.string.email),
                            textDecoration = TextDecoration.Underline,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 10.sp,
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
                            text = stringResource(R.string.pw),
                            textDecoration = TextDecoration.Underline,
                            lineHeight = 10.sp,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 10.dp)
                                .clickable { }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.baseline_logout_24),
                    contentDescription = ""
                )
                Text(
                    text = stringResource(R.string.logOut),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 15.sp,
                    lineHeight = 10.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp)
                        .clickable {
                            viewModel.logout()
                            navController.navigate(Screen.LOGOUT_ROUTE)
                        }
                )
            }
        }
    })
}