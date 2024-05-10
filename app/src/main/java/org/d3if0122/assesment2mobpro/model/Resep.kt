package org.d3if0122.assesment2mobpro.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resep")
data class Resep(
@PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    val nama: String,
    val judul: String,
    val tipeResep: String,
    val detailResep: String,
    val tanggal: String
)
