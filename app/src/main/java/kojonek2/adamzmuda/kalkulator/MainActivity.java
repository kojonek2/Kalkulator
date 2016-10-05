package kojonek2.adamzmuda.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String STATE_NUMBER_LENGTH = "numberOnDisplayLength";
    static final String STATE_NUMBER = "numberOnDisplay";

    TextView textView;
    int numbersOnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.display1);

        //reading information
        if (savedInstanceState != null) {
            numbersOnDisplay = savedInstanceState.getInt(STATE_NUMBER_LENGTH);
            textView.setText(savedInstanceState.getCharSequence(STATE_NUMBER));
        } else {
            numbersOnDisplay = 0;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //saving information
        savedInstanceState.putInt(STATE_NUMBER_LENGTH, numbersOnDisplay);
        savedInstanceState.putCharSequence(STATE_NUMBER, textView.getText());
    }

    public void displayNumber(View view) {
        switch (view.getId()){
            case R.id.button_0:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "0" : textView.getText() + "0");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_1:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "1" : textView.getText() + "1");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_2:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "2" : textView.getText() + "2");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_3:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "3" : textView.getText() + "3");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_4:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "4" : textView.getText() + "4");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_5:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "5" : textView.getText() + "5");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_6:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "6" : textView.getText() + "6");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_7:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "7" : textView.getText() + "7");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_8:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "8" : textView.getText() + "8");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_9:
                if (numbersOnDisplay < 15) {
                    textView.setText(textView.getText().equals("0") ? "9" : textView.getText() + "9");
                    numbersOnDisplay++;
                }
                break;
            case R.id.button_backspace:
                textView.setText(textView.getText().length() > 1 &&(textView.getText().length() > 2 || !textView.getText().toString().substring(0, 1).equals("-")) ? textView.getText().toString().substring(0, textView.getText().length() - 1) : "0");
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
        }
    }


}
