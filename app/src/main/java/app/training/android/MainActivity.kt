package app.training.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.training.android.databinding.ActivityMainBinding
import app.training.android.utils.SharedPrefHelper
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(binding.root.paddingLeft, systemBars.top, binding.root.paddingRight, systemBars.bottom)
            insets
        }

        Toast.makeText(baseContext, "On Create", Toast.LENGTH_SHORT).show()
        Log.i("MainActivity", "On Create")

        binding.tvHelloWorld.text = "Welcome, Stephen !!!"

        binding.btnOpenLink.setOnClickListener {
            //implicit intent
            val link = binding.etLink.text.toString()
            if(link.contains("http://") || link.contains("https://")){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(intent)
            }else{
                Toast.makeText(baseContext, "Invalid link", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSecond.setOnClickListener {
            //explicit intent
            val secondIntent = Intent(this, SecondActivity::class.java)
            secondIntent.putExtra("phone", "123456")
            startActivity(secondIntent)
        }

        binding.ivProfile.setImageResource(R.drawable.dani)

        binding.cbAgree.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                Toast.makeText(baseContext, "Agree",
                    Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(baseContext, "Disagree",
                    Toast.LENGTH_SHORT).show()
            }
        }

        binding.rgCarBrand.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.rbHonda -> {
                    binding.tvCarBrand.text = "Select car brand : Honda"
                }
                R.id.rbToyota -> {
                    binding.tvCarBrand.text = "Select car brand : Toyota"
                }
                R.id.rbSuzuki -> {
                    binding.tvCarBrand.text = "Select car brand : Suzuki"
                }
            }
        }

        binding.tbOnOff.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                Toast.makeText(baseContext, "On", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(baseContext, "Off", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSnackBar.setOnClickListener { view ->
            val snackbar = Snackbar.make(
                view, "This is a snackbar", Snackbar.LENGTH_SHORT
            )
            snackbar.setAction("Retry"){
                Toast.makeText(baseContext, "Retry",
                    Toast.LENGTH_SHORT).show()
            }
            snackbar.show()
        }

        binding.btnNews.setOnClickListener {
            val newsIntent = Intent(this, NewsActivity::class.java)
            startActivity(newsIntent)
        }

        binding.btnHome.setOnClickListener {
            val homeIntent = Intent(this, HomeActivity::class.java)
            startActivity(homeIntent)
        }

        SharedPrefHelper(this).saveString("userName", "Stephen")
        //DataStore
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(baseContext, "On Start", Toast.LENGTH_SHORT).show()
        Log.i("MainActivity", "On Start")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(baseContext, "On Resume", Toast.LENGTH_SHORT).show()
        Log.i("MainActivity", "On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "On Destroy")
    }

}