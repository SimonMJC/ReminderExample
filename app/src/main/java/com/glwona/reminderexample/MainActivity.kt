package com.glwona.reminderexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.glwona.reminderexample.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.main = this
        binding.lifecycleOwner = this

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private var time: Long = 0
    override fun onBackPressed() {
                when {
                    System.currentTimeMillis() - time >= 2000 -> {
                        time = System.currentTimeMillis()
                        Toast.makeText(this, "한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show()
                    }
                    System.currentTimeMillis() - time < 2000 -> {
                        ActivityCompat.finishAffinity(this)
                        exitProcess(0)
//                        moveTaskToBack(true)
//                        finishAndRemoveTask()
//                        android.os.Process.killProcess(android.os.Process.myPid())
                    }
                    else -> {
                        super.onBackPressed()
                    }
                }
            }
}