package com.example.offenseapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.offenseapp.R
import com.example.offenseapp.ui.insultscreen.InsultListFragment
import com.example.offenseapp.ui.mainscreen.RootFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState==null){
            //supportFragmentManager.beginTransaction().add(R.id.fragmentHolder, RootFragment.newInstance()).commit()
            supportFragmentManager.commit {
                replace(R.id.fragmentHolder,RootFragment.newInstance())
                addToBackStack(null)
            }
        }

    }
}