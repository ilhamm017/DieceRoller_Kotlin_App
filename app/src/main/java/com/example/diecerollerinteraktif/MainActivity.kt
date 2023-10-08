package com.example.diecerollerinteraktif

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diecerollerinteraktif.ui.theme.DieceRollerInteraktifTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DieceRollerInteraktifTheme {
                KocokDaduApp()
            }
        }
    }
}

@Preview
@Composable
fun KocokDaduApp() { //fungsi Kcocok dadu
    KocokDaduDenganGambarDanTombol( //Memanggil fungsi kocokDaduDenganGambardanTombol
        modifier = Modifier     //Menambahkan modifier
            .fillMaxSize()      //Mengisi atau memperluar ukuran maksimum dari komponen
            .wrapContentSize(Alignment.Center) //mengatur ukuran komponen sesuai dengan konten dan memposisikannya di tengah
    )
}

@Composable
fun KocokDaduDenganGambarDanTombol(modifier: Modifier = Modifier) { //fungsi menampilkan dadu dan logika pengocokan
    var result by remember { mutableStateOf(1) } //membuat variabel result yang dihubungkan dengan mutableStateOf. Selain itu karena menggunakan remember, maka perubahan yang terjadi akan tetap diingat dan tetap ada selama siklus hidup komponen yang menggunakan variabel result
    val imageResource = when (result) { //Mendapatkan id dari resources image yang digunakan
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column( //Menampilkan dalam column
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image( //Menampilkan gambar
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { // Menampilkan tombol
            result = (1..6).random() // mendapatkan nilai result random antara 1 - 6
        }) {
            Text(stringResource(R.string.kocok))
        }
    }
}

