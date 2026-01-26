package com.cmtaro.app.hitandblowgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cmtaro.app.hitandblowgame.databinding.ActivityMenuBinding
import com.cmtaro.app.hitandblowgame.ui.game.GameActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    // 隠しモード用の変数
    private var logoClickCount = 0
    private var isCardModeEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 初期状態ではカードモードボタンを隠しておく
        binding.buttonStartCardMode.visibility = View.GONE

        // ロゴをタップした時の処理（隠しコマンド）
        binding.textLogo.setOnClickListener {
            logoClickCount++

            // 5回以上タップで解禁
            if (logoClickCount >= 5 && !isCardModeEnabled) {
                isCardModeEnabled = true
                binding.buttonStartCardMode.visibility = View.VISIBLE
                Toast.makeText(this, "裏モード：CARD BATTLE 解禁！", Toast.LENGTH_SHORT).show()
            }
        }

        // 3桁モードボタン
        binding.buttonStart3Digit.setOnClickListener {
            startGame(3, false)
        }

        // 4桁モードボタン
        binding.buttonStart4Digit.setOnClickListener {
            startGame(4, false)
        }

        // カードバトルモードボタン（隠し）
        binding.buttonStartCardMode.setOnClickListener {
            // カードモードはルールに基づき3桁固定
            startGame(3, true)
        }
    }

    /**
     * ゲーム画面へ遷移
     * @param digit 桁数
     * @param isCardMode カードモードかどうか
     */
    private fun startGame(digit: Int, isCardMode: Boolean) {
        val intent = Intent(this, GameActivity::class.java).apply {
            putExtra("DIGIT_COUNT", digit)
            putExtra("IS_CARD_MODE", isCardMode)
        }
        startActivity(intent)
    }
}