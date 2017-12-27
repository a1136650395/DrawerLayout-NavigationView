package com.example.administrator.drawerLayout

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDrawerLayout()
    }
    /**
    联动toolbar和DrawerLayout，设置抽屉内点击事件
    **/
    private fun initDrawerLayout() {
        //toolbar增加开启抽屉按钮
        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        //抽屉内按钮点击事件
        navigationView.setNavigationItemSelectedListener { item ->
            val itemId = item.itemId
            Toast.makeText(this@MainActivity, itemId.toString(), Toast.LENGTH_SHORT).show()
            //点击MenuItem后关闭抽屉
            //drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        //如果抽屉是开启状态要先关闭再退出activity
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }
}
