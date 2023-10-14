package com.example.lyordbankdemo.presentation.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lyordbankdemo.R
import com.example.lyordbankdemo.presentation.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView1)

        lifecycleScope.launch {
            delay(500)
            viewModel.getSampleResponse()
                .collect {
                    when (it) {
                        is State.DataState<*> -> textView.text = "success ${it.data}"
                        is State.ErrorState -> textView.text = "error ${it.exception}"
                        is State.LoadingState -> textView.text = "loading"
                       
                    }

                }
        }
    }
}