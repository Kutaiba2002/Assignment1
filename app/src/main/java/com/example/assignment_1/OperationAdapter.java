package com.example.assignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.ViewHolder> {


    private final RecyclerInterface recyclerInterface;
    ArrayList<Operation> operations = new ArrayList<>();

    public OperationAdapter(ArrayList<Operation> operations, RecyclerInterface recyclerInterface) {
        this.operations = operations;
        this.recyclerInterface= recyclerInterface;
    }

    @NonNull
    @Override
    public OperationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(v, recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull OperationAdapter.ViewHolder holder, int position) {

        Operation operation = operations.get(position);
        holder.txt.setText(operation.getOperation());
        holder.imageView.setImageResource(operation.getImageId());
        holder.cardView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.recycler_animation));
    }

    @Override
    public int getItemCount() {
        return operations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt;
        public ImageView imageView;
        public CardView cardView;
        public ViewHolder(@NonNull View itemView, RecyclerInterface recyclerInterface) {
            super(itemView);
            txt = itemView.findViewById(R.id.operationText);
            imageView = itemView.findViewById(R.id.imageCard);
            cardView = itemView.findViewById(R.id.cardView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(recyclerInterface != null){

                        int pos = getBindingAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){

                            recyclerInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
