package com.example.spyder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    Button LorentzFactor;
    TextView result;
    Button btnPS,btnNew2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.etNum1);
        LorentzFactor= (Button)findViewById(R.id.btnLf);
        result = (TextView)findViewById(R.id.tvAnswer);
        btnPS = (Button)findViewById(R.id.btnPs);
        btnNew2 = (Button)findViewById(R.id.btnnew2);

        LorentzFactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number1 = Integer.parseInt(num1.getText().toString());
                if(number1>300000000)
                {
                    result.setText("Answer: Toast");
                    Toast.makeText(MainActivity.this,"Toast : Wrong Input",Toast.LENGTH_LONG).show();
                }
                else
                {
                    double temp = number1/10000;
                    double sum = 30000/sqrt(900000000-(temp*temp));
                    result.setText("Answer: " + String.valueOf(sum));
                }

            }
        });

        btnPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAct2();
            }
        });

        btnNew2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(intent);
            }
        });

    }
    void openAct2()
    {
        Intent intent = new Intent(this, PracSess.class);
        startActivity(intent);
    }
}