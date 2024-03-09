package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InformColumn()
                }
            }
        }
    }
}

@Composable
fun InformColumn(modifier: Modifier = Modifier) {
    var state by remember {
        mutableIntStateOf(1)
    }

    val pair = chooseStateAndImageResourse(state)
    state = pair.first

    val imageResource = pair.second
    val imageDesc = chooseImageDesc(state)
    val text = chooseText(state)

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Lemonade",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(10.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(imageResource),
            contentDescription = stringResource(imageDesc),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .size(250.dp, 250.dp)
                .background(Color.Green)
                .clickable {
                    state++
                }
        )

        Text(
            text = stringResource(text),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun chooseStateAndImageResourse(state: Int): Pair<Int, Int> {
    var newState = state
    val resource = when (newState) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> {
            newState = 1
            R.drawable.lemon_tree
        }
    }
    return Pair(newState, resource)
}

@Composable
private fun chooseText(state: Int) = when (state) {
    1 -> R.string.first_action_tree
    2 -> R.string.second_action_squeeze
    3 -> R.string.third_action_drink
    4 -> R.string.fourth_start_again
    else -> R.string.first_action_tree
}

@Composable
private fun chooseImageDesc(state: Int) = when (state) {
    1 -> R.string.desc_tree
    2 -> R.string.desc_lemon
    3 -> R.string.desc_full_glass
    4 -> R.string.desc_empty_glass
    else -> R.string.desc_tree
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            InformColumn()
        }
    }
}