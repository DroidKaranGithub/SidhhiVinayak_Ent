package app.kiran.siddhivinayak_ent.mvvm.view.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.databinding.DataBindingUtil
import app.kiran.siddhivinayak_ent.R
import app.kiran.siddhivinayak_ent.databinding.ActivityMainBinding

class SplashActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        initUi()
    }

    override fun initUi() {

        Handler().postDelayed({
            val Intent = Intent(this, LoginActivity::class.java)
            startActivity(Intent)
            finish()
        }, 2000)
    }

    override fun getContext(): Context? {
        return this
    }

    override fun getLayoutId(): View? {
        return binding.root
    }
}
