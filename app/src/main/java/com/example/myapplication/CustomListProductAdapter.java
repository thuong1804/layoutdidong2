package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class CustomListProductAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Product> data;
    DatabaseReference data_product;
    EditText idProduct, tvIdProduct;


    public CustomListProductAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> data,EditText idProduct, DatabaseReference data_product) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.idProduct = idProduct;
        this.data_product = data_product;

    }
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        TextView tvnameProduct = convertView.findViewById(R.id.tvnameProduct);
        TextView tvtotalProduct = convertView.findViewById(R.id.tvtotalProduct);
        ImageView imageProduct = convertView.findViewById(R.id.imageProduct);
        Button btnLvXoa = convertView.findViewById(R.id.btnLvXoa);
        EditText tvIdProduct = convertView.findViewById(R.id.tvIdProduct);
        Button btnLvSua = convertView.findViewById(R.id.btnLvSua);
        btnLvSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = data.get(position);
                Intent i = new Intent(context, UpdateproductActivity.class);
                i.putExtra("PRODUCT_ID", product.getId());
                Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                context.startActivity(i);
            }
        });
        btnLvXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomListProductAdapter.this.getContext(), android.R.style.Theme_Material_Light_Dialog_NoActionBar);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn muốn xoá sản phẩm này");
                builder.setIcon(R.drawable.mode);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        data_product.child(tvIdProduct.getText().toString()).removeValue();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });

        Product product = data.get(position);

        if (product != null) {
            tvnameProduct.setText(product.getNameProduct());
            tvtotalProduct.setText(product.getPriceProduct());
            tvIdProduct.setText(product.getId());
            imageProduct.setImageResource(
                    getContext().getResources().getIdentifier(product.getImgProduct(), "drawable", getContext().getPackageName())
            );
            if(product.getTypeProduct().equalsIgnoreCase("Iphone")){
                imageProduct.setImageResource(R.drawable.iphone);
            }
            if(product.getTypeProduct().equalsIgnoreCase("SamSung")){
                imageProduct.setImageResource(R.drawable.samsung1);
            }

        }

        return convertView;
    }
    public void updateIdProduct(EditText newIdProduct) {
        idProduct = newIdProduct;
    }
}
