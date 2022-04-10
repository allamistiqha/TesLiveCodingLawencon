package com.example.teslivecodinglawencon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.teslivecodinglawencon.repository.RepositoryData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelRestorant @Inject constructor(
   repo: RepositoryData
) : ViewModel() {
   val dataRestoran = repo.getRetoran().asLiveData()

//    private val liveDataRestorant = MutableLiveData<List<Restoran>>()
//    val dataRetorant : LiveData<List<Restoran>> = liveDataRestorant
//
//    init {
//        viewModelScope.launch {
//            val resInterface = restorantInterface.getData()
//            delay(1500)
//            liveDataRestorant.value = resInterface
//        }
//    }
}