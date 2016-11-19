package my.kmu.com.mobileprogramming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

abstract class MyValue{
    static int[] arr = {5,2,3,7,9};
    abstract String getResult();
}

class MyMinimum extends MyValue{
    String getResult(){
        int min=arr[0];
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]<arr[i-1])
                min = arr[i];
        }

        return ""+min;
    }
}

class MyMaximum extends MyValue{
    String getResult(){
        int max=arr[0];
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]>arr[i-1])
                max = arr[i];
        }

        return ""+max;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickcoding);

        TextView txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText() + "\n" + Arrays.toString(MyValue.arr));


        Button btn01 = (Button)findViewById(R.id.btn01);
        Button btn02 = (Button)findViewById(R.id.btn02);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMinimum mymin = new MyMinimum();
                TextView txt2 = (TextView)findViewById(R.id.txt2);
                txt2.setText(mymin.getResult());
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyMaximum mymax = new MyMaximum();
                TextView txt2 = (TextView)findViewById(R.id.txt2);
                txt2.setText(mymax.getResult());
            }
        });
    }


}
