package net.androidbootcamp.homemortgageinterest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Total extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        TextView total = (TextView)findViewById(R.id.txtInitialPrincipal);
        ImageView pic = (ImageView)findViewById(R.id.imgYrs);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        float monthlyPayment = shared.getFloat("keyPay", 0);
        int numberOfYears = shared.getInt("keyYrs",0);
        float initialPrincipalLoan = shared.getFloat("keyPrincipal", 0);

        float totalInterest;
        int numberOfMonths = numberOfYears * 12;

        totalInterest = (monthlyPayment * numberOfMonths) - initialPrincipalLoan;
        DecimalFormat currency = new DecimalFormat("$###,###,###.##");

        total.setText("Total interest paid " + currency.format(totalInterest));

        if (numberOfYears == 10){
            pic.setImageResource(R.drawable.ten);
        }
        else if (numberOfYears == 20){
            pic.setImageResource(R.drawable.twenty);
        }
        else if (numberOfYears == 30){
            pic.setImageResource(R.drawable.thirty);
        }
        else{
            total.setText("Please enter 10, 20 or 30 years.");
        }
    }
}
