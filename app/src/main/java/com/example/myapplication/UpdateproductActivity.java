package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class UpdateproductActivity extends AppCompatActivity {
    EditText txtInputNameProduct,txtDesProduct,txtPriceProduct;
    Spinner spnTypeProduct;
    Button btnUpdateProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update_product);
        setControl();
        setEvent();
    }

    private void setEvent() {
    }

    private void setControl() {
        txtInputNameProduct = findViewById(R.id.txtInputNameProduct);
        txtPriceProduct = findViewById(R.id.txtPriceProduct);
        txtDesProduct = findViewById(R.id.txtDesProduct);
        spnTypeProduct = findViewById(R.id.spnTypeProduct);
        btnUpdateProduct = findViewById(R.id.btnUpdateProduct);
    }
}