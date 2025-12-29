package app.training.android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import app.training.android.fragment.NewsCountFragment
import app.training.android.fragment.NewsHeaderFragment

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val newsHeaderFragment = NewsHeaderFragment.newInstance(
            "Headline News Hari Ini",
            "Telkomsel & Komdigi Perkuat Kolaborasi Bantu Pemulihan Korban Bencana Aceh"
        )
        showFragment(newsHeaderFragment, R.id.flHeader)

        val downloadFragment = NewsCountFragment.newInstance("Total Download", "10x")
        showFragment(downloadFragment, R.id.flNews1)

        val totalViewFragment = NewsCountFragment.newInstance("Total View", "50x")
        showFragment(totalViewFragment, R.id.flNews2)
    }

    private fun showFragment(fragment: Fragment, containerId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }
}