package edu.itvo.quotescelebrities.data.local.daos

import androidx.room.*
import edu.itvo.quotescelebrities.data.local.entities.QuoteEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface QuoteDao {
    @Insert
    suspend fun insert(quote: QuoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<QuoteEntity>)

    @Query("SELECT * FROM quote ORDER BY author ASC")
    fun getQuotes(): Flow<List<QuoteEntity>>

    @Query("SELECT * FROM quote WHERE id = :quoteId")
    fun getQuote(quoteId: Int): Flow<QuoteEntity>

    @Query("SELECT * FROM quote ORDER BY random() LIMIT 1")
    fun getQuoteRandom(): Flow<QuoteEntity>

    @Query("DELETE FROM quote")
    suspend fun deleteAll()

    @Query("DELETE FROM quote WHERE id=:quoteId ")
    suspend fun delete(quoteId: Int)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateQuote(quote: QuoteEntity)

}
