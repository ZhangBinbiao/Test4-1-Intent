package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
