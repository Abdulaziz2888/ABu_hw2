package com.example.abu_hw2.mvp

import com.example.abu_hw2.data.LoveResult

interface LoveContract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun showResult(loveResult: LoveResult)
        fun showError(error: String)
    }

    interface Model {
        fun getLovePercentage(
            firstName: String,
            secondName: String,
            callback: (result: LoveResult?, error: String?) -> Unit
        )
    }

    interface Presenter {
        fun calculateLovePercentage(firstName: String, secondName: String)
    }
}