package com.example.test


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMainBinding


private const val TAG = "MainActivity 싸피"
class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate: ")

        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(binding.fragmentView.id, ViewPagerFragment()).commit()
    }
}
