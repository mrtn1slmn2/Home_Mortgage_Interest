package net.androidbootcamp.homemortgageinterest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    float moPay;
    int numYrs;
    float iniPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText monthlyPay = (EditText)findViewById(R.id.txtMonthlyPay);
        final EditText numYears = (EditText)findViewById(R.id.txtNumYears);
        final EditText initialPrincipal = (EditText)findViewById(R.id.txtInitialPrincipal);

        Button calculate = (Button)findViewById(R.id.btnCalc);
        final SharedPreferences sharedP = PreferenceManager.getDefaultSharedPreferences(this);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moPay = Float.parseFloat(monthlyPay.getText().toString());
                numYrs = Integer.parseInt(numYears.getText().toString());
                iniPrincipal = Float.parseFloat(initialPrincipal.getText().toString());

                SharedPreferences.Editor editor1 = sharedP.edit();
                editor1.putFloat("keyPay", moPay);
                editor1.putInt("keyYrs", numYrs);
                editor1.putFloat("keyPrincipal", iniPrincipal);
                editor1.commit();

                startActivity(new Intent(MainActivity.this, Total.class));
            }
        });
    }
}
