package com.example.blazesports.utils

import android.content.Context
import android.media.MediaPlayer
import com.example.blazesports.R

object MusicManager {
    private var mediaPlayer: MediaPlayer? = null
    private var isMusicPlaying: Boolean = false

    fun startMusic(context: Context) {
        if (!isMusicPlaying) {
            mediaPlayer = MediaPlayer.create(context, R.raw.music)
            mediaPlayer?.isLooping = true
            mediaPlayer?.start()
            isMusicPlaying = true
        }
    }

    fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        isMusicPlaying = false
    }

    fun toggleMusic(context: Context) {
        if (isMusicPlaying) {
            stopMusic()
        } else {
            startMusic(context)
        }
    }

    fun isMusicPlaying(): Boolean {
        return isMusicPlaying
    }
}