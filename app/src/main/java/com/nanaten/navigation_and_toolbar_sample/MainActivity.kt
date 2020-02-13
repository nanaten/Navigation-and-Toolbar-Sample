package com.nanaten.navigation_and_toolbar_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_fourth.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Toolbarをセット
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.nav_host_fragment)
        // UpIconを表示しないFragmentを設定する
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment, R.id.secondFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            // ThirdFragmentのみToolbarを消す
            toolbar.visibility = if(destination.id == R.id.thirdFragment) View.GONE else View.VISIBLE
            // FirstFragmentのみロゴを表示させる
            toolbar.logo = if(destination.id == R.id.firstFragment) AppCompatResources.getDrawable(this, R.drawable.ic_android_24dp) else null
            // タイトルを設定する
            if(destination.id == R.id.fifthFragment) {
                supportActionBar?.title = arguments?.getString("title")
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.nav_host_fragment).navigateUp()

}
