package com.ww.sotest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ww.sotest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = maxNum(25, 24).toString()

        Log.d(TAG, "onCreate: $packageName--->")

        binding.sampleText.setOnClickListener {

            Log.d(TAG, "onCreate: ${Dynamic.add(8, 9)}")
            Toast.makeText(this@MainActivity, Dynamic.add(5, 8).toString(), Toast.LENGTH_LONG).show()
        }
    }


    /**
     * A native method that is implemented by the 'sotest' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String
    private external fun invokeNative(): String
    private external fun maxNum(a: Int, b: Int): Int

    companion object {
        private const val TAG = "MainActivity"

        // Used to load the 'sotest' library on application startup.
        init {
            System.loadLibrary("sotest")
        }
    }
}