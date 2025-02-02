package com.example.adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Map;

public class ProductActivity extends AppCompatActivity {

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Map<Integer, Integer> imgPath = Map.of(
                1, R.drawable.milk,
                2, R.drawable.sugar,
                3, R.drawable.juce,
                4, R.drawable.laptop,
                5, R.drawable.chocolate
        );

        Map<Integer, String> productText = Map.of(
                1, "Напиток для тех, кто хочет остаться сильным, но слишком ленив, чтобы жевать коровью траву.",
                2, "Крошечные кристаллики радости, которые спасают утро и добавляют смысл чаю.",
                3, "Жидкое золото, добытое прямо из сада, где яблоки улыбаются солнцу.",
                4, "Магическая коробка, в которой можно работать, играть и внезапно решать все проблемы мира... кроме тех, что он сам создаёт.",
                5, "Твой антистресс в обёртке, готовый превратить любой день в сладкое приключение."
        );

        ImageView img = findViewById(R.id.image);
        TextView txt = findViewById(R.id.text);
        backBtn = findViewById(R.id.backBtn);

        Integer id = MainActivity.selectedProduct;

        img.setBackgroundResource(imgPath.get(id));
        txt.setText(productText.get(id));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}