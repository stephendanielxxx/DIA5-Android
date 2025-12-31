package app.training.android.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "rate")
    val rate: Double
)
