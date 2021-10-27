package com.eundmswlji.secretdiary

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import com.eundmswlji.secretdiary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var changePsMode = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.np1.apply {
            this.minValue = 0
            this.maxValue = 9
        }
        binding.np2.apply {
            this.minValue = 0
            this.maxValue = 9
        }
        binding.np3.apply {
            this.minValue = 0
            this.maxValue = 9
        }

        val sp = getSharedPreferences("diary", Context.MODE_PRIVATE)

        binding.btnOpen.setOnClickListener {
            //비번 바꾸는 중이면 오픈활성화 ㄴㄴ
            if (changePsMode) {
                Toast.makeText(this, "비밀번호 변경중에는 다이어리를 오픈 할 수 없습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                checkPsForOpen()
            }
        }

        binding.btnReset.setOnClickListener {

            //비번 변경중
            if (changePsMode) {
                var revisedPS = "${binding.np1.value}${binding.np2.value}${binding.np3.value}"

                sp.edit(commit = true){
                    this.putString("password",revisedPS)
                }
                changePsMode=false
                Toast.makeText(this,"비밀변호 변경 완료",Toast.LENGTH_SHORT).show()
                binding.btnReset.setBackgroundColor(Color.BLACK)

            }
            //비변 변경중 아님
            else{
                //비번이 맞나 확인 -> 맞으면 changePsMode를 True로 변경
                checkPsForChange()
            }

        }

    }

    fun checkPsForOpen() {
        val sp = getSharedPreferences("password", Context.MODE_PRIVATE)
        val ps = sp.getString("password", "000")
        //ps Correct
        if (ps.equals("${binding.np1.value}${binding.np2.value}${binding.np3.value}")) {
            val intent = Intent(this, Contents::class.java)
            startActivity(intent)
        }
        //ps Incorrect
        else {
            runAlert()
        }
    }

    fun checkPsForChange() {
        val sp = getSharedPreferences("password", Context.MODE_PRIVATE)
        val ps = sp.getString("password", "000")
        //ps Correct
        if (ps.equals("${binding.np1.value}${binding.np2.value}${binding.np3.value}")) {
            changePsMode=true
            Toast.makeText(this,"비밀변호 변경 중",Toast.LENGTH_SHORT).show()
            binding.btnReset.setBackgroundColor(Color.RED)

        }
        //ps Incorrect
        else {
           runAlert()
        }
    }


    fun runAlert(){
        AlertDialog.Builder(this)
            .setTitle("실패!")
            .setMessage("비밀번호가 잘못 되었습니다.")
            .setPositiveButton("확인") { dialog, wich ->
            }
            .create()
            .show()
    }

}