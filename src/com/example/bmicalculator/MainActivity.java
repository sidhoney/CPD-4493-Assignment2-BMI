package com.example.bmicalculator;

import java.text.DecimalFormat;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText enteredWeight = (EditText) findViewById(R.id.weightTxt);
		final EditText enteredHeight = (EditText) findViewById(R.id.heightTxt);
		final TextView resultView = (TextView) findViewById(R.id.resultAns);
		final TextView resultstmt = (TextView) findViewById(R.id.resultstmt);
		final Button calculate = (Button) findViewById(R.id.button1);
		final RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);
		final RadioButton EngRadio = (RadioButton) findViewById(R.id.radio0);
		final RadioButton MetRadio = (RadioButton) findViewById(R.id.radio1);

		EngRadio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (arg1) {
					enteredWeight.setHint("Weight in Pounds");
					enteredHeight.setHint("Height in Inches");
				}

			}
		});
		MetRadio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (arg1) {
					enteredWeight.setHint("Weight in Kilograms");
					enteredHeight.setHint("Height in Meters");
				}

			}
		});
		calculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if(enteredWeight.getText()
						.toString().length()>0 && enteredHeight.getText()
						.toString().length()>0){
				double weight = Float.parseFloat(enteredWeight.getText()
						.toString());
				double height = Float.parseFloat(enteredHeight.getText()
						.toString());

				DecimalFormat d = new DecimalFormat("0.00");
				if (MetRadio.isChecked()) {
					double result = weight / (height * height);
					resultView.setText("Your BMI is: " + "" + d.format(result));
					if (result <= 18.5) {
						resultstmt.setText("UnderWeight");
					}
					if (result >= 18.5 && result <= 24.9) {
						resultstmt.setText("Normal");
					}
					if (result >= 25 && result <= 29.9) {
						resultstmt.setText("Overweight");
					}
					if (result >= 30) {
						resultstmt.setText("Obese");
					}
				} else if (EngRadio.isChecked()) {
					double result = ((weight * 703) / (height * height));
					resultView.setText("Your BMI is:" + "" + d.format(result));
					if (result <= 18.5) {
						resultstmt.setText("UnderWeight");
					}
					if (result >= 18.5 && result <= 24.9) {
						resultstmt.setText("Normal");
					}
					if (result >= 25 && result <= 29.9) {
						resultstmt.setText("Overweight");
					}
					if (result >= 30) {
						resultstmt.setText("Obese");
					}
				}
			}	else{
					Toast.makeText(MainActivity.this, "enter values ", Toast.LENGTH_SHORT).show();
			}
		  }
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}