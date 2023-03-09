package com.rikkei.training.activity

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rikkei.training.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }
    private lateinit var binding: ActivityMainBinding

    private lateinit var mediaPlayer: MediaPlayer

    private var currentPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnA.setOnClickListener{
            startActivityB()
        }

        Log.d(TAG, "onCreateA: ")
    }

    private fun startActivityB() {
       val startBIntent = Intent(this, ActivityB::class.java)
        startActivity(startBIntent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStartA: ")
        mediaPlayer = MediaPlayer.create(this, R.raw.loco)
        mediaPlayer.start()
        mediaPlayer.seekTo(currentPosition)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResumeA: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPauseA: ")
        mediaPlayer.pause()
        currentPosition = mediaPlayer.currentPosition
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStopA: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroyA: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestartA: ")
        mediaPlayer.seekTo(currentPosition)
        mediaPlayer.start()

    }

}