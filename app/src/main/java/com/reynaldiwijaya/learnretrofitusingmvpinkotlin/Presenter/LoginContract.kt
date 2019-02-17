package com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Presenter

interface LoginContract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun showFailureMessage(error: String)
        fun showSuccesMessage(succes: String)
    }
    interface Presenter {
        fun getData(username: String, password: String)
    }
}