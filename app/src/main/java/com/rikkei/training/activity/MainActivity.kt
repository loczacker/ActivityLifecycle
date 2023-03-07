package com.rikkei.training.activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.rikkei.training.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }
    private lateinit var binding: ActivityMainBinding


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
        var mediaPlayer = MediaPlayer.create(this, R.raw.loco)
        mediaPlayer.start()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResumeA: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPauseA: ")
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
    }

}