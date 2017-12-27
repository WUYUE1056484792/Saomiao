package com.example.administrator.saomiao;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.saomiao.utils.QRCodeUtil;

public class ErweimaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erweima);

        Button get=(Button)findViewById(R.id.get);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit=(EditText)findViewById(R.id.edit);

                Bitmap bitmap=QRCodeUtil.encodeAsBitmap(edit.getText().toString());
                ImageView imageView=(ImageView)findViewById(R.id.erweima);
                imageView.setImageBitmap(bitmap);
            }
        });
    }
}
