package com.reynaldiwijaya.learnretrofitusingmvpinkotlin.View

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Presenter.LoginContract
import com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Presenter.LoginPresenter
import com.reynaldiwijaya.learnretrofitusingmvpinkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginContract.View {
    var progressDialog : ProgressDialog? = null
    lateinit var loginPresenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginPresenter = LoginPresenter(this)

        btn_login.setOnClickListener {
            loginPresenter.getData(edt_username.text.toString(), edt_password.text.toString())
        }
    }

    override fun showProgress() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog?.setMessage("Loading")
            progressDialog?.setCancelable(false)
            progressDialog?.show()
        }
    }

    override fun hideProgress() {
        if (progressDialog?.isShowing!!) {
            progressDialog?.dismiss()
        }
    }

    override fun showFailureMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccesMessage(succes: String) {
        Toast.makeText(this, succes, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, SecondActivity::class.java))
        finish()
    }

}
