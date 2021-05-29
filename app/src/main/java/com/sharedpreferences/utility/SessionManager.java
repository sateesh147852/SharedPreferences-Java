package com.sharedpreferences.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static SessionManager sessionManager;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context){
        sharedPreferences = context.getSharedPreferences("MyPreferences",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public static SessionManager getInstance(Context context){
        if (sessionManager == null){
            sessionManager = new SessionManager(context);
        }
        return sessionManager;
    }

    public void setUserName(Long userName){
        editor.putLong("userName",userName);
        editor.apply();
    }

    public long getUserName(){
        return sharedPreferences.getLong("userName",0);
    }

    public void setPassword(String password){
        editor.putString("password",password);
        editor.apply();
    }

    public String getPassword(){
        return sharedPreferences.getString("password","");
    }

}
