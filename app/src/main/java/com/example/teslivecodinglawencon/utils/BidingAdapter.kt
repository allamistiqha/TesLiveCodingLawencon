package com.example.teslivecodinglawencon.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.example.teslivecodinglawencon.R

@BindingAdapter("setImageView")
fun setImageView(img : ImageView, data: String){
   img.load(data){
       crossfade(true)
       placeholder(R.drawable.ic_load_image)
//       error(R.drawable.ic_load_image)
       transformations(CircleCropTransformation())
   }
}
