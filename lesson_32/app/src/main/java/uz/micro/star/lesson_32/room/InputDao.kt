package uz.micro.star.lesson_32.room

import androidx.room.*
import uz.micro.star.lesson_32.entities.UserEntity


@Dao
interface InputDao {

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUsers(users: List<UserEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("DELETE FROM users")
    fun deleteAll()

/////////////////////////////////////////////////////
}