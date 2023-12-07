package com.dicoding.beescape.screen.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.dicoding.beescape.R
import com.dicoding.beescape.screen.Screen

@Composable
fun SelectMarketplace() {
    Box(
        modifier = Modifier
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = stringResource(R.string.marketTittle),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.marketSubtitle),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )

            Box {
                Row {
                    Button(colors = ButtonDefaults.buttonColors(Color.Green), onClick = {}) {
//                Column {
                        Text(text = stringResource(R.string.tokopedia))
//                    Spacer(modifier = Modifier.width(5.dp))
//                    Image(painter = painterResource(R.drawable.bs_logo), contentDescription ="tokped", modifier = Modifier.clip(
//                        CircleShape).size(50.dp))
//                }
                    }

                    Spacer(modifier = Modifier.width(5.dp))

                    Button(colors = ButtonDefaults.buttonColors(Color.Blue), onClick = {}) {
//                Column {
                        Text(text = stringResource(R.string.blibli))
//                    Spacer(modifier = Modifier.width(5.dp))
//                    Image(painter = painterResource(R.drawable.bs_logo), contentDescription ="tokped", modifier = Modifier.clip(
//                        CircleShape).size(50.dp))
//                }
                    }
                }
            }
        }
    }
}



