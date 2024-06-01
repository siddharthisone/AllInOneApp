package com.project.blackcoffer


import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.project.blackcoffer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

      private  var socialMediasLinks = arrayListOf("https://www.twitter.com",
             "https://www.instagram.com",
             "https://www.linkedin.com","https://www.facebook.com","https://www.youtube.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            if (networkInfo == null || !networkInfo.isConnectedOrConnecting) {
                Toast.makeText(this,"No Internet Connection",Toast.LENGTH_LONG).show()
            }

        binding.instagramIcon.setOnClickListener {
            sendIntent(this,socialMediasLinks[1])
        }
        binding.instagramCard.setOnClickListener{
            sendIntent(this,socialMediasLinks[1])
        }

        binding.twitterCard.setOnClickListener {
            sendIntent(this,socialMediasLinks[0])

        }
        binding.twitter.setOnClickListener {
            sendIntent(this,socialMediasLinks[0])
        }

        binding.linkedInCard.setOnClickListener {
           sendIntent(this,socialMediasLinks[2])

        }
        binding.linkedInIcon.setOnClickListener {
            sendIntent(this,socialMediasLinks[2])
        }

        binding.faceBookCard.setOnClickListener {
            sendIntent(this,socialMediasLinks[3])

        }
        binding.faceBookIcon.setOnClickListener {
            sendIntent(this,socialMediasLinks[3])

        }

        binding.youtubeCard.setOnClickListener {
            sendIntent(this,socialMediasLinks[4])
        }
        binding.youtube.setOnClickListener {
            sendIntent(this,socialMediasLinks[4])
        }
    }

    private fun sendIntent(context: Context, url: String)
    {
        val intent = Intent(context,WebActivity::class.java)
        intent.putExtra("socialMediaUrl",url)
        startActivity(intent)
    }
}