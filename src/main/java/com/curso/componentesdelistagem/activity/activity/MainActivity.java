package com.curso.componentesdelistagem.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.curso.componentesdelistagem.R;
import com.curso.componentesdelistagem.activity.RecyclerItemClickListener;
import com.curso.componentesdelistagem.activity.adapter.AdapterFilmes;
import com.curso.componentesdelistagem.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerFilmes;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerFilmes = findViewById(R.id.recyclerFilmes);

        //Listagem de filmes
        this.criarFilmes();

        //configurar adapter
        AdapterFilmes adapterFilmes = new AdapterFilmes(listaFilmes);

        //configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerFilmes.setLayoutManager(layoutManager);
        recyclerFilmes.setHasFixedSize(true); // otimizar o recyclerview tendo um tamanho fixo
        recyclerFilmes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL)); //criar um divisor para um linearlayout vertical
        recyclerFilmes.setAdapter(adapterFilmes);

        //evento de click
        recyclerFilmes.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerFilmes, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(getApplicationContext(), "Item pressionado: " + filme.getTituoFilme(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(getApplicationContext(), "Click longo: " + filme.getTituoFilme(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão América - Guerra Civil", "Aventura/Ficção", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O Filme", "Comédia/Animação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A múmia", "Terror", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia", "2017");
        this.listaFilmes.add(filme);
    }
}
