package com.marco.pocandroidtvleanback

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.leanback.widget.BrowseFrameLayout
import com.marco.pocandroidtvleanback.databinding.ActivityMainBinding
import com.marco.pocandroidtvleanback.ui.GenresFragment
import com.marco.pocandroidtvleanback.ui.HomeFragment
import com.marco.pocandroidtvleanback.ui.LanguageFragment
import com.marco.pocandroidtvleanback.ui.MoviesFragment
import com.marco.pocandroidtvleanback.ui.SearchFragment
import com.marco.pocandroidtvleanback.ui.SettingsFragment
import com.marco.pocandroidtvleanback.ui.SportsFragment
import com.marco.pocandroidtvleanback.ui.TvShowFragment
import com.marco.pocandroidtvleanback.utils.Common
import com.marco.pocandroidtvleanback.utils.Constants

class MainActivity : FragmentActivity(), View.OnKeyListener, View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navBar: BrowseFrameLayout
    private lateinit var fragmentContainer: FrameLayout

    private var isSideMenuEnabled = false
    private var selectedMenu = Constants.Menu.MENU_HOME
    private lateinit var lastSelectedMenu: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navBar = binding.blfNavBar
        fragmentContainer = binding.container

        buttonsSetOnKeyListener()
        lastSelectedMenu = binding.btnHome
//        lastSelectedMenu = binding.btnSearch
        lastSelectedMenu.isActivated = true

        changeFragment(HomeFragment())
//        changeFragment(SearchFragment())
        switchToLastSelectedMenu()
    }

    override fun onClick(view: View?) {
        performActions(view)
    }

    private fun buttonsSetOnKeyListener() {
        binding.btnSearch.setOnKeyListener(this)
        binding.btnSearch.setOnClickListener(this)

        binding.btnHome.setOnKeyListener(this)
        binding.btnHome.setOnClickListener(this)

        binding.btnTv.setOnKeyListener(this)
        binding.btnTv.setOnClickListener(this)

        binding.btnMovies.setOnKeyListener(this)
        binding.btnMovies.setOnClickListener(this)

        binding.btnSports.setOnKeyListener(this)
        binding.btnSports.setOnClickListener(this)

        binding.btnSettings.setOnKeyListener(this)
        binding.btnSettings.setOnClickListener(this)

        binding.btnLanguage.setOnKeyListener(this)
        binding.btnLanguage.setOnClickListener(this)

        binding.btnGenre.setOnKeyListener(this)
        binding.btnGenre.setOnClickListener(this)
    }

    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
        closeMenu()
    }

    override fun onKey(view: View?, keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_CENTER -> {
                performActions(view)
            }

            KeyEvent.KEYCODE_DPAD_LEFT -> {
                if (!isSideMenuEnabled) {
                    switchToLastSelectedMenu()

                    openMenu()
                    isSideMenuEnabled = true
                }
            }

            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                closeMenu()
                isSideMenuEnabled = false
            }
        }
        return false
    }

    private fun performActions(view: View?) {
        lastSelectedMenu.isActivated = false
        view?.isActivated = true
        lastSelectedMenu = view!!

        when (view.id) {
            R.id.btn_search -> {
                selectedMenu = Constants.Menu.MENU_SEARCH
                changeFragment(SearchFragment())
            }

            R.id.btn_home -> {
                selectedMenu = Constants.Menu.MENU_HOME
                changeFragment(HomeFragment())
            }

            R.id.btn_tv -> {
                selectedMenu = Constants.Menu.MENU_TV
                changeFragment(TvShowFragment())
            }

            R.id.btn_movies -> {
                selectedMenu = Constants.Menu.MENU_MOVIE
                changeFragment(MoviesFragment())
            }

            R.id.btn_sports -> {
                selectedMenu = Constants.Menu.MENU_SPORTS
                changeFragment(SportsFragment())
            }

            R.id.btn_settings -> {
                selectedMenu = Constants.Menu.MENU_SETTINGS
                changeFragment(SettingsFragment())
            }

            R.id.btn_language -> {
                selectedMenu = Constants.Menu.MENU_LANGUAGE
                changeFragment(LanguageFragment())
            }

            R.id.btn_genre -> {
                selectedMenu = Constants.Menu.MENU_GENRES
                changeFragment(GenresFragment())
            }
        }
    }

    private fun switchToLastSelectedMenu() {
        when (selectedMenu) {
            Constants.Menu.MENU_SEARCH -> {
                binding.btnSearch.requestFocus()
            }

            Constants.Menu.MENU_HOME -> {
                binding.btnHome.requestFocus()
            }

            Constants.Menu.MENU_TV -> {
                binding.btnTv.requestFocus()
            }

            Constants.Menu.MENU_MOVIE -> {
                binding.btnMovies.requestFocus()
            }

            Constants.Menu.MENU_SPORTS -> {
                binding.btnSports.requestFocus()
            }

            Constants.Menu.MENU_LANGUAGE -> {
                binding.btnLanguage.requestFocus()
            }

            Constants.Menu.MENU_GENRES -> {
                binding.btnGenre.requestFocus()
            }

            Constants.Menu.MENU_SETTINGS -> {
                binding.btnSettings.requestFocus()
            }
        }
    }

    private fun openMenu() {
        val animSlide: Animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        navBar.startAnimation(animSlide)

        navBar.requestLayout()
        navBar.layoutParams.width = Common.getWidthInPercent(this, 16)
    }

    private fun closeMenu() {
        navBar.requestLayout()
        navBar.layoutParams.width = Common.getWidthInPercent(this, 5)

        fragmentContainer.requestFocus()
    }

}