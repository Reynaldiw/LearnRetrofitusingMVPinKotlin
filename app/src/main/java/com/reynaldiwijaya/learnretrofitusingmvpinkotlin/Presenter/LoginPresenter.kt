package com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Presenter

import com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Model.LoginBody
import com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Model.ResponseLogin
import com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter (model: LoginContract.View) : LoginContract.Presenter {

    var view : LoginContract.View? = null
    init {
        view = model
    }

    override fun getData(username: String, password: String) {
        if(username == null || username.isEmpty()){
            view?.showFailureMessage("Field tidak boleh kosong")
            return
        }
        if (password == null || password.isEmpty()) {
            view?.showFailureMessage("Field tidak boleh kosong")
            return
        }

        view?.showProgress()

        val loginBody = LoginBody(username, password)

        val doLogin = ApiInterface.create()
        doLogin.doLogin(loginBody).enqueue(object : Callback<ResponseLogin> {

            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                view?.hideProgress()

                    if (response.body() != null) {

                        var responseLogin : ResponseLogin? = response.body()

                        if (responseLogin?.token != null) {

                            view?.showSuccesMessage("Login Berhasil")
                        }

                    } else {
                        view?.showFailureMessage(response.message())
                    }
                }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                view?.hideProgress()
                view?.showFailureMessage(t.message.toString())
            }

        } )
    }
}