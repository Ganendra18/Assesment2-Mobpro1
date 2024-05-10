package org.d3if0122.assesment2mobpro.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0122.assesment2mobpro.model.Resep

@Database(entities = [Resep::class], version = 1, exportSchema = false)
abstract class ResepDB : RoomDatabase(){

    abstract val dao: ResepDao

    companion object {
        @Volatile
        private var INSTANCE: ResepDB? = null
        fun getInstance(context: Context): ResepDB {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ResepDB::class.java,
                        "resep.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}