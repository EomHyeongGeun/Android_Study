package my.kmu.com.intentdemo1b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText txtUriString;
    Button btnCallActivity2;
    Context context = getApplication();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            txtUriString = (EditText) findViewById(R.id.txtUriString);
            btnCallActivity2 = (Button) findViewById(R.id.btnCallActivity2);
            btnCallActivity2.setOnClickListener(new MyClickHandler());
        }catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }// onCreate

    public class MyClickHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            try {
                String myData = txtUriString.getText().toString();
                Intent myActivity2 = new Intent(Intent.ACTION_DIAL, Uri.parse(myData));
                startActivity(myActivity2);
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

}