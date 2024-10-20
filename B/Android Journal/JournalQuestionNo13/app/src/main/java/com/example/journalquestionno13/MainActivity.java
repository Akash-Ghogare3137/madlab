package com.example.journalquestionno13;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the WebView
        webView = findViewById(R.id.webview);

        // Enable JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Make sure links and redirects open in the WebView instead of a browser
        webView.setWebViewClient(new WebViewClient());

        // Load the URL
        webView.loadUrl("https://imcc.mespune.in/home/");

    }

    // Handle back button press to navigate backward in the WebView history
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack(); // Go to previous page if possible
        } else {
            super.onBackPressed(); // Otherwise, exit the app
        }
    }
}