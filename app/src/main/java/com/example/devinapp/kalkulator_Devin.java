package com.example.devinapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class kalkulator_Devin extends AppCompatActivity {

    EditText number1, number2;
    Button btnAdd, btnMul, btnDiv;
    TextView hasilAngka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_devin);

        // Inisialisasi komponen
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnAdd = findViewById(R.id.btn_add);
        btnMul = findViewById(R.id.btn_mul);
        btnDiv = findViewById(R.id.btn_div);
        hasilAngka = findViewById(R.id.hasilAngka);

        // Tambah
        btnAdd.setOnClickListener(v -> {
            Double a = getInput(number1);
            Double b = getInput(number2);
            if (a != null && b != null) {
                hasilAngka.setText(String.valueOf(a + b));
            }
        });

        // Kali
        btnMul.setOnClickListener(v -> {
            Double a = getInput(number1);
            Double b = getInput(number2);
            if (a != null && b != null) {
                hasilAngka.setText(String.valueOf(a * b));
            }
        });

        // Bagi
        btnDiv.setOnClickListener(v -> {
            Double a = getInput(number1);
            Double b = getInput(number2);
            if (a != null && b != null) {
                if (b == 0) {
                    Toast.makeText(this, "Tidak bisa dibagi 0", Toast.LENGTH_SHORT).show();
                } else {
                    hasilAngka.setText(String.valueOf(a / b));
                }
            }
        });
    }

    // Fungsi bantu untuk validasi input
    private Double getInput(EditText editText) {
        String input = editText.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Masukkan angka!", Toast.LENGTH_SHORT).show();
            return null;
        }
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Input tidak valid!", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}