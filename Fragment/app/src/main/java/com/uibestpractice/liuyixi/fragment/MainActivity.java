package com.uibestpractice.liuyixi.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        //动态添加Fragment
        replaceFragment(new RightFragment());
    }

    //给左侧按钮注册点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    //动态添加Fragment的步骤
//1:创建待添加的碎片实例(AnotherRightFragment)
//2:获取FragmentManager,在Activity中可以直接使用getSupportFragmentManager()方法得到
//3:开启一个FragmentTransaction ,通过beginTransaction开启
//4:向transaction中添加或替换Fragment,一般使用replace方法，需参数1容器id,参数2Fragment对象实例
//5:调用commit()方法来完成。
    private void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.right_layout,fragment);

        //如果在事物提交前调用了FragmentTransaction 的addToBackStack(),它可以接收一个名字用于描述返回栈的状态，一般传入null即可
        //addToBackStack用于将一个事物添加到返回栈
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
