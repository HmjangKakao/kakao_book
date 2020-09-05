package com.hmjang.kakaobook.data

import com.hmjang.kakaobook.data.remote.book.BookModel
import com.hmjang.kakaobook.data.view.BookItemModel
import com.hmjang.kakaobook.extension.transformDate

fun BookModel.toBookItemModel(): BookItemModel {
    return BookItemModel(
        title = title,
        content = content,
        datetime = transformDate(datetime, "yyyy-MM-dd"),
        price = price,
        publisher = publisher,
        thumbnail = thumbnail,
        status = status,
        url = url,
        authors = authors,
        sale_price = sale_price
    )
}