package com.lieni.library.download

import android.app.DownloadManager

interface IDownload {
    fun makeRequest(): DownloadManager.Request

    fun download()
}