package kz.example.tobacco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import android.R.menu
import android.view.Menu
import android.view.MenuInflater



class MainActivity : AppCompatActivity() {

    //region Vars
    private var navController: NavController? = null
    //endregion

    //region Overriden methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()
        setupNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
    //endregion

    //region Support
    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.title = "JTI tobacco"
        toolbar.navigationIcon = ContextCompat.getDrawable(applicationContext, R.drawable.ic_menu_black_24dp)
    }

    private fun setupNavigation() {
        navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
        navController?.let {

            NavigationUI.setupWithNavController(nvMain, it)

            nvMain.setNavigationItemSelectedListener(object: NavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                    menuItem.isChecked = true
                    mainDrawerLayout.closeDrawers()

                    when (menuItem.itemId) {
                        R.id.first -> it.navigate(R.id.firstFragment)

                        R.id.second -> it.navigate(R.id.secondFragment)

                        R.id.third -> it.navigate(R.id.thirdFragment)
                    }
                    return true
                }
            })
        }

    }
    //endregion
}
