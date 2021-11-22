package com.bikmim.cat_body

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.bikmim.cat_body.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var sBinding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(sBinding.root)

        // 시작 버튼 눌렸을 때 popup 실행
        sBinding.splashStartBtn.setOnClickListener {
            // Dialog 만들기
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.readme, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("주의 사항")
            val intent = Intent(this, MainActivity::class.java)

            mBuilder.apply {
                setPositiveButton("예",
                    DialogInterface.OnClickListener { dialog, id ->
                        startActivity(intent)
                    })
                setNegativeButton("아니오",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
                mBuilder.show()
            }
        }
    }
}