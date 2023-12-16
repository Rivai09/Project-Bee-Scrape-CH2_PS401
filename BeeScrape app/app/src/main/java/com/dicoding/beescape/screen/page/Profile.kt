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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.dicoding.beescape.R
import com.dicoding.beescape.screen.Screen
import com.dicoding.beescape.ui.theme.gray
import com.dicoding.beescape.ui.theme.poppinsFamily
import com.dicoding.beescape.view_model.MainViewModel
import com.dicoding.beescape.view_model.ViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController:NavHostController) {

    val viewModel:MainViewModel= viewModel(factory = ViewModelFactory.getInstance(context = LocalContext.current))
    val userState by viewModel.getSession().observeAsState(initial = null)

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
                Box(
                    modifier = Modifier
                        .padding(top = 16.dp)
                ) {

                    // username
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                        ){
                            // username
                            AsyncImage(
                                model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRZlenrvKQMmh4Z4b935QSM-7n-4MzN4mDXQ&usqp=CAU",
                                contentDescription = stringResource(R.string.desc_profile),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(54.dp)
                                    .clip(CircleShape)
                            )
                            Text(
                                text = userState?.email ?: "no name",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(start = 14.dp)
                                    .weight(1f)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                                contentDescription = ""
                            )
                        }
                        Divider(
                            color = gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                        )

                        // more info and support
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = stringResource(R.string.moreInfo),
                            fontSize = 12.sp,
                            lineHeight = 10.sp,
                            color = Color.Gray,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(
                                    top = 0.dp,
                                    start = 16.dp,
                                    end = 16.dp
                                )
                        )

                        // terms and condition
                        Spacer(modifier = Modifier.height(14.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navController.navigate(Screen.TermsCondition.route) }
                                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.size(42.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(gray, shape = CircleShape)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_lock_24),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                            }
                            Text(
                                text = stringResource(R.string.terms),
                                fontSize = 16.sp,
                                lineHeight = 10.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(start = 14.dp)
                                    .weight(1f)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                                contentDescription = ""
                            )
                        }
                        Divider(
                            color = gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                        )

                        // guide
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.size(42.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(gray, shape = CircleShape)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_article_24),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                            }
                            Text(
                                text = stringResource(R.string.guide),
                                fontSize = 16.sp,
                                lineHeight = 10.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(start = 14.dp)
                                    .weight(1f)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                                contentDescription = ""
                            )
                        }
                        Divider(
                            color = gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                        )

                        //contact support
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.size(42.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(gray, shape = CircleShape)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_contact_support_24),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                            }
                            Text(
                                text = stringResource(R.string.cs),
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 14.dp)
                                    .weight(1f)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                                contentDescription = ""
                            )
                        }
                        Divider(
                            color = gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                        )

                        //account setting
                        Text(
                            text = stringResource(R.string.accountSettings),
                            fontSize = 12.sp,
                            lineHeight = 10.sp,
                            color = Color.Gray,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(
                                    top = 24.dp,
                                    start = 16.dp,
                                    end = 16.dp
                                )
                        )

                        // help
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                        ){
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.size(42.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(gray, shape = CircleShape)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_contact_support_24),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                            }
                            Text(
                                text = (stringResource(R.string.help_text)),
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 14.dp)
                                    .weight(1f)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                                contentDescription = ""
                            )
                        }
                        Divider(
                            color = gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                        )

                        // notification
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.size(42.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(gray, shape = CircleShape)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_notifications_24),
                                    contentDescription = "",
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                            }
                            Text(
                                text = (stringResource(R.string.notif_text)),
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 14.dp)
                                    .weight(1f)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                                contentDescription = ""
                            )
                        }
                        Divider(
                            color = gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                        )

                        // privacy policy
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navController.navigate(Screen.PrivacyPolicy.route) }
                                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.size(42.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(gray, shape = CircleShape)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_lock_24),
                                    contentDescription = "",
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                            }
                            Text(
                                text = (stringResource(R.string.privacy_policy_text)),
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 0.dp, start = 14.dp)
                                    .weight(1f)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                                contentDescription = null
                            )
                        }
                        Divider(
                            color = gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                        )
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
                                    Text(stringResource(R.string.exit_text))
                                }

                                Spacer(modifier = Modifier.width(8.dp))

                                Button(
                                    onClick = {
                                        dismissAlertDialog()
                                    },
                                ) {
                                    Text(stringResource(R.string.cencel_text))
                                }
                            }
                        },
                        dismissButton = {}
                    )
                }
                // Alert logout

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            showAlertDialog()
                        }
                        .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(42.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(gray, shape = CircleShape)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.baseline_logout_24),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(Color.Gray)
                        )
                    }
                    Text(
                        text = stringResource(R.string.logOut),
                        fontSize = 16.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(top = 0.dp, start = 14.dp)
                            .weight(1f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                        contentDescription = null
                    )
                }
            }
        })
}
