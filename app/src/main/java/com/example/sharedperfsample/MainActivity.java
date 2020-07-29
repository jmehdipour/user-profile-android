package com.example.sharedperfsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private UserManager userManager;
    private String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userManager = new UserManager(this);

        final TextInputEditText fullNameEt = findViewById(R.id.et_main_fullName);
        fullNameEt.setText(userManager.getFullName());
        final TextInputEditText emailEt = findViewById(R.id.et_main_email);
        emailEt.setText(userManager.getEmail());
        gender = userManager.getGender();
        RadioGroup genderRadioGroup = findViewById(R.id.radioGroup_main_gender);

        if (gender.equalsIgnoreCase("male")){
            genderRadioGroup.check(R.id.radioBtn_main_male);
        }else if (gender.equalsIgnoreCase("female")){
            genderRadioGroup.check(R.id.radioBtn_main_female);
        }

        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioBtn_main_male){
                    gender = "male";
                }else{
                    gender = "female";
                }
            }
        });
        View saveBtn = findViewById(R.id.btn_main_save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userManager.saveUserInformation(fullNameEt.getText().toString(),
                        emailEt.getText().toString(),
                        gender);
                Toast.makeText(MainActivity.this, "اطلاعات کاربر ثبت شد.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}