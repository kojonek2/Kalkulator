package kojonek2.adamzmuda.kalkulator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //constant
    static final String STATE_NUMBER_LENGTH = "numberOnDisplayLength";
    static final String STATE_NUMBER = "numberOnDisplay";
    static final String STATE_FIRST_INPUT = "firstNumberInInput";
    static final String STATE_MATH_OPERATOR = "mathOperatorChosen";

    //variables
    TextView textView;
    int numbersOnDisplay;
    double firstInput;
    String mathOperatorInput;
    Toast toast;

    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.display1);
        toast = Toast.makeText(this, R.string.toastMaxDigits, Toast.LENGTH_SHORT);

        //reading information
        if (savedInstanceState != null) {

            numbersOnDisplay = savedInstanceState.getInt(STATE_NUMBER_LENGTH);
            textView.setText(savedInstanceState.getCharSequence(STATE_NUMBER));
            firstInput = savedInstanceState.getDouble(STATE_FIRST_INPUT);
            mathOperatorInput = savedInstanceState.getString(STATE_MATH_OPERATOR);
        } else {

            numbersOnDisplay = 0;
            firstInput = 0;
            mathOperatorInput = "no operator yet";
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //saving information
        savedInstanceState.putInt(STATE_NUMBER_LENGTH, numbersOnDisplay);
        savedInstanceState.putCharSequence(STATE_NUMBER, textView.getText());
        savedInstanceState.putDouble(STATE_FIRST_INPUT, firstInput);
        savedInstanceState.putString(STATE_MATH_OPERATOR, mathOperatorInput);
    }

    public void displayNumber(View view) {
        switch (view.getId()) {
            case R.id.button_0:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "0" : textView.getText() + "0");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_1:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "1" : textView.getText() + "1");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_2:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "2" : textView.getText() + "2");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_3:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "3" : textView.getText() + "3");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_4:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "4" : textView.getText() + "4");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_5:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "5" : textView.getText() + "5");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_6:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "6" : textView.getText() + "6");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_7:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "7" : textView.getText() + "7");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_8:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "8" : textView.getText() + "8");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_9:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "9" : textView.getText() + "9");
                    numbersOnDisplay++;
                } else {
                    toast.show();
                }
                break;
            case R.id.button_backspace:
                textView.setText(textView.getText().length() > 1 && (textView.getText().length() > 2 || !textView.getText().toString().substring(0, 1).equals("-")) ? textView.getText().toString().substring(0, textView.getText().length() - 1) : "0");
                numbersOnDisplay--;
                break;
            case R.id.button_c:
                textView.setText("0");
                numbersOnDisplay = 0;
                break;
            case R.id.button_changeSign:
                if (!textView.getText().equals("0")) {
                    textView.setText(textView.getText().toString().substring(0, 1).equals("-") ? textView.getText().toString().substring(1, textView.getText().length()) : "-" + textView.getText());
                }
                break;
            case R.id.button_add:
                mathOperation("+");
                break;
            case R.id.button_divide:
                mathOperation("/");
                break;
            case R.id.button_multiply:
                mathOperation("*");
                break;
            case R.id.button_subtract:
                mathOperation("-");
                break;
            case R.id.button_equals:
                mathOperation("=");
                break;
        }
    }

    public void mathOperation(String operator) {


        switch (operator) {
            case "+":
                firstInput = Double.parseDouble(textView.getText().toString());
                textView.setText("0");
                mathOperatorInput = "+";
                break;
            case "/":
                firstInput = Double.parseDouble(textView.getText().toString());
                textView.setText("0");
                mathOperatorInput = "/";
                break;
            case "*":
                firstInput = Double.parseDouble(textView.getText().toString());
                textView.setText("0");
                mathOperatorInput = "*";
                break;
            case "-":
                firstInput = Double.parseDouble(textView.getText().toString());
                textView.setText("0");
                mathOperatorInput = "-";
                break;
            case "=":
                if (mathOperatorInput.equals("+")) {
                    textView.setText(Double.toString(firstInput + Double.parseDouble(textView.getText().toString())));
                }
                if (mathOperatorInput.equals("/")) {
                    textView.setText(Double.toString(firstInput / Double.parseDouble(textView.getText().toString())));
                }
                if (mathOperatorInput.equals("*")) {
                    textView.setText(Double.toString(firstInput * Double.parseDouble(textView.getText().toString())));
                }
                if (mathOperatorInput.equals("-")) {
                    textView.setText(Double.toString(firstInput - Double.parseDouble(textView.getText().toString())));
                }
                break;
        }
    }


}
