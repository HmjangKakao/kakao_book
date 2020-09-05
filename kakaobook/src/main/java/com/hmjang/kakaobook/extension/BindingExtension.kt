package com.hmjang.kakaobook.extension

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import com.bumptech.glide.Glide
import java.lang.NumberFormatException
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.Unit.toString

@BindingAdapter("load_image")
fun ImageView.load(any: Any) {
    Glide.with(this).load(any).into(this)
}

@BindingAdapter("visibleSwitch")
fun View.visibleSwitch(visible: Any) {
    visibility = if (visible == "true") View.VISIBLE else View.GONE
}

private val DECIMAL_FORMAT =
    DecimalFormat("###,###", DecimalFormatSymbols.getInstance(Locale.KOREA))

@BindingAdapter("moneyText")
fun TextView.toKRWFormat(price: String) {
    text = if (price.isNotEmpty() && price.isNotBlank() && price.isDigitsOnly()) {
        try {
            DECIMAL_FORMAT.format(price.toLong())
        } catch (e: NumberFormatException) {
            DECIMAL_FORMAT.format(price.toDouble())
        }
    } else {
        ""
    } + " 원"
}