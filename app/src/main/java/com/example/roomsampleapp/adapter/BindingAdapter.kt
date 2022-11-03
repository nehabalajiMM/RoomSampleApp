package com.example.roomsampleapp.adapter

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.roomsampleapp.R

@BindingAdapter("loadImageFromBitmap")
fun ImageView.loadImage(bitmap: Bitmap?) {
    this.load(bitmap) {
        placeholder(R.drawable.placeholder_image)
        error(R.drawable.placeholder_image)
        transformations(RoundedCornersTransformation(30f))
    }
}
