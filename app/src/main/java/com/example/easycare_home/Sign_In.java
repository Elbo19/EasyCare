package com.example.easycare_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

public class Sign_In extends AppCompatActivity {

    EditText e1, e2, e3, e4;
    Button b1, b2;
    DatabaseHelper db;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.username);
        e2 = (EditText) findViewById(R.id.pass);
//        b1 = (Button) findViewById(R.id.register);
        b2 = (Button) findViewById(R.id.login);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkeusernamepass = db.usernamepassword(username, password);
                if (Chkeusernamepass == true) {
                    Toast.makeText(getApplicationContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

//
//    View view;
//    public Sign_In() {
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.sign_in, container,false);
//        return view;
//    }

    }
}
