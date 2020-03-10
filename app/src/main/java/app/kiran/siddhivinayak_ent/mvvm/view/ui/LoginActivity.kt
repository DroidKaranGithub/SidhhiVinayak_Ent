package app.kiran.siddhivinayak_ent.mvvm.view.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.databinding.DataBindingUtil
import app.kiran.siddhivinayak_ent.R
import app.kiran.siddhivinayak_ent.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity(), View.OnClickListener {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        initUi()
    }

    override fun initUi() {
        binding.btnLogin.setOnClickListener(this)
    }

    override fun getContext(): Context? {
        return this
    }

    override fun getLayoutId(): View? {
        return binding.root
    }

    fun isValid(): Boolean {
        var isError = false
        binding.inputEmail.isErrorEnabled = false
        binding.inputPassword.isErrorEnabled = false
        if (binding.edtEmail.text.toString().isEmpty()) {
            binding.inputEmail.isErrorEnabled = true
            binding.inputEmail.error = getString(R.string.error_enter_email)
            binding.inputEmail.requestFocus()
            isError = true
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.edtEmail.text.toString()).matches()) {
            binding.inputEmail.isErrorEnabled = true
            binding.inputEmail.error = getString(R.string.error_enter_valid_email)
            binding.inputEmail.requestFocus()
            isError = true
        } else if (binding.edtPassword.text.toString().isEmpty()) {
            binding.inputPassword.isErrorEnabled = true
            binding.inputPassword.error = getString(R.string.error_enter_password)
            binding.inputPassword.requestFocus()
            isError = true
        } else if (binding.edtPassword.text.toString().length < 6) {
            binding.inputPassword.isErrorEnabled = true
            binding.inputPassword.error = getString(R.string.error_enter_password_long)
            binding.inputPassword.requestFocus()
            isError = true
        }
        return isError
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnLogin -> {
//                if (!isValid()) {
                    val Intent = Intent(this, HomeActivity::class.java)
                    startActivity(Intent)
//                }
            }
        }
    }
}
