package com.example.paivafed.medicalcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double weightEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        final RadioButton kilogramsToPound = (RadioButton) findViewById(R.id.radioKilograms);
        final RadioButton poundToKilogram = (RadioButton) findViewById(R.id.radioPounds);

        Button convert = (Button) findViewById(R.id.btnWeights);
        convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    weightEntered = Double.parseDouble(weight.getText().toString());
                    Double conversion;
                    String myConversion;
                    DecimalFormat df = new DecimalFormat("##.##");
                        if (kilogramsToPound.isChecked()) {
                            if (weightEntered > 225){
                                Toast.makeText(MainActivity.this, "Value must be lesser than 225 kilograms", Toast.LENGTH_LONG).show();
                                result.setText("");
                            } else {
                                conversion = weightEntered * 2.2046;
                                myConversion = df.format(conversion);
                                result.setText(myConversion + " pounds");
                            }

                        } else if (poundToKilogram.isChecked()) {
                            if (weightEntered > 500) {
                                Toast.makeText(MainActivity.this, "Value must be lesser than 500 pounds", Toast.LENGTH_LONG).show();
                                result.setText("");
                            } else {
                                conversion = weightEntered / 2.2046;
                                myConversion = df.format(conversion);
                                result.setText(myConversion + " kilograms");
                            }
                        }
                }

                catch (NumberFormatException e) {
                    result.setText("");
                    Toast.makeText(MainActivity.this, "Insert a valid value", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
