package com.tejaswi.accessiblepayments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAddTransaction;
    RecyclerView recyclerView;

    ArrayList<Transaction> transactions;
    TransactionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTransaction = findViewById(R.id.btnAddTransaction);
        recyclerView = findViewById(R.id.recyclerTransactions);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAddTransaction.setOnClickListener(v -> {
            startActivity(new Intent(
                    MainActivity.this,
                    AddTransactionActivity.class
            ));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTransactions();
    }

    private void loadTransactions() {
        SharedPreferences prefs = getSharedPreferences("transactions", MODE_PRIVATE);
        String json = prefs.getString("transaction_list", null);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Transaction>>() {}.getType();

        if (json == null) {
            transactions = new ArrayList<>();
        } else {
            transactions = gson.fromJson(json, type);
        }

        adapter = new TransactionAdapter(transactions);
        recyclerView.setAdapter(adapter);
    }
}
