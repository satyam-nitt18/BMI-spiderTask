package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.round;

public class MainActivity extends AppCompatActivity {

    EditText wt, ht;
    TextView res;
    Button calc;

    public void showToast(String text)
    {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    public float roundTo2dec(float val)
    {
        val=val*100;
        val=round(val);
        return (val/100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wt=(EditText)findViewById(R.id.weight);
        ht=(EditText)findViewById(R.id.height);
        res=(TextView)findViewById(R.id.result);
        calc=(Button)findViewById(R.id.button);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(String.valueOf(wt.getText()).isEmpty()|| String.valueOf(ht.getText()).isEmpty())
                showToast("Enter proper values");

                float weight = Float.valueOf(wt.getText().toString());
                 float height=Float.valueOf(ht.getText().toString());


                float bmi= (weight/(height*height));
                float result=roundTo2dec(bmi);


                res.setText("Your BMI index is "+result);
                if(result<18.5)
                    res.append("\n Underweight");
                else if(result<25)
                    res.append("\n Normal BMI");
                else if(result<30)
                    res.append("\n Overweight");
                else
                    res.append("\n Obese");

            }
        });

    }
}
