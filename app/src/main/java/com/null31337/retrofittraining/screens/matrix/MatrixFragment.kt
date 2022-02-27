package com.null31337.retrofittraining.screens.matrix

import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.null31337.retrofittraining.R


class MatrixFragment: Fragment() {
    private lateinit var surface: SurfaceView
    private lateinit var engine: MatrixEngine

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_matrix, container, false)
        return view
    }
}