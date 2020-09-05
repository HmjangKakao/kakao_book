# 카카오도서 검색앱

## 설명
- 개발언어 : kotlin
- MVVM 아키텍트
- RxJava, RxAndroid 사용

## 과제수행 전략 및 방법
- 일정이 7일로서 세세하게 구현하면 제한시간을 넘길지도 모른다고 판단했습니다.
- 따라서 외부라이브러리를 가능하면 사용하기로 하였습니다.  
- Rest api는 제게 익숙한 retrofit2를 사용하기로 하였습니다.
- api key는 보안이 필요해서 ndk까지 구현하여 보관하기로 하였습니다. (원문으로 들어가 있었는데 추가로 base64까지만 처리했습니다. :D)
- MVVM 아키텍트를 사용해서 최대한 View와 ViewModel을 분리하였습니다.
- ViewModel에는 안드로이드 Native에 종속적인 소스코드를 가능한 넣지 않았습니다.
- 화면이동은 Navigation 라이브러리를 사용하였습니다.
- Rx는 현재 계속 사용해보며 공부중이지만 boilerplate가 상당히 많이 줄고 깔끔해서 사용하였습니다. 
- RxBinding 라이브러리는 사용하지 않았습니다.
- DI는 사용하지 않았습니다. (차후 Hilt가 알파에서 정식버전으로 나오면 사용해볼 예정입니다.)
- 형상관리는 Github로 하고 있으며 upstream에서 fork 떠서 origin(Dev) -> upstream(stg, master) 형태로 관리합니다.
- Github Action으로 CI까지 구현할 예정입니다. 

## 구성
```
src
|   - api
|   |   - base
|   |   |   - BaseRequest.kt
|   |   - book
|   |   |   - BookApi.kt
|   |   |   - ...
|   - app
|   |   |   - App.kt
|   |   |   - ViewModelFactory.kt
|   - data
|   |   - local
|   |   - remote
|   |   |   - book
|   |   |   |   - BookModel
|   |   |   |   - ...
|   |   - view
|   |   |   - SearchQueryData
|   |   - Mapper.kt
|   - extension
|   |   - BindingExtension.kt
|   |   - ...
|   - ui
|   |   - base
|   |   |   - BaseBindingActivity
|   |   |   - ...
|   |   - detail
|   |   |   - DetailFragment.kt
|   |   |   - ...
|   |   - main
|   |   |   - adapter
|   |   |   |   - BookListAdapter.kt
|   |   |   |   - ...
|   |   |   - MainListFragment.kt
|   |   |   - ...
```
### api
- Rest api 연결을 위한 Retrofit2, HttpClient의 기본 Class와 카카오북 조회 api
### app
- Application과 ViewModel을 생성해주는 ViewModelFactory
### data
- remote : 리모트 data model 정의
- view : view에서 사용하는 model 정의
- Mapper : model간 data 변환
### extension
- 코틀린 익스텐션을 사용한 유틸들
### ui 
- base : databinding 기본 Class 구현
- detail : 상세화면
- main : 메인화면

## 외부라이브러리
- [androidx.lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)
- [androidx.navigation](https://developer.android.com/jetpack/androidx/releases/navigation)
- [androidx.databinding](https://developer.android.com/jetpack/androidx/releases/databinding)
- [material](https://material.io/develop/android/docs/getting-started)
- [RxJava](https://github.com/ReactiveX/RxJava)
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [Retrofit2](https://github.com/square/retrofit)
- [Glide](https://github.com/bumptech/glide)
 