package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class UpdateproductActivity extends MainActivity {
    EditText txtInputNameProduct,txtDesProduct,txtPriceProduct;
    Spinner spnTypeProduct;
    Button btnUpdateProduct;
    ImageView imgSelectProductUpdate;
    String productId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update_product);
        setControl();
        setEvent();
        productId = getIntent().getStringExtra("PRODUCT_ID");

    }

    private void setEvent() {
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spnTypeProduct, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spnTypeProduct.setAdapter(adapter);
//        spnTypeProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String selectedType = spnTypeProduct.getSelectedItem().toString();
//                if (selectedType.equalsIgnoreCase("iphone")) {
//                    imgSelectProductUpdate.setImageResource(R.drawable.iphone);
//                }
//                else if(selectedType.equalsIgnoreCase("samsung")){
//                    imgSelectProductUpdate.setImageResource(R.drawable.samsung1);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//  });
        btnUpdateProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// Lấy ID của sản phẩm cần cập nhật
                String newName = txtInputNameProduct.getText().toString();
                String newPrice = txtPriceProduct.getText().toString();
                String newDescription = txtDesProduct.getText().toString();
//                String newType = spnTypeProduct.getSelectedItem().toString();

                Product updatedProduct = new Product(productId, newName, "aa", "aa", newPrice, newDescription);
                data_product.child(productId).setValue(updatedProduct);
                Intent i = new Intent(UpdateproductActivity.this, MainActivity.class);
                Toast.makeText(UpdateproductActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }

    private void setControl() {
        txtInputNameProduct = findViewById(R.id.txtInputNameProduct);
        txtPriceProduct = findViewById(R.id.txtPriceProduct);
        txtDesProduct = findViewById(R.id.txtDesProduct);
        spnTypeProduct = findViewById(R.id.spnTypeProduct);
        btnUpdateProduct = findViewById(R.id.btnUpdateProduct);
    }
}