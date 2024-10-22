package com.saputroekosulistiyo.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saputroekosulistiyo.affirmations.data.Datasource
import com.saputroekosulistiyo.affirmations.model.Affirmation
import com.saputroekosulistiyo.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
    // onCreate metode yang dijalankan ketika aktivitas pertama kali dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {  // Menggunakan tema aplikasi "Affirmations"
                // Membuat container menggunakan warna latar belakang dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(),  // Mengisi seluruh ukuran layar
                    color = MaterialTheme.colorScheme.background  // Mengatur warna background dari tema
                ) {
                    AffirmationsApp()  // Memanggil fungsi komposisi utama
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp() {
    // Memanggil fungsi untuk menampilkan daftar afirmasi
    AffirmationList(
        affirmationList = Datasource().loadAffirmations(),  // Memuat daftar afirmasi dari data sumber
    )
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    // Menggunakan LazyColumn untuk menampilkan daftar secara vertikal dan efisien
    LazyColumn(modifier = modifier) {
        // Menampilkan setiap item dalam daftar afirmasi
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,  // Menampilkan kartu afirmasi untuk setiap item
                modifier = Modifier.padding(8.dp)  // Mengatur jarak di sekitar setiap item
            )
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    // Membuat kartu untuk setiap afirmasi
    Card(modifier = modifier) {
        Column {
            // Menampilkan gambar yang terkait dengan afirmasi
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),  // Deskripsi gambar menggunakan resource string
                modifier = Modifier
                    .fillMaxWidth()  // Gambar mengisi lebar penuh
                    .height(194.dp),  // Mengatur tinggi gambar
                contentScale = ContentScale.Crop  // Memotong gambar agar sesuai dengan ukuran
            )
            // Menampilkan teks afirmasi di bawah gambar
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),  // Memberikan padding di sekitar teks
                style = MaterialTheme.typography.headlineSmall  // Mengatur gaya teks menggunakan tema
            )
        }
    }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
    // Menampilkan pratinjau kartu afirmasi di editor
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
}
