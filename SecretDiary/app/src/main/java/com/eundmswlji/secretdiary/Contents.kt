package com.eundmswlji.secretdiary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.util.Log
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener
import com.eundmswlji.secretdiary.databinding.ActivityContentsBinding

class Contents : AppCompatActivity() {
    private lateinit var binding: ActivityContentsBinding
    private val handler = Handler(Looper.getMainLooper()) //main 쓰레드와 연결된 handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sp = getSharedPreferences("diary", Context.MODE_PRIVATE)

        binding.editTxt.setText(sp.getString("diary", ""))


        val runnable = Runnable {
            sp.edit {
                this.putString("diary", binding.editTxt.text.toString())
            }
            Log.e("diary", "sp:: ${binding.editTxt.text}")

        }

        binding.editTxt.addTextChangedListener {
            Log.e("diary", "textchanged:: $it")
            handler.removeCallbacks(runnable) //0.5초 전의 runnable은 삭제됨
            handler.postDelayed(runnable, 500) //0.5초 후에 runnable 실행
        }


    }
}