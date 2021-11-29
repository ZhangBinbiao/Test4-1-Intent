# Test4-1-Intent
在AndroidManifest.xml中添加

    <uses-permission android:name="android.permission.INTERNET" />
和

    <activity android:name=".WebViewActivity"></activity>
创建Web_view.xml

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <WebView
            android:id="@+id/web_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            />

    </androidx.constraintlayout.widget.ConstraintLayout>
创建WebViewActivity.java

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
修改activity_main.xml

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/editText"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintBottom_toTopOf="@id/bn" />
        <Button
            android:id="@+id/bn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="打开浏览器"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

    </androidx.constraintlayout.widget.ConstraintLayout>
修改MainActivity.java

    package com.example.intent;

    import androidx.appcompat.app.AppCompatActivity;
    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.webkit.WebSettings;
    import android.webkit.WebView;
    import android.webkit.WebViewClient;
    import android.os.Bundle;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button bn = findViewById(R.id.bn);
            final EditText editText =findViewById(R.id.editText);

            //为bn按钮添加一个监听器
            bn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //创建Intent
                    Intent intent = new Intent();
                    //获取editText中输入的数据
                    String data=editText.getText().toString();
                    //根据指定字符串解析出Uri对象
                    Uri uri = Uri.parse(data);
                    //为Intent设置Action属性
                    intent.setAction(Intent.ACTION_VIEW);
                    //为Intent设置Category属性
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    //设置Data属性
                    intent.setData(uri);
                    //启动Activity
                    startActivity(intent);
                }
            });
        }
    }
实验截图：

![图片](https://user-images.githubusercontent.com/90604287/143874580-a26765c6-816f-4e83-a333-85152298dae2.png)
![图片](https://user-images.githubusercontent.com/90604287/143874624-97f6001f-4d61-46fa-bd2b-03b9699567c9.png)

![图片](https://user-images.githubusercontent.com/90604287/143874591-524b7ad8-9221-495f-80b7-4b4ec69c4899.png)

