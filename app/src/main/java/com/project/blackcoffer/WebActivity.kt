package com.project.blackcoffer

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class WebActivity : AppCompatActivity() {
    private lateinit var webView:WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting) {
            Toast.makeText(this,"No Internet Connection", Toast.LENGTH_LONG).show()
        }

        val url  = intent.getStringExtra("socialMediaUrl")

         webView = findViewById(R.id.web)
        webView.settings.javaScriptEnabled=true
        webView.settings.loadsImagesAutomatically = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowContentAccess = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = true

        webView.webViewClient = object : WebViewClient()
        {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }
        url?.let { webView.loadUrl(it) }

    }

    override fun onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack()
        }
        else{
            super.onBackPressed()
        }
    }
}