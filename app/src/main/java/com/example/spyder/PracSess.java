package com.example.spyder;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.sqrt;

public class PracSess extends AppCompatActivity {

    EditText Val1;
    EditText Val2;
    TextView tv;
    Button btn,btnNew3;
    androidx.constraintlayout.widget.ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prac_sess);

        Val1 = (EditText)findViewById(R.id.et1);
        Val2 = (EditText)findViewById(R.id.et2);
        tv = (TextView)findViewById(R.id.tv5);
        btn = (Button)findViewById(R.id.btn2);
        btnNew3 = (Button)findViewById(R.id.btnnew3) ;
        cl = (androidx.constraintlayout.widget.ConstraintLayout)findViewById(R.id.btnr);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double vel = Double.parseDouble(Val1.getText().toString());
                double calc = Double.parseDouble(Val2.getText().toString());
                double temp = vel/10000;
                double sum = 30000/sqrt(900000000-(temp*temp));
                if(sum==calc)
                {
                    cl.setBackgroundColor(Color.GREEN);
                    Toast.makeText(PracSess.this,"Hurray! CORRECT",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Vibrator vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    vib.vibrate(400);
                    cl.setBackgroundColor(Color.RED);
                    Toast.makeText(PracSess.this,"Uh-oh! WRONG",Toast.LENGTH_LONG).show();
                    tv.setText("The Correct Answer is : " + sum);
                }
            }
        });

        btnNew3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracSess.this, HomeScreen.class);
                startActivity(intent);
            }
        });


    }
}