package com.example.tann_mann_foundation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawerLayout=findViewById(R.id.draw)
        val view:NavigationView=findViewById(R.id.view)


        toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        view.setNavigationItemSelectedListener {
            it.isChecked=true
            when(it.itemId){
                R.id.about->replaceFragment(AboutFragment(),it.title.toString())
                R.id.solution->replaceFragment(SolutionFragment(),it.title.toString())
                R.id.events->replaceFragment(EventsFragment(),it.title.toString())
                R.id.talk->replaceFragment(TalkFragment(),it.title.toString())
                R.id.contact->replaceFragment(ContactFragment(),it.title.toString())




            }
            true
        }
    }

    private fun replaceFragment(fragment:Fragment,title:String){
        val fragmentManger=supportFragmentManager
        val fragmentTransaction=fragmentManger.beginTransaction()
        fragmentTransaction.replace(R.id.frame,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
            return super.onOptionsItemSelected(item)
    }
}


