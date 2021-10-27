## 💰 복권 추첨기 만들기 💰
<img width="331" alt="스크린샷 2021-10-27 오전 11 38 24" src="https://user-images.githubusercontent.com/82588822/139045077-c37748d9-f893-4d87-8a52-ca51b6d1f177.png">

- 복권 추첨기
  - 총 6개의 숫자가 뽑히는 복권 추첨기
  - 최대 5개까지 숫자를 임의로 지정할 수 있으며, 나머지는 랜덤으로 숫자가 뽑힘
- numberpicker
   - 원하는 숫자 범위를 지정해줘야함
- shapeDrawable
   - shpae,solid(색상),size 를 이용하여 drawable 작성
- Random()
   - val random = Random() 
   - 괄호 안에 seed를 넣어주면 그 숫자를 기준으로 매번 똑같은 값이 반환됨.
   - 괄호안에 아무것도 넣지 않으면 nano초가 들어가기때문에 항상 다른 값을 반환함.    
