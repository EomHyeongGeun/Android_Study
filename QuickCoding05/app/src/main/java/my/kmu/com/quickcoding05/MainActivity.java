package my.kmu.com.quickcoding05;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    EditText edit01;
    Button button_complete, button_input;
    TextView tv01, tv02;

    public static boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit01          = (EditText)findViewById(R.id.edit01);
        button_complete = (Button)findViewById(R.id.button_complete);
        button_input    = (Button)findViewById(R.id.button_input);
        tv01            = (TextView)findViewById(R.id.tv01);
        tv02            = (TextView)findViewById(R.id.tv02);

        final GenericList<Integer, String> genericList = new GenericList<Integer, String>();

        button_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = edit01.getText().toString();

                if(isStringDouble(text))
                    genericList.addInt(Integer.parseInt(text));
                else
                    genericList.addString(text.toString());
            }
        });

        button_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_int = "";
                String temp_string = "";

                for(int i=0; i<genericList.list_string.size(); i++){
                    temp_string += genericList.list_string.get(i);
                }

                for(int i=0; i<genericList.list_int.size(); i++){
                    temp_int += genericList.list_int.get(i);
                }

                tv01.setText(temp_string);
                tv02.setText(temp_int);

            }
        });

    }
}

