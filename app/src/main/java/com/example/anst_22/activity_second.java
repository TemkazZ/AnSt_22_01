package com.example.anst_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.anst_22.MainActivity;

//public class activity_second extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        TextView textView = new TextView(this);
//        textView.setTextSize(26);
//        textView.setPadding(16, 16, 16, 16);
//
//        Bundle arguments = getIntent().getExtras();
//
//        if (arguments != null) {
//            String name = arguments.get("name").toString();
//            String company = arguments.getString("company");
//            int age = arguments.getInt("age");
//            textView.setText("Name: " + name + "\nCompany: " + company +
//                    "\nAge: " + age);
//        }
//
//        setContentView(textView);
//    }
//}


public class activity_second extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView ageView = (TextView) findViewById(R.id.ageView);
            String age = extras.getString(MainActivity.AGE_KEY);
            ageView.setText("Возраст: " +  age);
        }
    }
    public void onCancelClick(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }
    public void onButton1Click(View v) {
        sendMessage("Доступ разрешен");
    }
    public void onButton2Click(View v) {
        sendMessage("Доступ запрещен");
    }
    public void onButton3Click(View v) {
        sendMessage("Недопустимый возраст");
    }
    private void sendMessage(String message){

        Intent data = new Intent();
        data.putExtra(MainActivity.ACCESS_MESSAGE, message);
        setResult(RESULT_OK, data);
        finish();
    }
}