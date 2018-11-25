package com.example.nitza.file;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    String s;
    TextView tv;
    EditText et;
    InputStream is;
    String file = "file.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.tv);
        et=(EditText) findViewById(R.id.et); }



    public void in(View view) {
        s=et.getText().toString();
        try {
            FileOutputStream f=openFileOutput(file,Context.MODE_PRIVATE);
            OutputStreamWriter o=new OutputStreamWriter(f);
            BufferedWriter bw=new BufferedWriter(o);
            bw.write(s);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void out(View view) {
        try {
            is = openFileInput(file);
            InputStreamReader t=new InputStreamReader(is);
            BufferedReader r=new BufferedReader(t);
            StringBuffer b=new StringBuffer();
            while ((s=r.readLine())!=null)
                b.append(s+"\n");
            is.close();
            tv.setText(b);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
