package com.eundmswlji.lottery

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.eundmswlji.lottery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isSetting = false // 추첨버튼을 누르면 true로 변경
    private val pickNumSet = mutableSetOf<Int>()
    private lateinit var textViewList: MutableList<TextView>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        textViewList = mutableListOf(
            binding.txt1,
            binding.txt2,
            binding.txt3,
            binding.txt4,
            binding.txt5,
            binding.txt6,
        )

        initNumberPicker()
        initRunButton()
        initAddButton()
        initClearButton()

    }

    fun initNumberPicker() {
        //numberpicker 설정
        binding.np.apply {
            this.minValue = 1
            this.maxValue = 45
        }
    }

    //추가버튼
    fun initAddButton() {
        binding.btnAdd.setOnClickListener {
            if (isSetting) {
                Toast.makeText(this, "초기화 하고 사용해주세요", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (pickNumSet.size >= 5) {
                Toast.makeText(this, "이미 5개를 선택하셨습니다.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (pickNumSet.contains(binding.np.value)) {
                Toast.makeText(this, "이미 선택된 숫자입니다.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //n번째 텍스트뷰 보이게 하기
            textViewList[pickNumSet.size].text = binding.np.value.toString()
            setBackground(binding.np.value,textViewList[pickNumSet.size])
            textViewList[pickNumSet.size].isVisible = true
            pickNumSet.add(binding.np.value)


        }
    }

    //추첨버튼
    fun initRunButton() {
        binding.btnPick.setOnClickListener {
            val list = getRandomNumber()
            isSetting = true

            list.forEachIndexed { index, number ->
                val textView = textViewList[index]

                textView.text = number.toString()
                setBackground(number,textView)
                textView.isVisible = true
            }
        }
    }


    private fun getRandomNumber(): List<Int> {
        val numberList = mutableListOf<Int>()
            .apply {
                for (i in 1..45) {
                    if (pickNumSet.contains(i)) {
                        continue
                    }
                    this.add(i)
                }
            }

        numberList.shuffle()
        val newList = pickNumSet.toList() + numberList.subList(0, 6 - pickNumSet.size)
        return newList.sorted()
    }

    private fun initClearButton() {
        binding.btnReset.setOnClickListener {
            pickNumSet.clear()
            textViewList.forEach {
                it.isVisible = false
            }
            isSetting = false
        }
    }

    private fun setBackground(num: Int, textView: TextView) {
        when (num) {
            in 1..10 -> textView.background =
                ContextCompat.getDrawable(this, R.drawable.numback_blue)
            in 11..20 -> textView.background =
                ContextCompat.getDrawable(this, R.drawable.numback_green)
            in 21..30 -> textView.background =
                ContextCompat.getDrawable(this, R.drawable.numback_gray)
            in 31..40 -> textView.background =
                ContextCompat.getDrawable(this, R.drawable.numback_red)
            else -> textView.background =
                ContextCompat.getDrawable(this, R.drawable.numback_yello)
        }
    }
}
