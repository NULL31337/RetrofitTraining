package com.null31337.retrofittraining.screens.json_server.functions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.null31337.retrofittraining.data.repository.functions.FunctionsRepository
import com.null31337.retrofittraining.model.functions.Post
import kotlinx.coroutines.launch
import retrofit2.Response


class FunctionsViewModel: ViewModel() {
    var rep = FunctionsRepository()
    var data: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    fun getAllPosts() {
        viewModelScope.launch {
            var tmp = rep.getAllPosts()
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
}