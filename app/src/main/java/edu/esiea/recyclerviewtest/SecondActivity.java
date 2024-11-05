package edu.esiea.recyclerviewtest;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Test","Test");
    }

    private void getData() {
        if (getIntent().hasExtra("titre_couleur") && getIntent().hasExtra("description_couleur") && getIntent().hasExtra("image_couleur")) {
            Log.i("Ye","On est dedans");

            String titre = getIntent().getStringExtra("titre_couleur");
            String description = getIntent().getStringExtra("description_couleur");
            int image = getIntent().getIntExtra("image_couleur", 0);

            TextView t = findViewById(R.id.titleReceived);
            TextView d = findViewById(R.id.descriptionreceived);
            ImageView i = findViewById(R.id.imageReceived);

            t.setText(titre);
            d.setText(description);
            i.setImageResource(image);
        }
        else {
            Log.d("Missing Data", String.valueOf(getIntent()));
        }
    }
}
