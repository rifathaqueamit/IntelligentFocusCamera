package com.rha.intelligentfocuscamera

import android.R.attr.data
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rha.intelligentfocuscamera.databinding.ActivityPreviewWindowBinding
import java.io.BufferedOutputStream
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL


class PreviewWindow : AppCompatActivity() {

    private lateinit var viewBinding: ActivityPreviewWindowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityPreviewWindowBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadImage()
    }

    private fun loadImage() {
        val uriStr = intent.getStringExtra("captured_image_uri")
        viewBinding.imgPreview.setImageURI(Uri.parse(uriStr))
    }

    private fun sendImageForProcessing(imagePath: String, onSuccess: () -> Unit, onFail: () -> Unit) {

    }
}