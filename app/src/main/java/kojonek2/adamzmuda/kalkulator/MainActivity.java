package kojonek2.adamzmuda.kalkulator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //constant
    private static final String STATE_NUMBER_LENGTH = "numberOnDisplayLength";
    private static final String STATE_NUMBER = "numberOnDisplay";
    private static final String STATE_FIRST_INPUT = "firstNumberInInput";
    private static final String STATE_MATH_OPERATOR = "mathOperatorChosen";
    private static final String STATE_MATH_OPERATOR_PRESSED = "mathOperatorPressed";
    private static final String STATE_IS_INPUT_TYPED = "isInputTypedAfterOperation";

    //variables
    String resultOfMathOperation;
    private TextView textView;
    private int numbersOnDisplay;
    private double firstInput;
    private String mathLastOperationDone;
    String mathLastOperationPressed;
    private Toast toast;
    DecimalFormat decimalFormat;
    Boolean isInputTyped;

    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.display1);
        toast = Toast.makeText(this, R.string.toastMaxDigits, Toast.LENGTH_SHORT);
        decimalFormat = new DecimalFormat("#.###############");

        //reading information
        if (savedInstanceState != null) {

            numbersOnDisplay = savedInstanceState.getInt(STATE_NUMBER_LENGTH);
            textView.setText(savedInstanceState.getCharSequence(STATE_NUMBER));
            firstInput = savedInstanceState.getDouble(STATE_FIRST_INPUT);
            mathLastOperationDone = savedInstanceState.getString(STATE_MATH_OPERATOR);
            mathLastOperationPressed = savedInstanceState.getString(STATE_MATH_OPERATOR_PRESSED);
            isInputTyped = savedInstanceState.getBoolean(STATE_IS_INPUT_TYPED);
        } else {

            numbersOnDisplay = 0;
            firstInput = 0;
            mathLastOperationDone = "no operator yet";
            mathLastOperationPressed = "no operator yet";
            isInputTyped = true;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //saving information
        savedInstanceState.putInt(STATE_NUMBER_LENGTH, numbersOnDisplay);
        savedInstanceState.putCharSequence(STATE_NUMBER, textView.getText());
        savedInstanceState.putDouble(STATE_FIRST_INPUT, firstInput);
        savedInstanceState.putString(STATE_MATH_OPERATOR, mathLastOperationDone);
        savedInstanceState.putString(STATE_MATH_OPERATOR_PRESSED, mathLastOperationPressed);
        savedInstanceState.putBoolean(STATE_IS_INPUT_TYPED, isInputTyped);
    }

    private void mathOperatorEquals(String operator, Boolean isPressedButtonEquals) {

        if (operator.equals("+")) {
            resultOfMathOperation = decimalFormat.format(firstInput + Double.parseDouble(textView.getText().toString())).replace(",", ".");
        }
        if (operator.equals("/")) {
            resultOfMathOperation = decimalFormat.format(firstInput / Double.parseDouble(textView.getText().toString())).replace(",", ".");
        }
        if (operator.equals("*")) {
            resultOfMathOperation = decimalFormat.format(firstInput * Double.parseDouble(textView.getText().toString())).replace(",", ".");
        }
        if (operator.equals("-")) {
            resultOfMathOperation = decimalFormat.format(firstInput - Double.parseDouble(textView.getText().toString())).replace(",", ".");
        }

        if (!operator.equals("no operator yet")) {
            if (resultOfMathOperation.contains(".")) {
                resultOfMathOperation = resultOfMathOperation.substring(0, Math.min(resultOfMathOperation.length(), 16));
            } else {
                resultOfMathOperation = resultOfMathOperation.substring(0, Math.min(resultOfMathOperation.length(), 15));
            }
            textView.setText(resultOfMathOperation);
            isInputTyped = false;
        }

        if (isPressedButtonEquals) {
            mathLastOperationDone = "=";
        }
    }

    private void mathOperation(String operator) {

        switch (operator) {
            case "+":
                if (!mathLastOperationDone.equals("+")) {
                    firstInput = Double.parseDouble(textView.getText().toString());
                    textView.setText("0");
                    numbersOnDisplay = 0;
                    mathLastOperationDone = "+";
                    mathLastOperationPressed = "+";
                    mathOperatorEquals("+", false);
                } else if (isInputTyped) {
                    mathOperatorEquals("+", true);
                }
                break;
            case "/":
                if (!mathLastOperationDone.equals("/")) {
                    firstInput = Double.parseDouble(textView.getText().toString());
                    textView.setText("1");
                    numbersOnDisplay = 0;
                    mathLastOperationDone = "/";
                    mathLastOperationPressed = "/";
                    mathOperatorEquals("/", false);
                } else if (isInputTyped) {
                    mathOperatorEquals("/", true);
                }
                break;
            case "*":
                if (!mathLastOperationDone.equals("*")) {
                    firstInput = Double.parseDouble(textView.getText().toString());
                    textView.setText("1");
                    numbersOnDisplay = 0;
                    mathLastOperationDone = "*";
                    mathLastOperationPressed = "*";
                    mathOperatorEquals("*", false);
                } else if (isInputTyped) {
                    mathOperatorEquals("*", true);
                }
                break;
            case "-":
                if (!mathLastOperationDone.equals("-")) {
                    firstInput = Double.parseDouble(textView.getText().toString());
                    textView.setText("0");
                    numbersOnDisplay = 0;
                    mathLastOperationDone = "-";
                    mathLastOperationPressed = "-";
                    mathOperatorEquals("-", false);
                } else if (isInputTyped) {
                    mathOperatorEquals("-", true);
                }
                break;
        }
    }

////////////////////////Start Button Methods/////////////////////

    public void onButtonClickCE(View view) {
        textView.setText("0");
        numbersOnDisplay = 0;
        isInputTyped = true;
        firstInput = 0;
        mathLastOperationDone = "no operator yet";
        mathLastOperationPressed = "no operator yet";
    }

    public void onButtonClickC(View view) {
        textView.setText("0");
        numbersOnDisplay = 0;
    }

    public void onButtonClickBackspace(View view) {
        if (textView.getText().length() > 1 && (textView.getText().length() > 2 || !textView.getText().toString().substring(0, 1).equals("-"))) {
            textView.setText(textView.getText().toString().substring(0, textView.getText().length() - 1));
        } else {
            textView.setText("0");
        }
        numbersOnDisplay--;
    }

    @SuppressLint("SetTextI18n")
    public void onButtonClickChangeSign(View view) {
        if (!textView.getText().equals("0")) {
            if (textView.getText().toString().substring(0, 1).equals("-")) {
                textView.setText(textView.getText().toString().substring(1, textView.getText().length()));
            } else {
                textView.setText("-" + textView.getText());
            }
        }
    }

    public void onButtonClickDivide(View view) {
        switch (mathLastOperationDone) {
            case "=":
            case "/":
            case "no operator yet":
                mathOperation("/");
                break;
            case "-":
                mathOperation("-");
                mathOperation("/");
                break;
            case "+":
                mathOperation("+");
                mathOperation("/");
                break;
            case "*":
                mathOperation("*");
                mathOperation("/");
                break;
        }
    }

    public void onButtonClickMultiply(View view) {
        switch (mathLastOperationDone) {
            case "=":
            case "*":
            case "no operator yet":
                mathOperation("*");
                break;
            case "-":
                mathOperation("-");
                mathOperation("*");
                break;
            case "/":
                mathOperation("/");
                mathOperation("*");
                break;
            case "+":
                mathOperation("+");
                mathOperation("*");
                break;
        }
    }

    public void onButtonClickSubtract(View view) {
        switch (mathLastOperationDone) {
            case "=":
            case "-":
            case "no operator yet":
                mathOperation("-");
                break;
            case "+":
                mathOperation("+");
                mathOperation("-");
                break;
            case "/":
                mathOperation("/");
                mathOperation("-");
                break;
            case "*":
                mathOperation("*");
                mathOperation("-");
                break;
        }
    }

    public void onButtonClickAdd(View view) {
        switch (mathLastOperationDone) {
            case "=":
            case "+":
            case "no operator yet":
                mathOperation("+");
                break;
            case "-":
                mathOperation("-");
                mathOperation("+");
                break;
            case "/":
                mathOperation("/");
                mathOperation("+");
                break;
            case "*":
                mathOperation("*");
                mathOperation("+");
                break;
        }
    }

    public void onButtonClickEquals(View view) {
        if (isInputTyped) {
            mathOperatorEquals(mathLastOperationPressed, true);
        }
    }

    public void onButtonClick0(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "0" : textView.getText() + "0");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("0");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClick1(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "1" : textView.getText() + "1");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("1");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClick2(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "2" : textView.getText() + "2");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("2");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClick3(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "3" : textView.getText() + "3");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("3");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClick4(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "4" : textView.getText() + "4");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("4");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClick5(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "5" : textView.getText() + "5");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("5");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClick6(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "6" : textView.getText() + "6");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("6");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClick7(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "7" : textView.getText() + "7");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("7");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClick8(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "8" : textView.getText() + "8");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("8");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClick9(View view) {
        if (numbersOnDisplay < 15) {
            textView.setText(textView.getText().equals("0") ? "9" : textView.getText() + "9");
            numbersOnDisplay++;
            if (!isInputTyped) {
                textView.setText("9");
            }
            isInputTyped = true;
        } else {
            toast.show();
        }
    }

    public void onButtonClickPoint(View view) {
    }
}

//////////////End Buttons Methods/////////////////