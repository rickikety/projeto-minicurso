package br.com.ricardo.minhas_receitas.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.ricardo.minhas_receitas.DetalhesReceitaActivity;
import br.com.ricardo.minhas_receitas.Interface.ItemClickListener;
import br.com.ricardo.minhas_receitas.ListaReceitasActivity;
import br.com.ricardo.minhas_receitas.R;
import br.com.ricardo.minhas_receitas.model.Receita;

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imageView;
    public TextView textView;
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.imageView = (ImageView) itemView.findViewById(R.id.ex_img);
        this.textView = (TextView) itemView.findViewById(R.id.ex_texto);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition());
    }
}


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    public List<Receita> receitas;
    public Context context;

    public RecyclerViewAdapter(List<Receita> exerciseList, Context context) {
        this.receitas = exerciseList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_receita, parent, false);

        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.imageView.setImageResource(receitas.get(position).getId_imagem());
        holder.textView.setText(receitas.get(position).getTituloReceita());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(context, DetalhesReceitaActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                //bundle.putSerializable("receita", receitas.get(position));
                intent.putExtra("receita", receitas.get(position));
                //intent.putExtra("img_id", exerciseList.get(position).getId_imagem());
                //intent.putExtra("name", exerciseList.get(position).getNome());
                // recebendo Receita receita = (Receita) intent.getSerializable("receita");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return receitas.size();
    }
}

