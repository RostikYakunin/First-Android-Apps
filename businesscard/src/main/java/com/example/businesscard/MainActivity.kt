package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.MyFirstAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAndroidAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Card(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(8.dp)
            .background(Color(0xFFD2E8D4))
            .fillMaxSize()
    ) {
        Logo(modifier = Modifier.weight(1F))

        Contacts(modifier = Modifier.weight(1F))
    }
}

@Composable
private fun Contacts(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        ContactTemplate(
            painter = painterResource(R.drawable.baseline_local_phone_24),
            text = "+ 38 066 500 89 12"
        )

        ContactTemplate(
            painter = painterResource(R.drawable.share),
            text = "@yak/dev"
        )

        ContactTemplate(
            painter = painterResource(R.drawable.baseline_email_24),
            text = "yakunin.dev.officila@gmail.com"
        )
    }
}

@Composable
private fun ContactTemplate(painter: Painter, text: String) {
    Row {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = Color(0xFF006D3B),
            modifier = Modifier
                .padding(end = 10.dp)
                .size(25.dp)
        )

        Text(
            text = text
        )
    }
}

@Composable
private fun Logo(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.download),
            contentDescription = null,
            modifier = Modifier
                .padding(3.dp)
                .size(150.dp, 150.dp)
        )

        Text(
            text = "Yakunin Rostyslav",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    top = 5.dp,
                    bottom = 10.dp
                )
        )

        Text(
            text = "Director of Paws company LTD",
            fontSize = 20.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstAndroidAppTheme {
        Card()
    }
}