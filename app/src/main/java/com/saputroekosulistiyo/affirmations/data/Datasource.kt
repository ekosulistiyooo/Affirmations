package com.saputroekosulistiyo.affirmations.data

import com.saputroekosulistiyo.affirmations.R
import com.saputroekosulistiyo.affirmations.model.Affirmation

class Datasource() {
    // Fungsi ini mengembalikan daftar (List) objek Affirmation, masing-masing terdiri dari ID resource string dan gambar yang sesuai
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            // Membuat daftar objek Affirmation dengan teks dan gambar dari resource
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5),
            Affirmation(R.string.affirmation6, R.drawable.image6),
            Affirmation(R.string.affirmation7, R.drawable.image7),
            Affirmation(R.string.affirmation8, R.drawable.image8),
            Affirmation(R.string.affirmation9, R.drawable.image9),
            Affirmation(R.string.affirmation10, R.drawable.image10)
        )
    }
}
