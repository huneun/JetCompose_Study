package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyCard()
                }
            }
        }
    }
}

@Composable
fun MyCard() {
    Box{
        Introduce(stringResource(R.string.jennifer_doe), "Android Developer Extraordinaire")
        ContactMe("+11 (123) 444 555 666", "@AndroidDev","jen.doe@android.com", Modifier.fillMaxSize())
    }

}

@Composable
fun Introduce(name: String, job:String, modifier: Modifier = Modifier){
    Surface (color = Color(0xAF7dDcA4)){
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,


        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .background(color = Color.DarkGray)
            )
            Text(text = name, modifier = modifier, fontSize = 45.sp)
            Text(text = job, modifier = modifier, fontSize = 12.sp)
        }
    }
}
@Composable
fun ContactMe(phone: String, team:String, email:String, modifier: Modifier){

        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.width(200.dp).height(25.dp), content = {
                Image(
                    painter = painterResource(id = R.drawable.baseline_local_phone_24),
                    contentDescription = null, Modifier.size(25.dp)
                )
                Text(text = phone, fontSize = 14.sp, modifier = Modifier.padding(start = 20.dp, bottom = 5.dp).fillMaxHeight())
            })
            Row (horizontalArrangement = Arrangement.Start, modifier = Modifier.width(200.dp), content = {
                Image(
                    painter = painterResource(id = R.drawable.baseline_share_24),
                    contentDescription = null, Modifier.size(25.dp)
                )
                Text(text = team, fontSize = 14.sp, modifier = Modifier.padding(start = 20.dp, bottom = 5.dp))
            })
            Row (horizontalArrangement = Arrangement.Start, modifier = Modifier.width(200.dp), content = {
                Image(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = null, Modifier.size(25.dp)
                )
                Text(text = email, fontSize = 14.sp, modifier = Modifier.padding(start = 20.dp, bottom = 30.dp))
            })
        }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        MyCard()
    }
}