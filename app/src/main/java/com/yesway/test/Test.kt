package com.yesway.test

import android.view.View

class Test {
    fun test(){
        val view: View = null
        view?.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                TODO("Not yet implemented")
            }

        })
    }
}