package com.example.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText username, password;
    private ImageView imV;
    private Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitView();
        setImage();
        btn_Click();
    }

    private void btn_Click() {
        btn_go.setOnClickListener(v -> {
            if (password.getText().toString().length() > 6 && username.getText().toString().length() > 1) {
                Intent intent = new Intent(MainActivity.this, com.example.hw1.SecondActivity.class);
                intent.putExtra("password",password.getText().toString() );
                intent.putExtra("username", username.getText().toString());
                startActivity(intent);
            }else if (password.getText().toString().isEmpty() && username.getText().toString().isEmpty()){
                username.setError(getString(R.string.username_equals_null));
                password.setError(getString(R.string.password_equals_null));
            } else if (password.getText().toString().length() < 6 ) {
                password.setError(getString(R.string.password_smaller_6));
            } else if (username.getText().toString().length() < 1) {
                username.setError(getString(R.string.you_forgot_username));
            }
        });
    }

    private void setImage() {
        Glide.with(this).load(getString(R.string.ic_pinimg)).into(imV);
    }

    private void setInitView() {
        username = findViewById(R.id.username_Input_Edit_Text);
        password = findViewById(R.id.password_Input_Edit_Text);
        imV = findViewById(R.id.im_car);
        btn_go = findViewById(R.id.go);
    }


}