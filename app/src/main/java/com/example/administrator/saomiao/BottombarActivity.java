package com.example.administrator.saomiao;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class BottombarActivity extends AppCompatActivity {
    public Toast toast;
    public FirstFragment firstFragment;
    public SecondFragment secondFragment;
    public ThridFragment thridFragment;
    public FourFragment fourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottombar);
        firstFragment=new FirstFragment();
        secondFragment=new SecondFragment();
        thridFragment=new ThridFragment();
        fourFragment=new FourFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container,firstFragment,"first")
                .add(R.id.fragment_container,secondFragment,"second")
                .add(R.id.fragment_container,thridFragment,"thrid")
                .add(R.id.fragment_container,fourFragment,"four")
                .hide(secondFragment).hide(thridFragment).hide(fourFragment).show(firstFragment).commit();

        BottomBar bottomBar=(BottomBar)findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {



                switch (tabId) {
                    case R.id.tab1:
                        Toast.makeText(BottombarActivity.this,"我是第一块",Toast.LENGTH_SHORT).show();

                        getSupportFragmentManager().beginTransaction()
                                .hide(secondFragment).hide(thridFragment).hide(fourFragment).show(firstFragment).commit();
                        break;
                    case R.id.tab2:
                        Toast.makeText(BottombarActivity.this,"我是第二块",Toast.LENGTH_SHORT).show();

                        getSupportFragmentManager().beginTransaction().show(secondFragment).hide(thridFragment).hide(fourFragment).hide(firstFragment).commit();
                        break;
                    case R.id.tab3:
                        Toast.makeText(BottombarActivity.this,"我是第三块",Toast.LENGTH_SHORT).show();

                        getSupportFragmentManager().beginTransaction().hide(secondFragment).show(thridFragment).hide(fourFragment).hide(firstFragment).commit();
                        break;
                    case R.id.tab4:
                        Toast.makeText(BottombarActivity.this,"我是第四块",Toast.LENGTH_SHORT).show();

                        getSupportFragmentManager().beginTransaction().hide(secondFragment).hide(thridFragment).show(fourFragment).hide(firstFragment).commit();
                        break;
                }
            }
        });


        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {

            @Override
            public void onTabReSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab1:
                        Toast.makeText(BottombarActivity.this,"再次点击第一块",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .hide(secondFragment).hide(thridFragment).hide(fourFragment).show(firstFragment).commit();
                        break;
                    case R.id.tab2:
                        Toast.makeText(BottombarActivity.this,"再次点击第二块",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .show(secondFragment).hide(thridFragment).hide(fourFragment).hide(firstFragment).commit();
                        break;
                    case R.id.tab3:
                        Toast.makeText(BottombarActivity.this,"再次点击第三块",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .hide(secondFragment).show(thridFragment).hide(fourFragment).hide(firstFragment).commit();
                        break;
                    case R.id.tab4:
                        Toast.makeText(BottombarActivity.this,"再次点击第四块",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .hide(secondFragment).hide(thridFragment).show(fourFragment).hide(firstFragment).commit();
                        break;
                }
            }
        });

    }
}
