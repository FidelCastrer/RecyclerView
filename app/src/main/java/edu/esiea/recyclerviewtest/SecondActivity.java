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
        if (getIntent().hasExtra("color_title") && getIntent().hasExtra("color_description") && getIntent().hasExtra("color_image")) {

            String title = getIntent().getStringExtra("color_title");
            String description = getIntent().getStringExtra("color_description");
            int image = getIntent().getIntExtra("color_image", 0);

            TextView t = findViewById(R.id.titleReceived);
            TextView d = findViewById(R.id.descriptionReceived);
            ImageView i = findViewById(R.id.imageReceived);

            t.setText(title);
            d.setText(description);
            i.setImageResource(image);
        }
        else {
            Log.e("Missing Data","title : "+getIntent().getStringExtra("color_title")+" || desc : "+getIntent().getStringExtra("color_description")+" || image : "+getIntent().getStringExtra("color_image"));
        }
    }
}
