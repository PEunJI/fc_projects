package com.eundmswlji.lottery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eundmswlji.lottery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isSetting = false //
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //numberpicker 설정
        binding.np.apply {
            this.minValue=1
            this.maxValue=45
        }


    }
    //추가버튼
    fun initAddButton(){
        if 
    }

    //추첨버튼
    fun initRunButton(){

    }
}