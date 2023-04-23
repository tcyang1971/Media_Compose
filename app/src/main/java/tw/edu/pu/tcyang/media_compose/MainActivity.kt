package tw.edu.pu.tcyang.media_compose

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.edu.pu.tcyang.media_compose.ui.theme.Media_ComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Media_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    var mper = MediaPlayer()

    Row{
        Button(
            onClick = {
                mper.reset()
                mper = MediaPlayer.create(context, R.raw.tcyang)
                mper.start() },
            modifier = Modifier
                .fillMaxWidth(0.33f)
                .fillMaxHeight(0.3f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ){
            Image(
                painterResource(id = R.drawable.teacher),
                contentDescription ="teacher icon",
                modifier = Modifier.size(25.dp))
            Text(text = "歡迎", color = Color.Blue)
            Text(text = "修課", color = Color.Red)
        }

        Button(
            onClick = {
                mper.reset()
                mper = MediaPlayer.create(context, R.raw.fly)
                mper.start()
            },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
        ) {
            Image(
                painterResource(id = R.drawable.fly),
                contentDescription ="fly icon",
                modifier = Modifier.size(50.dp))
            Text(text = "展翅飛翔")
        }

        Button(
            onClick = {
                mper.reset()
                context.startActivity(Intent(context, VideoActivity::class.java))
            },
            Modifier
                .fillMaxWidth ()
                .fillMaxHeight(0.7f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Image(
                painterResource(id = R.drawable.handpan),
                contentDescription ="handpan icon",
                modifier = Modifier.size(50.dp))
            Text(text = "手碟音樂", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Media_ComposeTheme {
        Greeting("Android")
    }
}