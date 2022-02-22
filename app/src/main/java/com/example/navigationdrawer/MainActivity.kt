package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity()  , NavigationView.OnNavigationItemSelectedListener{

    lateinit var homeFragment: HomeFragment
    lateinit var favouriteFragment: FavouriteFragment
    lateinit var deleteFragment: DeleteFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setSupportActionBar(id_ToolBar)
        val actionBar = supportActionBar
        actionBar?.title= "Navigation Drawer"
        val drawerToggle:ActionBarDrawerToggle = object :ActionBarDrawerToggle(
            this ,
            id_Drawer_Layout,
            id_ToolBar,
            (R.string.open),
            (R.string.close)
        ){

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        id_Drawer_Layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        id_Nav_View.setNavigationItemSelectedListener (this)
        //now implement navigation item selected item
        //the default fragment is home fragment
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.id_Frame_Layout,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
        //so this is my fragment code
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
    when(menuItem.itemId){
   R.id.home->{
       homeFragment = HomeFragment()
       supportFragmentManager.beginTransaction()
           .replace(R.id.id_Frame_Layout,homeFragment)
           .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
           .commit()
   }
        R.id.favourite->{
            favouriteFragment = FavouriteFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.id_Frame_Layout,favouriteFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
        R.id.delete->{
            deleteFragment = DeleteFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.id_Frame_Layout,deleteFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
    }
        id_Drawer_Layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(id_Drawer_Layout.isDrawerOpen(GravityCompat.START))
        {
           id_Drawer_Layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }

    }
}