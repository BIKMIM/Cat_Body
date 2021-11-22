package com.bikmim.cat_body

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import com.bikmim.cat_body.databinding.ActivityResult6Binding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class ResultActivity6 : AppCompatActivity() {
    private lateinit var r6Binding : ActivityResult6Binding

    // 광고용
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        r6Binding = ActivityResult6Binding.inflate(layoutInflater)
        setContentView(r6Binding.root)

        // 애드몹 광고 초기화
        MobileAds.initialize(this) {}
        // 광고 게시
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // Put, get Extra로 데이터 가져와서 PercentResult에 뿌리기
        if (intent.hasExtra("FBMI")) {
            r6Binding.tv6PercentResult.text = intent.getStringExtra("FBMI")
        } else {
            Toast.makeText(this, "값을 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
        }


        // 스크롤 만들기
        r6Binding.tv6StatusText.movementMethod = ScrollingMovementMethod.getInstance()
        r6Binding.tv6DiagText.movementMethod = ScrollingMovementMethod.getInstance()

        //스크롤 제일 위로 올리기
        r6Binding.tv6StatusText.scrollY = 0

        //스크롤 제일 위로 올리기
        r6Binding.tv6DiagText.scrollY = 0
    }
}