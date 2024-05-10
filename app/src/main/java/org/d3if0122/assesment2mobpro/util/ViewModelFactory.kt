package org.d3if0122.assesment2mobpro.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0122.assesment2mobpro.database.ResepDao
import org.d3if0122.assesment2mobpro.ui.screen.DetailViewModel
import org.d3if0122.assesment2mobpro.ui.screen.MainViewModel
class ViewModelFactory (
    private val dao: ResepDao
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(dao) as T
        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}
