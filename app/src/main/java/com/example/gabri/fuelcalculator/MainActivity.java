package com.example.gabri.fuelcalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ethanolPriceET;
    private EditText gasPriceET;
    private EditText ethanolMilageET;
    private EditText gasMilageET;
    private Button calculatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ethanolPriceET = findViewById(R.id.ethanol_price_edit_text);
        ethanolMilageET = findViewById(R.id.ethanol_milage_edit_text);

        gasPriceET = findViewById(R.id.gas_price_edit_text);
        gasMilageET = findViewById(R.id.gas_milage_edit_text);

        calculatorButton = findViewById(R.id.calculator_button);
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()){
                    changeToResultActicity();
                }
            }
        });
    }

    private void changeToResultActicity()
    {
        Intent intent = new Intent(this, ResultActivity.class);

        String ethanolPriceStr = ethanolPriceET.getText().toString();
        String gasPriceStr = gasPriceET.getText().toString();
        String ethanolMilageStr = ethanolMilageET.getText().toString();
        String gasMilageStr = gasMilageET.getText().toString();

        Double ethanolPrice = Double.parseDouble(ethanolPriceStr.replace(",", ".").trim());
        Double gasPrice = Double.parseDouble(gasPriceStr.replace(",", ".").trim());
        Double ethanolMilagePrice = Double.parseDouble(ethanolMilageStr.replace(",", ".").trim());
        Double gasMilage = Double.parseDouble(gasMilageStr.replace(",", ".").trim());

        // Passar informaçoes de uma tela para outra

        intent.putExtra("ETHANOL_PRICE", ethanolPrice);
        intent.putExtra("GAS_PRICE", gasPrice);
        intent.putExtra("ETHANOL_MILAGE", ethanolMilagePrice);
        intent.putExtra("GAS_MILAGE", gasMilage);
        startActivity(intent);
    }

    private boolean validateFields(){

        boolean correctValidation = true;

        if (ethanolPriceET.getText().toString().isEmpty())
        {
            ethanolPriceET.setError(getString(R.string.erro_price_etanol));
            correctValidation = false;

        }

        if (gasPriceET.getText().toString().isEmpty())
        {
            gasPriceET.setError(getString(R.string.erro_price_gas));
            correctValidation = false;

        }

        if (ethanolMilageET.getText().toString().isEmpty())
        {
            ethanolMilageET.setError(getString(R.string.erro_milage_etanol));
            correctValidation = false;

        }

        if (gasMilageET.getText().toString().isEmpty())
        {
            gasMilageET.setError(getString(R.string.erro_milage_gas));
            correctValidation = false;

        }

        return correctValidation;

    }
}
