package app.training.android.room

import androidx.room.Database
import androidx.room.RoomDatabase
import app.training.android.entity.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}