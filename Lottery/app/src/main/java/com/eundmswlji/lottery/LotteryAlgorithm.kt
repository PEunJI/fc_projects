package com.eundmswlji.lottery

import java.util.*
// // 1~45까지 랜덤으로 6개 뽑기
fun main(){
    solution3()
}
// 방법 1.list 이용 & Random함수 이용
fun solution1(){
    val list = mutableListOf<Int>()
    val random = Random() // 괄호 안에 seed를 넣어주면 그 숫자를 기준으로 매번 똑같은 값이 반환됨.
    //괄호안에 아무것도 넣지 않으면 nano초가 들어가기때문에 항상 다른 값을 반환함.
    while(list.size<6){
        val rdnum = random.nextInt(45) + 1 //1~45까지
        if(list.contains(rdnum))continue
        else list.add(rdnum)
    }
}

//방법 2. set이용
fun solution2(){
    val setlist = mutableSetOf<Int>()
    val random = Random()
    while(setlist.size<6){
        setlist.add(random.nextInt(45) +1)
    }
    print(setlist)
}

//방법 3.list에 45개의 숫자를 미리 넣어놓고 셔플해서 앞의 6개 숫자만 가져옴
fun solution3(){
    val list = mutableListOf<Int>()
    for(i in 1..45){
        list.add(i)
    }
    list.shuffle() //shuffle
    println(list.subList(0,6))//0~5번째 숫자 뽑아옴
}