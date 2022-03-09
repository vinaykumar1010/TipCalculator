package com.vinappstudio.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView textViewSeekBar;
    private Integer seekBarPercentage;
    private float enteredBillFloat;
    private  TextView totalBill ;

    //TODO : Build Awesome applications

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = findViewById(R.id.billAmoutnID);
        seekBar = findViewById(R.id.seekBar);
        calculateButton = findViewById(R.id.calculate_button);
        totalResultTextView = findViewById(R.id.result_id);
        textViewSeekBar = findViewById(R.id.textViewSeekbar);
        totalBill = findViewById(R.id.totalBill_ID);
        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewSeekBar.setText(String.valueOf(seekBar.getProgress() + "%"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarPercentage = seekBar.getProgress();
            }
        });


    }

    @Override
    public void onClick(View v) {
        float result =0.0f;
        if(!enteredAmount.getText().toString().equals("")){
            enteredBillFloat = Float.parseFloat(enteredAmount.getText().toString());
            result = enteredBillFloat*seekBarPercentage/100;
            totalResultTextView.setText("Your Tip will be : "+ result + "Rs.");
            totalBill.setText("Total Bill Amount : "+String.valueOf( enteredBillFloat+result )+ "Rs.");
        } else
        {  Toast.makeText(MainActivity.this , "Please Enter Bill  Amount",Toast.LENGTH_SHORT).show();
        totalResultTextView.setText("Your Tip will be : "+ "0 Rs.");
        totalBill.setText("Total Bill Amount : "+ "0 Rs.");}

    }


    
}