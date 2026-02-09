package com.cmtaro.app.hitandblowgame.ui.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cmtaro.app.hitandblowgame.R

// 履歴画面（簡易実装）
class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // シンプルにレイアウトを表示するだけのActivity
        setContentView(R.layout.activity_history)
    }
}

