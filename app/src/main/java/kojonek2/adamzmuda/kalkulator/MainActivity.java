package kojonek2.adamzmuda.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        textView = (TextView) findViewById(R.id.display1);
    }

    public void displayNumber(View view) {
        switch (view.getId()){
            case R.id.button_0:
                textView.setText(textView.getText().equals("0") ? "0" : textView.getText() + "0");
                break;
            case R.id.button_1:
                textView.setText(textView.getText().equals("0") ? "1" : textView.getText() + "1");
                break;
            case R.id.button_2:
                textView.setText(textView.getText().equals("0") ? "2" : textView.getText() + "2");
                break;
            case R.id.button_3:
                textView.setText(textView.getText().equals("0") ? "3" : textView.getText() + "3");
                break;
            case R.id.button_4:
                textView.setText(textView.getText().equals("0") ? "4" : textView.getText() + "4");
                break;
            case R.id.button_5:
                textView.setText(textView.getText().equals("0") ? "5" : textView.getText() + "5");
                break;
            case R.id.button_6:
                textView.setText(textView.getText().equals("0") ? "6" : textView.getText() + "6");
                break;
            case R.id.button_7:
                textView.setText(textView.getText().equals("0") ? "7" : textView.getText() + "7");
                break;
            case R.id.button_8:
                textView.setText(textView.getText().equals("0") ? "8" : textView.getText() + "8");
                break;
            case R.id.button_9:
                textView.setText(textView.getText().equals("0") ? "9" : textView.getText() + "9");
                break;
            case R.id.button_backspace:
                textView.setText(textView.getText().length() > 1 &&(textView.getText().length() > 2 || !textView.getText().toString().substring(0, 1).equals("-")) ? textView.getText().toString().substring(0, textView.getText().length() - 1) : "0");
                break;
            case R.id.button_c:
                textView.setText("0");
                break;
            case R.id.button_changeSign:
                if(!textView.getText().equals("0")) {
                    textView.setText(textView.getText().toString().substring(0, 1).equals("-") ? textView.getText().toString().substring(1, textView.getText().length()) : "-" + textView.getText());
                }
                break;
        }
    }


}
