package com.example.calc;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {
     EditText amount , year , percent;
      TextView result;
      String dashboard = "";
    ArrayList<String> resultsArray = new ArrayList<>();
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        amount = findViewById(R.id.amount);
        year = findViewById(R.id.year);
        percent = findViewById(R.id.percent);
        result = findViewById(R.id.result);

    }

    public void calc(View view) {

        if (amount.length() == 0 || year.length() == 0 || percent.length() == 0){
            Toast.makeText(this, "Please, Enter all data!", Toast.LENGTH_SHORT).show();
return;
        }

      String a = amount.getText().toString();
      int am = Integer.parseInt(a);
      int y = Integer.parseInt(year.getText().toString());
      int p = Integer.parseInt(percent.getText().toString());

        for (int i = 0; i < y; i++) {
            int increase = am*p;
            am += increase;
        }

      dashboard = "amount : "+(amount.getText().toString()) + "year : " + y +" percent: "+ p + " result: "+ am;

//


        StringBuilder sb = new StringBuilder();

if (resultsArray.contains(dashboard)){
    index = resultsArray.indexOf(dashboard);
    Toast.makeText(this, "already exist at line: " + (index+1), Toast.LENGTH_SHORT).show();

}else
{
    resultsArray.add(0,dashboard);

    for (String s : resultsArray) {
        sb.append(s+"\n");
//            result.append(s);
//            result.       append("##");

    }

    result.setText(sb.toString());
//    result.append(Integer.toString(resultsArray.size()));

}
result.setMovementMethod(new ScrollingMovementMethod());

    }
}