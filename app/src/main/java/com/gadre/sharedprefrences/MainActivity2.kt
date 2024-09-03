package com.gadre.sharedprefrences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gadre.sharedprefrences.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {


    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }



}


