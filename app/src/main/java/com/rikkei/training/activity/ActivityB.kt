package com.rikkei.training.activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rikkei.training.activity.databinding.ActivityBBinding
import kotlin.math.log

class ActivityB : AppCompatActivity() {

    companion object {
        private const val TAG = "ActivityB"
    }

    private lateinit var binding: ActivityBBinding
    private lateinit var mediaPlayerB: MediaPlayer

    private var mediaB: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnB.setOnClickListener{
            startMainActivity()
        }
        Log.d(TAG, "onCreateB: ")
    }

    private fun startMainActivity() {
        val startMainIntent = Intent(this, MainActivity::class.java)
        startActivity(startMainIntent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStartB: ")
        mediaPlayerB = MediaPlayer.create(this, R.raw.loveme)
        mediaPlayerB.start()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResumeB: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPauseB: ")
        mediaPlayerB.pause()
        mediaB = mediaPlayerB.getCurrentPosition()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStopB: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroyB: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestartB: ")
        mediaPlayerB.seekTo(mediaB)

    }

}