package com.dicoding.beescape.screen.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.beescape.R
import com.dicoding.beescape.ui.theme.poppinsFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsScreen() {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = (stringResource(R.string.terms)),
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
    ){
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 72.dp, bottom = 24.dp))
        {
            Text(
                text = (stringResource(R.string.termJudul)),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                lineHeight = 28.sp
            )
            Text(
                text = stringResource(R.string.termsParagraft1),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify,
                fontSize = 14.sp,

                )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.termsParagraf2),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = ("Additional User Conduct \nGuidlines"),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                lineHeight = 28.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(R.string.termsPart2text),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify,
                fontSize = 14.sp
            )
        }
    }
}