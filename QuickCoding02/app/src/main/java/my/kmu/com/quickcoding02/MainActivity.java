package my.kmu.com.quickcoding02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button sendbtn;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendbtn = (Button)findViewById(R.id.sendbtn);

        final int randnum = (int)(Math.random()*100) + 1;


        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edittx;
                edittx = (EditText)findViewById(R.id.edittx);
                int num = Integer.parseInt(String.valueOf(edittx.getText()));

                TextView tx1;
                tx1 = (TextView)findViewById(R.id.tx1);

                if(num > randnum){
                    tx1.setText("Your number is bigger!!");
                }
                else if(num < randnum){
                    tx1.setText("Your number is smaller!!");
                }
                else{
                    tx1.setText("Bingo!!");
                }
            }
        });




    }
}
