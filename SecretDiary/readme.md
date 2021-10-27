## 📔 비밀 다이어리 만들기 📔


<img width="324" alt="스크린샷 2021-10-27 오후 6 58 21" src="https://user-images.githubusercontent.com/82588822/139044134-0e214816-6195-470f-a4b3-8f6ee0732b61.png">

- 폰트 넣는법 
  - .ttf 다운 -> res 에 폰트 폴더 만들어서 넣기 
  - 파일이름은 소문자만 됨
  - font family로 폰트 지정
- 버튼 색깔 바꾸기
  - materialDesign은 미리 버튼 색상을 지정해놓음
  - materialDeisign에 영향을 받지 않는 appcompat.button을 사용하자
- 상단액션바 없애기
  - Noactionbar 스타일을 만들어서 매니패스트에 지정
- sharedPreference
   - commit(메인UI잠시 멈추고 저장), apply(메인UI 멈추지 않고 비동기적으로 실행)
   - kotlin ktx을 통해 기본적으로 apply를 해준다.
- handler
  - 쓰레드와 쓰레드를 엮어주는 기능
  - Handler(Looper.getMainLooper()) //main 쓰레드와 연결된 handler
