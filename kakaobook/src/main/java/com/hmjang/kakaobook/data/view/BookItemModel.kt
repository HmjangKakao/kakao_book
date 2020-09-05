package com.hmjang.kakaobook.data.view

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class BookItemModel(@SerializedName("title") val title: String = "",
                         @SerializedName("content") val content: String? = "",
                         @SerializedName("datetime") val datetime: String? = "",
                         @SerializedName("price") val price: Int = 0,
                         @SerializedName("publisher") val publisher: String? = "",
                         @SerializedName("sale_price") val sale_price: Int = 0,
                         @SerializedName("status") val status: String? = "",
                         @SerializedName("thumbnail") val thumbnail: String? = "",
                         @SerializedName("url") val url: String? = "",
                         @SerializedName("authors") val authors: Array<String>? = arrayOf()) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BookItemModel

        if (title != other.title) return false
        if (content != other.content) return false
        if (datetime != other.datetime) return false
        if (price != other.price) return false
        if (publisher != other.publisher) return false
        if (sale_price != other.sale_price) return false
        if (status != other.status) return false
        if (thumbnail != other.thumbnail) return false
        if (url != other.url) return false
        if (!authors.contentEquals(other.authors)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + datetime.hashCode()
        result = 31 * result + price
        result = 31 * result + publisher.hashCode()
        result = 31 * result + sale_price
        result = 31 * result + status.hashCode()
        result = 31 * result + thumbnail.hashCode()
        result = 31 * result + url.hashCode()
        result = 31 * result + authors.contentHashCode()
        return result
    }
}