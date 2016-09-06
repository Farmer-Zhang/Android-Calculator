package com.xiong.calculatordemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	private Button clearButton;
	private Button delButton;
	private Button deliveryButton;
	private Button mutiPlusButton;
	
	private Button sevenButton;
	private Button eightButton;
	private Button nineButton;
	private Button takeawayButton;
	
	
	private Button fourButton;
	private Button fiveButton;
	private Button sixButton;
	private Button plusButton;
	
	private Button oneButton;
	private Button twoButton;
	private Button threeButton;
	
	private Button zeroButton;
	private Button doltButton;
	
	private Button equalButton;
	
	private EditText inputText;
	
	
	boolean clear_flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createButtonViews();
		
	}
	
	public void createButtonViews() {
		clearButton = (Button) findViewById(R.id.btn_clear);
		delButton = (Button) findViewById(R.id.btn_del);
		deliveryButton = (Button) findViewById(R.id.btn_delivery);
		mutiPlusButton = (Button) findViewById(R.id.btn_mutiplus);
		
		clearButton.setOnClickListener(this);
		delButton.setOnClickListener(this);
		deliveryButton.setOnClickListener(this);
		mutiPlusButton.setOnClickListener(this);
		
		
		
		sevenButton = (Button) findViewById(R.id.btn_seven);
		eightButton = (Button) findViewById(R.id.btn_eight);
		nineButton = (Button) findViewById(R.id.btn_nine);
		takeawayButton = (Button) findViewById(R.id.btn_takeaway);

		sevenButton.setOnClickListener(this);
		eightButton.setOnClickListener(this);
		nineButton.setOnClickListener(this);
		takeawayButton.setOnClickListener(this);
		
		
		
		fourButton = (Button) findViewById(R.id.btn_four);
		fiveButton = (Button) findViewById(R.id.btn_five);
		sixButton = (Button) findViewById(R.id.btn_six);
		plusButton = (Button) findViewById(R.id.btn_plus);

		fourButton.setOnClickListener(this);
		fiveButton.setOnClickListener(this);
		sixButton.setOnClickListener(this);
		plusButton.setOnClickListener(this);
		
		
		
		oneButton = (Button) findViewById(R.id.btn_one);
		twoButton = (Button) findViewById(R.id.btn_two);
		threeButton = (Button) findViewById(R.id.btn_three);
		
		oneButton.setOnClickListener(this);
		twoButton.setOnClickListener(this);
		threeButton.setOnClickListener(this);
		
		
		
		zeroButton = (Button) findViewById(R.id.btn_zero);
		doltButton = (Button) findViewById(R.id.btn_dolt);

		zeroButton.setOnClickListener(this);
		doltButton.setOnClickListener(this);
		
		
		
		equalButton = (Button) findViewById(R.id.btn_equal);
		equalButton.setOnClickListener(this);
		
		
		inputText = (EditText)findViewById(R.id.et_input);
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Button button = (Button)v;		
		String str = inputText.getText().toString();
		switch (v.getId()) {
		case R.id.btn_zero:
		case R.id.btn_one:
		case R.id.btn_two:
		case R.id.btn_three:
		case R.id.btn_four:
		case R.id.btn_five:
		case R.id.btn_six:
		case R.id.btn_seven:
		case R.id.btn_eight:
		case R.id.btn_nine:
		case R.id.btn_dolt:
			if (clear_flag) {
				clear_flag = false;
				str = "";
				inputText.setText("");
			}
			inputText.setText(str + button.getText());
			break;
			
case R.id.btn_delivery:	
case R.id.btn_mutiplus:
case R.id.btn_takeaway:	
case R.id.btn_plus:
	if (clear_flag) {
		clear_flag = false;
		str = "";
		inputText.setText("");
	}
	inputText.setText(str + " " + button.getText() + " ");
	break;

case R.id.btn_del:
	if (clear_flag) {
		clear_flag = false;
		str = "";
		inputText.setText("");
	} else if (str != null && !str.equals("")) {
		inputText.setText(str.substring(0, str.length()-1));
	}
	break;
case R.id.btn_clear:
	clear_flag = false;
	inputText.setText("");
	break;
		
case R.id.btn_equal:
	str = "";
	getResult();
	break;
		}
	}
	
	public void	getResult() {
		String exp = inputText.getText().toString();
		if (exp == null || exp.equals("")) {
			return;
		}
		if (!exp.contains(" ")) {
			return;
		}
		
		if (clear_flag) {
			clear_flag = false;
			return;
		}
		
		clear_flag = true;
		double result = 0;
		String starString = exp.substring(0,exp.indexOf(" "));
		String midString = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
		String endString = exp.substring(exp.indexOf(" ") + 3);
		if (!(starString.equals("") && endString.equals(""))) {
			double d1 = Double.parseDouble(starString);
			double d2 = Double.parseDouble(endString);
			
			if (midString.equals("+")) {
				result = d1 + d2;
			} else if(midString.equals("-")) {
				result = d1 - d2;
			} else if(midString.equals("×")) {
				result = d1 * d2;
			} else if(midString.equals("÷")) {
				if (d2 == 0) {
					result = 0;
				} else {
					result = d1 / d2;
				}
			}
			if (!starString.contains(".") && !endString.contains(".") && !midString.equals("÷")) {
				int re = (int)result;
				inputText.setText("" + re);
			} else {
				inputText.setText("" + result);
			}			
		} else if(!starString.equals("") && endString.equals("")){
			inputText.setText(exp);
		} else if(starString.equals("") && !endString.equals("")){
			double d2 = Double.parseDouble(endString);
			if (midString.equals("+")) {
				result = d2;
			} else if(midString.equals("-")) {
				result = 0 - d2;
			} else if(midString.equals("x")) {
				result = 0;
			} else if(midString.equals("÷")) {
					result = 0;
			}
			if (!endString.contains(".")) {
				int re = (int)result;
				inputText.setText("" + re);
			} else {
				inputText.setText("" + result);
			}		
		} else {
			inputText.setText("");
		}
	}
}



