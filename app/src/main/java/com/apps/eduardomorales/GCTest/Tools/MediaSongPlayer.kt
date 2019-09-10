package com.apps.eduardomorales.GCTest.Tools

import android.media.MediaPlayer
import android.util.Log
import com.apps.eduardomorales.GCTest.Views.IMediaListener
import java.io.IOException

class MediaSongPlayer(listener : IMediaListener) {

    private var mediaPlayer = MediaPlayer()
    private val listener = listener

    fun playMedia(src: String, position: Int){

        mediaPlayer.reset()

        try {
            mediaPlayer.setDataSource (src)
            mediaPlayer.prepareAsync()

        } catch (e: IOException) {
            Log.e("Error",e.message)
            e.printStackTrace()
        }

        mediaPlayer.setOnPreparedListener {
            it.start()
            listener.onMediaDownloaded(position)
        }

        mediaPlayer.setOnCompletionListener {
            this.listener.onMediaEnd(position)
        }

    }

    fun stopMedia(){
        mediaPlayer.stop()
        mediaPlayer.reset()
    }
}
