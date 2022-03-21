package ru.ladgertha.database_impl.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     * @return new rowId for the inserted item
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T): Long

    /**
     * Insert an array of objects in the database.
     *
     * @param objects the objects to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insert(objects: List<T>)

    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     * @return number of rows updated in the database
     */
    @Update
    fun update(obj: T): Int

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     * @return @return number of rows deleted in the database
     */
    @Delete
    fun delete(obj: T): Int

    /**
     * Delete an objects from the database
     *
     * @param obj the object to be deleted
     * @return @return number of rows deleted in the database
     */
    @Delete
    @JvmSuppressWildcards
    fun delete(obj: Collection<T>): Int
}
