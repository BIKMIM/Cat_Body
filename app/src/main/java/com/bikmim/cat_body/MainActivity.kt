package com.bikmim.cat_body

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bikmim.cat_body.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.lang.NullPointerException


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding

    // 광고용
    lateinit var mAdView : AdView

    var bmiResult = 0.0
    private var bmiFormat2f : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 키바인딩
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // 애드몹 광고 초기화
        MobileAds.initialize(this) {}
        // 광고 게시
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // Main -> ResultActivity1 로 이동
        fun moveResultActivity1() {
            val intent = Intent(this, ResultActivity1::class.java)
            intent.putExtra("FBMI", bmiFormat2f)
            startActivity(intent)
        }

        fun moveResultActivity2() {
            val intent = Intent(this, ResultActivity2::class.java)
            intent.putExtra("FBMI", bmiFormat2f)
            startActivity(intent)
        }

        fun moveResultActivity3() {
            val intent = Intent(this, ResultActivity3::class.java)
            intent.putExtra("FBMI", bmiFormat2f)
            startActivity(intent)
        }

        fun moveResultActivity4() {
            val intent = Intent(this, ResultActivity4::class.java)
            intent.putExtra("FBMI", bmiFormat2f)
            startActivity(intent)
        }

        fun moveResultActivity5() {
            val intent = Intent(this, ResultActivity5::class.java)
            intent.putExtra("FBMI", bmiFormat2f)
            startActivity(intent)
        }

        fun moveResultActivity6() {
            val intent = Intent(this, ResultActivity6::class.java)
            intent.putExtra("FBMI", bmiFormat2f)
            startActivity(intent)
        }

        fun moveResultActivity7() {
            val intent = Intent(this, ResultActivity7::class.java)
            intent.putExtra("FBMI", bmiFormat2f)
            startActivity(intent)
        }

        fun moveResultActivity8() {
            val intent = Intent(this, ResultActivity8::class.java)
            intent.putExtra("FBMI", bmiFormat2f)
            startActivity(intent)
        }

        fun moveResultActivity9() {
            val intent = Intent(this, ResultActivity9::class.java)
            intent.putExtra("FBMI", bmiFormat2f)
            startActivity(intent)
        }


        // bmi 계산
        fun bmiCalc() {
            try {
                val c1 = 0.7062
                val c2 = 0.9156
                val bodyMeasure : Float = mBinding.etBodyMeasure.text.toString().toFloat()
                val legMeasure : Float = mBinding.etLegMeasure.text.toString().toFloat()

                bmiResult = ((((bodyMeasure / c1) - legMeasure) / c2) - legMeasure)

                // 소숫점 2자리만 표시
                bmiFormat2f = String.format("%.2f", bmiResult)
                Toast.makeText(this, "결과는 $bmiFormat2f 입니다.", Toast.LENGTH_SHORT).show()

                // bmiResult에 따라서 Activity 이동
                when (bmiResult) {
                    in -1000.0..-11.0027229337 -> moveResultActivity1() // 심각한 저체중
                    in -11.0027229336..-0.4515191478 -> moveResultActivity2() // 저체중
                    in -0.4515191477..10.0093808085 -> moveResultActivity3() // 마름
                    in 10.0093808086..19.9284577874 -> moveResultActivity4() // 정상
                    in 19.9284577875..29.5690273220 -> moveResultActivity5() // 정상
                    in 29.5690273221..42.9424376913 -> moveResultActivity6() // 통통
                    in 42.9424376914..54.3139718989 -> moveResultActivity7() // 과체중
                    in 54.3139718990..66.6864441873 -> moveResultActivity8() // 비만
                    in 66.6864441874..1000.0 -> moveResultActivity9() // 심각한 비만
                }
            }catch (e: Exception){
                Toast.makeText(this, "값을 입력 해 주세요", Toast.LENGTH_SHORT).show()
            }
        }

        // 계산하기 버튼 눌렀을 때 bmiCalc 계산
        mBinding.calcBtn.setOnClickListener {
            bmiCalc()
        }

        // 몸둘레 help 버튼 눌렀을 때
        mBinding.bodyMeasureHelp.setOnClickListener {
            // Dialog 만들기
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.bodypopup, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("몸둘레 측정")
            mBuilder.show()
            }

        // 다리길이 help 버튼 눌렀을 때
        mBinding.legMeasureHelp.setOnClickListener {
            // Dialog 만들기
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.legpopup, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("다리길이 측정")
            mBuilder.show()
        }

        // 계산식 help 버튼 눌렀을 때
        mBinding.formulaHelp.setOnClickListener {
            // Dialog 만들기
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.formulapopup, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("계산 방법")
            mBuilder.show()
        }
    }
}
