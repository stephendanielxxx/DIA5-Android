package app.training.android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import app.training.android.databinding.ActivityHomeBinding
import app.training.android.fragment.HomeFragment
import app.training.android.fragment.NewsFragment
import app.training.android.fragment.ProductFragment
import app.training.android.fragment.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeItem -> {
                    showFragment(HomeFragment.newInstance("", ""), R.id.container)
                    true
                }
                R.id.newsItem -> {
                    showFragment(NewsFragment.newInstance("", ""), R.id.container)
                    true
                }
                R.id.productItem -> {
                    showFragment(ProductFragment(), R.id.container)
                    true
                }
                R.id.profileItem -> {
                    showFragment(ProfileFragment.newInstance("", ""), R.id.container)
                    true
                }
                else -> false
            }
        }

        binding.bottomNav.selectedItemId = R.id.homeItem
//        showFragment(HomeFragment.newInstance("", ""), R.id.container)
    }

    private fun showFragment(fragment: Fragment, containerId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }
}