package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

import com.dicoding.beescape.R
import com.dicoding.beescape.screen.Screen
import com.dicoding.beescape.ui.theme.poppinsFamily
import com.dicoding.beescape.view_model.MainViewModel
import com.dicoding.beescape.view_model.ViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController:NavHostController) {

    val viewModel:MainViewModel= viewModel(factory = ViewModelFactory.getInstance(context = LocalContext.current))

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = (stringResource(R.string.profile_title)),
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(top = 12.dp)
                    )
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 72.dp, start = 10.dp, end = 10.dp)
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

                Box(
                    modifier = Modifier
                        .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.moreInfo),
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium,

                            modifier = Modifier
                                .padding(top = 0.dp)
                                .clickable { })

                        Spacer(modifier = Modifier.height(14.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.baseline_lock_24),
                                contentDescription = ""
                            )
                            Text(
                                text = stringResource(R.string.terms),
                                fontSize = 16.sp,
                                lineHeight = 10.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 10.dp)
                                    .clickable { navController.navigate(Screen.TermsCondition.route) }
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.baseline_article_24),
                                contentDescription = ""
                            )
                            Text(
                                text = stringResource(R.string.guide),
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 10.dp)
                                    .clickable { }
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.baseline_contact_support_24),
                                contentDescription = ""
                            )
                            Text(
                                text = stringResource(R.string.cs),
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 10.dp)
                                    .clickable { }
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))
                        //accountsetting
                        Text(
                            text = stringResource(R.string.accountSettings),
                            fontSize = 12.sp,
                            lineHeight = 10.sp,
                            color = Color.Gray,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .clickable { })
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.baseline_help_24),
                                contentDescription = null
                            )
                            Text(
                                text = ("Help"),
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 10.dp)
                                    .clickable { }
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.baseline_notifications_24),
                                contentDescription = null
                            )
                            Text(
                                text = ("Notifications"),
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 10.dp)
                                    .clickable { }
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.baseline_lock_24),
                                contentDescription = ""
                            )
                            Text(
                                text = ("Privacy Policy"),
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 10.dp)
                                    .clickable { }
                            )
                        }
                    }
                }

                // Alert logout
                var showDialog by remember { mutableStateOf(false) }

                fun showAlertDialog() {
                    showDialog = true
                }

                fun dismissAlertDialog() {
                    showDialog = false
                }

                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            dismissAlertDialog()
                        },
                        title = {
                            Text(
                                text = stringResource(R.string.logout_text),
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                            )
                        },
                        text = {
                            Text(
                                text = stringResource(R.string.logout_Desc),
                                textAlign = TextAlign.Center,
                                fontFamily = poppinsFamily,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        confirmButton = {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Button(
                                    onClick = {
                                        // Handle logout logic
                                        viewModel.logout()
                                        navController.navigate(Screen.LOGOUT_ROUTE)
                                        dismissAlertDialog()
                                    }
                                ) {
                                    Text("Keluar")
                                }

                                Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antar tombol

                                Button(
                                    onClick = {
                                        dismissAlertDialog()
                                    }
                                ) {
                                    Text("Batal")
                                }
                            }
                        },
                        dismissButton = {}
                    )
                }
                // Alert logout

                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 24.dp)
                        .clickable {
                            showAlertDialog()
                        }
                ) {
                    Image(
                        painter = painterResource(R.drawable.baseline_logout_24),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(R.string.logOut),
                        fontSize = 16.sp,
                        color = Color.Red,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(top = 0.dp, start = 10.dp)
                            .clickable {
                                showAlertDialog()
                            }
                    )
                }
            }
        })
}
