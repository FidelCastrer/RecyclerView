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

    RecyclerView rv_couleurs;

    String[] titres;
    String[] descriptions;
    int[] images = {R.drawable.rouge, R.drawable.vert, R.drawable.jaune, R.drawable.violet, R.drawable.bleu, R.drawable.gris, R.drawable.orange, R.drawable.rose, R.drawable.cyan, R.drawable.marron };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv_couleurs = findViewById(R.id.rv_couleurs);

        titres = getResources().getStringArray(R.array.couleur);
        descriptions = getResources().getStringArray(R.array.desc);

        CouleursAdapter couleursAdapter = new CouleursAdapter(this, titres, descriptions, images);
        rv_couleurs.setHasFixedSize(true);
        rv_couleurs.setAdapter(couleursAdapter);
        rv_couleurs.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}