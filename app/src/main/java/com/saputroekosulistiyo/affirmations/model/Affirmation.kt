package com.saputroekosulistiyo.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourceId: Int,  // Menyimpan ID resource untuk teks (string) afirmasi
    @DrawableRes val imageResourceId: Int  // Menyimpan ID resource untuk gambar afirmasi
)
