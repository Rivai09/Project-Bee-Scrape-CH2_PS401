package com.dicoding.beescape.screen.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dicoding.beescape.R
import com.dicoding.beescape.screen.Screen
import com.dicoding.beescape.ui.theme.poppinsFamily

@Composable
fun SelectMarketplace(sendToDetail: () -> Unit, navController: NavHostController) {
    Box(
        modifier = Modifier
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = stringResource(R.string.marketTittle),
                fontSize = 18.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
            )
            Text(
                text = stringResource(R.string.marketSubtitle),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
            )
            Spacer(modifier = Modifier.height(12.dp))
            Box {
                Row() {
                    Button(colors = ButtonDefaults.buttonColors(), onClick = {
                        sendToDetail
                        navController.navigate(Screen.Detail.route)
                    }) {
                        Text(text = stringResource(R.string.tokopedia))
                    }
                }
            }
        }
    }
}



