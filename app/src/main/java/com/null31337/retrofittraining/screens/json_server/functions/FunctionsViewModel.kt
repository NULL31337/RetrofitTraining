package com.null31337.retrofittraining.screens.json_server.functions

import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Toast
import androidx.core.view.isGone
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.data.repository.functions.FunctionsRepository
import com.null31337.retrofittraining.databinding.SortViewBinding
import com.null31337.retrofittraining.model.functions.Post
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response

//TODO Переписать на ConcurrentQueue (узнал недавно на лекции)
class FunctionsViewModel : ViewModel() {
    private var rep = FunctionsRepository()
    var data: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getAllPosts() {
        viewModelScope.launch {
            val tmp = rep.getAllPosts()
            data.value = tmp
        }
    }

    fun getByQueryMap(map: Map<String, String>) {
        viewModelScope.launch {
            val tmp = rep.getByQueryMap(map)
            data.value = tmp
        }
    }

    fun deleteById(id: Int) {
        viewModelScope.launch {
            rep.deleteById(id)
        }
    }


    fun createPost(post: Post) {
        viewModelScope.launch {
            rep.createPost(post)
        }
    }

    fun putPost(post: Post) {
        viewModelScope.launch {
            rep.putPost(post)
        }
    }

    companion object {
        fun waiting() {
            Toast.makeText(APP, "Sending, wait 3 sec", Toast.LENGTH_LONG).show()
            runBlocking {
                Thread.sleep(3000)
            }
        }
    }
}
