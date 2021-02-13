package com.example.anst_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_second);
//        TextView textView = new TextView(this);
//        textView.setTextSize(20);
//        textView.setPadding(16, 16, 16, 16);
//        textView.setText("SecondActivity");
//        setContentView(R.layout.activity_main);
//
//    }
//    public void onClick(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
//    public void onClick2(View v) {
//
//        EditText nameText = findViewById(R.id.name);
//        EditText companyText = findViewById(R.id.company);
//        EditText ageText = findViewById(R.id.age);
//
//        String name = nameText.getText().toString();
//        String company = companyText.getText().toString();
//        int age = Integer.parseInt(ageText.getText().toString());
//
//        Intent intent = new Intent(this, activity_second.class);
//        intent.putExtra("name", name);
//        intent.putExtra("company", company);
//        intent.putExtra("age", age);
//        startActivity(intent);
//    }





    static final String AGE_KEY = "AGE";
    static final String ACCESS_MESSAGE="ACCESS_MESSAGE";
    private static  final int REQUEST_ACCESS_TYPE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        // получаем введенный возраст
        EditText ageBox = (EditText) findViewById(R.id.age);
        String age = ageBox.getText().toString();

        Intent intent = new Intent(this, activity_second.class);
        intent.putExtra(AGE_KEY, age);
        startActivityForResult(intent, REQUEST_ACCESS_TYPE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        TextView textView = (TextView) findViewById(R.id.textView);
        if(requestCode==REQUEST_ACCESS_TYPE){
            if(resultCode==RESULT_OK){
                String accessMessage = data.getStringExtra(ACCESS_MESSAGE);
                textView.setText(accessMessage);
            }
            else{
                textView.setText("Ошибка доступа");
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}