package com.example.sharedperfsample;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedPreferences;

    public UserManager(Context context){
        sharedPreferences = context.getSharedPreferences("user_information", Context.MODE_PRIVATE);
        sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

            }
        });

        //sharedPreferences.unregisterOnSharedPreferenceChangeListener();

    }

    public void saveUserInformation(String fullName, String email, String gender){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("full_name", fullName);
        editor.putString("email", email);
        editor.putString("gender", gender);
        editor.apply();
    }

    public String getFullName(){
        return sharedPreferences.getString("full_name", "");
    }

    public String getEmail(){
        return sharedPreferences.getString("email", "");
    }

    public String getGender(){
        return sharedPreferences.getString("gender", "");
    }

    public void clearAllInformation(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void removeFullName(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("full_name");
        editor.apply();
    }
}
