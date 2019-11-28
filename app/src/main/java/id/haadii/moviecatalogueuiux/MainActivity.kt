package id.haadii.moviecatalogueuiux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.haadii.moviecatalogueuiux.movie.MovieFragment
import id.haadii.moviecatalogueuiux.tv_show.TvShowFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener())
        bottomNavigation.selectedItemId = R.id.movie
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val intent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigationItemSelectedListener() : BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.movie -> {
                    val fragment = MovieFragment()
                    openFragment(fragment)
                    title = resources.getString(R.string.menu_movie)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.tv_show -> {
                    val fragment = TvShowFragment()
                    openFragment(fragment)
                    title = resources.getString(R.string.menu_tv_show)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contentFrame, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
