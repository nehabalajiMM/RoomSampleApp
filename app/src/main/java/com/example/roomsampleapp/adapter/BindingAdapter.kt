package com.example.roomsampleapp.adapter

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("loadImageFromBitmap")
fun ImageView.loadImage(bitmap: Bitmap) {
    this.load(bitmap) {
        transformations(RoundedCornersTransformation(30f))
    }
}
