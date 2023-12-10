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
import androidx.compose.material3.ExperimentalMaterial3Api
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsScreen() {

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()
        .padding(10.dp)) {
        Text(text = stringResource(R.string.terms), fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center)

        Text(text = stringResource(R.string.termJudul), fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = stringResource(R.string.termsParagraft1), textAlign = TextAlign.Justify, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = stringResource(R.string.termsParagraf2),textAlign=TextAlign.Justify, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = stringResource(R.string.termsPart2), fontWeight = FontWeight.Bold, fontSize = 18.sp, textAlign = TextAlign.Center)
        Text(text = stringResource(R.string.termsPart2text), fontSize = 14.sp, textAlign = TextAlign.Justify)
    }
}