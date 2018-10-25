package com.example.gabri.fuelcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    private TextView ethanolPriceTV;
    private TextView ethanolMilageTV;
    private TextView gasPriceTV;
    private TextView gasMilageTV;
    private TextView rateTV;
    private TextView ethanolSpentTV;
    private TextView gasSpentTV;
    private TextView bestFuelTV;
    private TextView fuelSavingTV;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ethanolPriceTV = findViewById(R.id.etanol_price_result);
        ethanolMilageTV = findViewById(R.id.etanol_milage_result);
        gasPriceTV = findViewById(R.id.gas_price_result);
        gasMilageTV = findViewById(R.id.gas_milage_result);
        rateTV = findViewById(R.id.rate);
        ethanolSpentTV = findViewById(R.id.ethanol_spent);
        gasSpentTV = findViewById(R.id.gas_spent);
        bestFuelTV = findViewById(R.id.best_fuel);
        fuelSavingTV = findViewById(R.id.fuel_saving);
        backButton = findViewById(R.id.back_button);

        Intent intent = getIntent();
        double ethanolPrice = intent.getDoubleExtra("ETHANOL_PRICE", 0);
        double gasPrice = intent.getDoubleExtra("GAS_PRICE", 0);
        double ethanolMilage = intent.getDoubleExtra("ETHANOL_MILAGE", 0);
        double gasMilage = intent.getDoubleExtra("GAS_MILAGE", 0);
        double rateFuel = (ethanolPrice / gasPrice) * 100;
        double ethanolSpent = ethanolPrice / ethanolMilage;
        double gasSpent = gasPrice / gasMilage;
        double fuelSaving = Math.abs(ethanolSpent - gasSpent);

        if (ethanolSpent < gasSpent){
            bestFuelTV.setText("Abasteça com Etanol!");
        }

        else
            bestFuelTV.setText("Abasteça com Gasolina!");

        Locale locale = new Locale("pt", "BR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

        ethanolPriceTV.setText(nf.format(ethanolPrice));
        gasPriceTV.setText(nf.format(gasPrice));
        ethanolMilageTV.setText(String.valueOf(ethanolMilage));
        gasMilageTV.setText(String.valueOf(gasMilage));
        ethanolSpentTV.setText(nf.format(ethanolSpent));
        gasSpentTV.setText(nf.format(gasSpent));
        rateTV.setText(String.format("%.2f %%", rateFuel));
        fuelSavingTV.setText("Economia de " + nf.format(fuelSaving));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultActivity.super.onBackPressed();

            }
        });

    }
}
