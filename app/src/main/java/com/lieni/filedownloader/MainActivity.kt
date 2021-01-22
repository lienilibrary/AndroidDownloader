package com.lieni.filedownloader

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lieni.library.DownloaderBuilder
import com.lieni.library.download.STATUS_SUCCESSFUL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent(this, DownloadService::class.java)
//        startService(intent)

        DownloaderBuilder.build(this) {
            name = "test.apk"
            url = "http://m.lieni.com/download/LieNiC.apk"
            status = {
                when (it) {
                    STATUS_SUCCESSFUL -> {
                        Log.i("MainActivity", "STATUS_SUCCESSFUL")
                    }
                }
            }
            progress = { current, total ->
                Log.i("MainActivity", "onStartCommand-current=${current}--tottal=${total}")
            }
        }.download(this)
    }
}