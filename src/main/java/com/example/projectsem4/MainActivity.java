package com.example.projectsem4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view){


        Toast.makeText( this,"Smile",Toast.LENGTH_SHORT).show();

        Intent i=new Intent(this,MainActivity2.class);
        startActivity(i);

    }

}