package app.training.android.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import app.training.android.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): Flow<List<Product>>

    @Query("SELECT * FROM product WHERE id = :id")
    suspend fun getProduct(id: Int): Product

    @Insert
    suspend fun insertProduct(product: Product)

    @Query("DELETE FROM product WHERE id = :id")
    suspend fun deleteProduct(id: Int)

}