package org.d3if0122.assesment2mobpro.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0122.assesment2mobpro.database.ResepDao
import org.d3if0122.assesment2mobpro.model.Resep
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
class DetailViewModel(private val dao: ResepDao) : ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama: String, judul: String, tipeResep: String, detailResep: String){
        val resep = Resep(
            nama = nama,
            tanggal = formatter.format(Date()),
            judul = judul,
            tipeResep = tipeResep,
            detailResep = detailResep
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(resep)
        }
    }

    suspend fun getResep(id: Long): Resep? {
        return dao.getResepById(id)
    }

    fun update(id: Long, nama: String, judul: String, tipeResep: String, detailResep: String){
        val resep = Resep(
            id = id,
            nama = nama,
            tanggal = formatter.format(Date()),
            judul = judul,
            tipeResep = tipeResep,
            detailResep = detailResep
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(resep)
        }
    }

    fun delete(id: Long){
        viewModelScope.launch (Dispatchers.IO){
            dao.deleteById(id)
        }
    }
}