package com.eundmswlji.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.eundmswlji.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isOperator = false
    private var hasOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    fun buttonClicked(v: View) {
        when (v.id) {
            R.id.btn_0 -> numberButtonClicked("0")
            R.id.btn_1 -> numberButtonClicked("1")
            R.id.btn_2 -> numberButtonClicked("2")
            R.id.btn_3 -> numberButtonClicked("3")
            R.id.btn_4 -> numberButtonClicked("4")
            R.id.btn_5 -> numberButtonClicked("5")
            R.id.btn_6 -> numberButtonClicked("6")
            R.id.btn_7 -> numberButtonClicked("7")
            R.id.btn_8 -> numberButtonClicked("8")
            R.id.btn_9 -> numberButtonClicked("9")
            R.id.btn_minus -> operatorButtonClicked("-")
            R.id.btn_plus -> operatorButtonClicked("+")
            R.id.btn_multi -> operatorButtonClicked("*")
            R.id.btn_modulo -> operatorButtonClicked("%")
            R.id.btn_division -> operatorButtonClicked("/")
        }

    }

    private fun numberButtonClicked(number: String) {
        //operator 사용 후 숫자 입력 시
        if(isOperator){
            binding.expressionTextView.append(" ")
        }

        isOperator=false


      val expressionText=  binding.expressionTextView.text.split(" ")
        //마지막 숫자가 15자리 이상이면
        if(expressionText.isNotEmpty() && expressionText.last().length >=15 ){
            Toast.makeText(this,"15자리 까지만 사용 할 수 있습니다.",Toast.LENGTH_SHORT).show()
            return
            //맨 앞자리 수가 0일 경우
        } else if(expressionText.last().isEmpty()&&number=="0"){
            Toast.makeText(this,"0은 제일 앞에 올 수 없습니다..",Toast.LENGTH_SHORT).show()
            return
        }

        binding.expressionTextView.append(number)

    }

    private fun operatorButtonClicked(operator: String) {
        if(binding.expressionTextView.text.isEmpty()){
            return
        }


    }


    fun btnHistoryClicked(v: View) {}
    fun btnClearClicked(v: View) {}
    fun btnResultClicked(v: View) {}

}