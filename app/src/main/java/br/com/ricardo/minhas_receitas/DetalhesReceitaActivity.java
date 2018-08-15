package br.com.ricardo.minhas_receitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.com.ricardo.minhas_receitas.model.Receita;

public class DetalhesReceitaActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView texto;
    private ListView ingredientes, modoPreparo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_receita);

        imageView = (ImageView) findViewById(R.id.detalhes_imagem);
        texto = (TextView) findViewById(R.id.titulo_receita);
        ingredientes = (ListView) findViewById(R.id.lista_ingredientes);
        modoPreparo = (ListView) findViewById(R.id.lista_modo_preparo);

        if (getIntent() != null) {
            Receita receita = (Receita) getIntent().getSerializableExtra("receita");
            imageView.setImageResource(receita.getId_imagem());
            texto.setText(receita.getTituloReceita());

            ArrayAdapter<String> adapterIng = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, receita.getIngredientes());
            ArrayAdapter<String> adapterMd = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, receita.getModoPreparo());

            ingredientes.setAdapter(adapterIng);
            modoPreparo.setAdapter(adapterMd);
        }
    }
}
