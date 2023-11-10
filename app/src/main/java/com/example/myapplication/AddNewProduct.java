package com.example.myapplication;

import androidx.annotation.NonNull;

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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddNewProduct extends MainActivity {
   Spinner spnTypeProduct;
   ImageView imgSelectProduct;
   Button btnSaveProduct, btn;
   ArrayList<Product>data;
   EditText txtInputNameProduct, txtDesProduct, idProduct, txtPriceProduct,txtImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_addnew_product);
        setControl();
        setEvent();
    }
    private void setEvent(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spnTypeProduct, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTypeProduct.setAdapter(adapter);
        spnTypeProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedType = spnTypeProduct.getSelectedItem().toString();
                if (selectedType.equalsIgnoreCase("iphone")) {
                    imgSelectProduct.setImageResource(R.drawable.iphone);
                    txtImage.setText("iphone");
                }
                else if(selectedType.equalsIgnoreCase("samsung")){
                    imgSelectProduct.setImageResource(R.drawable.samsung1);
                    txtImage.setText("samsung");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                product.setId(data_product.push().getKey());
                product.setNameProduct(txtInputNameProduct.getText().toString());
                product.setTypeProduct(spnTypeProduct.getSelectedItem().toString());
                product.setPriceProduct(txtPriceProduct.getText().toString());
                product.setImgProduct(txtImage.getText().toString());
                product.setDesProduct(txtDesProduct.getText().toString());
                data_product.child(product.getId()).setValue(product);
                data_product.child(product.id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Product product1 = snapshot.getValue(Product.class);
                            if (product1 != null) {
                                idProduct.setText(product1.getId());
                                txtInputNameProduct.setText(product1.getNameProduct());
                                txtDesProduct.setText(product1.getDesProduct());
                                txtPriceProduct.setText(product1.getPriceProduct());
                                txtImage.setText(product1.getImgProduct());
                                String typeProduct = product1.getTypeProduct();
                                int position = adapter.getPosition(typeProduct); // Replace 'adapter' with your Spinner adapter
                                spnTypeProduct.setSelection(position);
                                Intent i = new Intent(AddNewProduct.this, MainActivity.class);
                                Toast.makeText(AddNewProduct.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                                startActivity(i);
                            }
                        } else {
                            Toast.makeText(AddNewProduct.this, "Sản phẩm đã tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


    }

    private void setControl(){
        spnTypeProduct = findViewById(R.id.spnTypeProduct);
        imgSelectProduct = findViewById(R.id.imgSelectProduct);
        btnSaveProduct = findViewById(R.id.btnSaveProduct);
        txtInputNameProduct = findViewById(R.id.txtInputNameProduct);
        txtDesProduct = findViewById(R.id.txtDesProduct);
        txtPriceProduct = findViewById(R.id.txtPriceProduct);
        idProduct = findViewById(R.id.idProduct);
        txtImage = findViewById(R.id.txtImage);

    }
}