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

    String[] titre_couleur;
    String[] description_couleur;
    int[] images;
    Context context;

    public CouleursAdapter(Context ct, String[] titre, String[] description, int[] img) {
        context = ct;
        titre_couleur = titre;
        description_couleur = description;
        images = img;
    }

    public static class CouleursViewHolder extends RecyclerView.ViewHolder{
        TextView titreCouleur, descriptionCouleur;
        ImageView imageCouleur;
        ConstraintLayout mainLayout;
        public CouleursViewHolder(@NonNull View itemView) {
            super(itemView);
            titreCouleur = itemView.findViewById(R.id.titre_couleur);
            descriptionCouleur = itemView.findViewById(R.id.description_couleur);
            imageCouleur = itemView.findViewById(R.id.img_couleur);
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
        holder.titreCouleur.setText(titre_couleur[position]);
        holder.descriptionCouleur.setText(description_couleur[position]);
        holder.imageCouleur.setImageResource(images[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("titre_couleur", titre_couleur[holder.getAdapterPosition()]);
                intent.putExtra("description_couleur", description_couleur[holder.getAdapterPosition()]);
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
