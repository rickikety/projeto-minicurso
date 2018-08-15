package br.com.ricardo.minhas_receitas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.ricardo.minhas_receitas.adapter.RecyclerViewAdapter;
import br.com.ricardo.minhas_receitas.model.Receita;

public class ListaReceitasActivity extends AppCompatActivity {

    private List<Receita> receitas = new ArrayList<>();

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter; // classe que criei

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_receitas);

        initData();

        // procedimento para inserir na recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.lista_receita);
        adapter = new RecyclerViewAdapter(receitas, getBaseContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void initData(){

        // primeira receita
        List<String> ingredientes1 = new ArrayList<>();

        ingredientes1.add("1 - 12 bananas");
        ingredientes1.add("2 - 2 xicaras de açucar");
        ingredientes1.add("3 - 4 gemas");
        ingredientes1.add("4 - 2 colheres de sopa de manteiga");
        ingredientes1.add("5 - 4 claras em neve");
        ingredientes1.add("6 - 1 xicara de leite");
        ingredientes1.add("7 - 2 xicaras de farinha de trigo");
        ingredientes1.add("8 - 1 colher de fermento em pó");

        List<String> modoPreparo1 = new ArrayList<>();
        modoPreparo1.add("1 - Bater as claras em neve");
        modoPreparo1.add("2 - Bater as gemas com açucar");
        modoPreparo1.add("3 - Acresentar a manteiga, o leite e a farinha");
        modoPreparo1.add("4 - Acresente as claras de neve e o fermento");
        modoPreparo1.add("5 - Colocar a massa e cobrir com bananas");
        modoPreparo1.add("6 - Assar no forno a 200C por 30 minutos");

        Receita receita1 = new Receita(R.drawable.banana, "Bolo de banana", ingredientes1, modoPreparo1);

        List<String> ingredientes2 = new ArrayList<>();
        ingredientes2.add("1 - 1 lata de leite condensado");
        ingredientes2.add("2 - 1 lata de suco de maracujá");
        ingredientes2.add("3 - 1 lata de creme de leite sem soro");

        List<String> modoPreparo2 = new ArrayList<>();
        modoPreparo2.add("1 - Bata o leite condensado, o creme de leite e o suco");
        modoPreparo2.add("2 - Insira a mistura em uma tigela, e deixe na geladeira");

        Receita receita2 = new Receita(R.drawable.maracuja, "Mousse de maracujá", ingredientes2, modoPreparo2);

        receitas.add(receita1);
        receitas.add(receita2);

    }
}
