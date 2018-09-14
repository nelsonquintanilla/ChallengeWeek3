package com.applaudostudios.tourguideappchallenge;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class WebViewActivity extends AppCompatActivity {

    // Method that is implemented in each fragment to pass in the context and place
    public static Intent getInstance(Context context, String website_string){
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("view_url", website_string);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView myWebView = new WebView(this);
        setContentView(myWebView);
        String url = getIntent().getStringExtra("view_url");

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        
        myWebView.loadUrl(url);
    }
}
