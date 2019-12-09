#### Android-Room-ImageUpload

![blog](https://postfiles.pstatic.net/MjAxOTEyMDlfMTY1/MDAxNTc1ODg5ODEyNTUy.dsQ2J9adkkJhSWv3dHjmv4unz7lpj69ldlPXvQzB618g.o0gtxggNsGFgub7sHkVoaWsxIa13B8y497wAhepdmXEg.JPEG.getinthere/Screenshot_68.jpg?type=w773)

#### 1. 전화번호부 앱
- 전화번호 추가
- 전화번호 삭제
- 전화번호 전체 삭제
- 전화번호 수정
- 프로파일 이미지 업로드
- ROOM 활용

#### 2. Gradle
```gradle
// room
def room_version = "2.2.0-beta01"
implementation "androidx.room:room-runtime:$room_version"
annotationProcessor "androidx.room:room-compiler:$room_version"

// google material
implementation 'com.google.android.material:material:1.2.0-alpha02'

// ted permission
implementation "gun0912.ted:tedpermission:2.1.0"

// circle image
implementation 'de.hdodenhof:circleimageview:3.0.1'
```

#### 3. 주의할 점
- 사진 접근 권한을 위해서 AndroidManifest.xml 수정
```xml

<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

<application
    android:requestLegacyExternalStorage="true"
    -- 생략
```
- 메인쓰레드에서 ROOM에 DML하는 것이 허용되지 않기 때문에 아래 추가. 
```java
// 메인쓰레드에서 쿼리 하는 것을 허용(추천하지 않음.기본 예제여서 이렇게 함)
contactAppDatabase = Room.databaseBuilder(getApplicationContext(), ContactAppDatabase.class, "ContactDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration() // DB 스키마 변경시 => version 번호 바꾸려면 필요
                    .build();
```
#### 3. Blog 주소
<https://blog.naver.com/getinthere/221695431900>

#### 4. 이미지 업로드 참고 블로그
<https://black-jin0427.tistory.com/120>

#### 5. 추가하고 싶은 것
- 사진을 찍으면서 해당 사진 바로 업로드 하기
