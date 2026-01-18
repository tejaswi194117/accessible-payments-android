package com.tejaswi.accessiblepayments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddTransactionActivity extends AppCompatActivity {

    EditText etAmount, etMerchant;
    Button btnSaveTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        etAmount = findViewById(R.id.etAmount);
        etMerchant = findViewById(R.id.etMerchant);
        btnSaveTransaction = findViewById(R.id.btnSaveTransaction);

        btnSaveTransaction.setOnClickListener(v -> {

            String amount = etAmount.getText().toString().trim();
            String merchant = etMerchant.getText().toString().trim();

            if (amount.isEmpty() || merchant.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences prefs = getSharedPreferences("transactions", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            Gson gson = new Gson();
            String json = prefs.getString("transaction_list", null);
            Type type = new TypeToken<ArrayList<Transaction>>() {}.getType();

            ArrayList<Transaction> list =
                    json == null ? new ArrayList<>() : gson.fromJson(json, type);

            list.add(new Transaction(amount, merchant));

            editor.putString("transaction_list", gson.toJson(list));
            editor.apply();

            Toast.makeText(this, "Transaction Saved", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
