package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        WebView  myWebView = (WebView) findViewById(R.id.web_view);
        //得到 MainActivity的隐式Intent的data，用Extra方式存放
        String url=getIntent().getExtras().getString("url");
        //启用支持JavaScript
        myWebView.getSettings().setJavaScriptEnabled(true);
        //在myWebView加载网页，用loadURL()
        myWebView.loadUrl(url);
    }

}
