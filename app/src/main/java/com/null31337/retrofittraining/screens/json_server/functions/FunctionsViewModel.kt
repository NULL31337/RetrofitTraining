package com.null31337.retrofittraining.screens.json_server.functions

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.data.repository.functions.FunctionsRepository
import com.null31337.retrofittraining.model.functions.Post
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response


class FunctionsViewModel : ViewModel() {
    private var rep = FunctionsRepository()
    var data: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    fun getAllPosts() {
        viewModelScope.launch {
            val tmp = rep.getAllPosts()
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

    companion object {
        fun waiting() {
            Toast.makeText(APP, "Sending, wait 3 sec", Toast.LENGTH_LONG).show()
            runBlocking {
                Thread.sleep(3000)
            }
        }
    }
}