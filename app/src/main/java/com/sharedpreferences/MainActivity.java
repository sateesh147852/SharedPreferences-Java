package com.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sharedpreferences.databinding.ActivityMainBinding;
import com.sharedpreferences.utility.SessionManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialize();
        setOnClickListener();
    }

    private void initialize(){
        sessionManager = SessionManager.getInstance(this);
    }

    private void setOnClickListener(){
        binding.btSave.setOnClickListener(this);
        binding.btGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btGet:
                Toast.makeText(this, sessionManager.getUserName() + " "+ sessionManager.getPassword(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.btSave:
                if (binding.etUserName.getText().toString().trim().isEmpty())
                    Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_SHORT).show();
                else if (binding.etPassword.getText().toString().trim().isEmpty())
                    Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
                else {
                    sessionManager.setUserName(Long.parseLong(binding.etUserName.getText().toString().trim()));
                    sessionManager.setPassword(binding.etPassword.getText().toString().trim());
                }
                break;
        }
    }
}