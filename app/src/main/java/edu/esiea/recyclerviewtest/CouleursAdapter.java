package edu.esiea.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CouleursAdapter extends RecyclerView.Adapter<CouleursAdapter.CouleursViewHolder> {

    String[] color_title;
    String[] color_description;
    int[] images;
    Context context;

    public CouleursAdapter(Context ct, String[] titre, String[] description, int[] img) {
        context = ct;
        color_title = titre;
        color_description = description;
        images = img;
    }

    public static class CouleursViewHolder extends RecyclerView.ViewHolder{
        TextView colorTitle, colorDescription;
        ImageView colorImage;
        ConstraintLayout mainLayout;
        public CouleursViewHolder(@NonNull View itemView) {
            super(itemView);
            colorTitle = itemView.findViewById(R.id.color_title);
            colorDescription = itemView.findViewById(R.id.color_description);
            colorImage = itemView.findViewById(R.id.color_image);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

    @NonNull
    @Override
    public CouleursAdapter.CouleursViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CouleursViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CouleursAdapter.CouleursViewHolder holder, int position) {
        holder.colorTitle.setText(color_title[position]);
        holder.colorDescription.setText(color_description[position]);
        holder.colorImage.setImageResource(images[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("color_title", color_title[holder.getAdapterPosition()]);
                intent.putExtra("color_description", color_description[holder.getAdapterPosition()]);
                intent.putExtra("image_couleur", images[holder.getAdapterPosition()]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
