package edu.esiea.recyclerviewtest;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_colors;

    String[] titles;
    String[] descriptions;
    int[] images = {R.drawable.rouge, R.drawable.vert, R.drawable.jaune, R.drawable.violet, R.drawable.bleu, R.drawable.gris, R.drawable.orange, R.drawable.rose, R.drawable.cyan, R.drawable.marron };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv_colors = findViewById(R.id.rv_colors);

        titles = getResources().getStringArray(R.array.color);
        descriptions = getResources().getStringArray(R.array.desc);

        ColorsAdapter colorsAdapter = new ColorsAdapter(this, titles, descriptions, images);
        rv_colors.setHasFixedSize(true);
        rv_colors.setAdapter(colorsAdapter);
        rv_colors.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}