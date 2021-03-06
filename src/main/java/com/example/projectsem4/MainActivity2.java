package com.example.projectsem4;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    private EditText textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textResult=findViewById(R.id.Search);
    }
    public void Speech(View view){
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);


        if (intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent,10);
        }
        else{
            Toast.makeText(this,"Error in speech input",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 10:
                Toast.makeText(this,"input",Toast.LENGTH_SHORT).show();
                if(resultCode==RESULT_OK && data!=null){
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textResult.setText(result.get(0));
                }
        }
    }
}