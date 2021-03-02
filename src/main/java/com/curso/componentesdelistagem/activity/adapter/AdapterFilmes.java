package com.curso.componentesdelistagem.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.curso.componentesdelistagem.R;
import com.curso.componentesdelistagem.activity.model.Filme;

import java.util.List;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.MyViewHolder> {

    private List<Filme> listaFilmes;

    public AdapterFilmes(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    //criar as visualizações que aparece no usuario
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //converter em um objeto view
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista_filmes, parent, false);

        //criar o item lista e passa o itemLista
        return new MyViewHolder(itemLista);
    }

    //reciclar as visualizacoes que mostraram pro usuario
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Filme filme = listaFilmes.get(position);

        holder.titulo.setText(filme.getTituoFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
    }

    //retorna a quantidade de itens que vai ser exibido
    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    //classe para guardar os dados antes de ser exibido na tela
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo, ano, genero;

        public MyViewHolder(View itemView) {
            super(itemView);

            //recuperar componentes de tela
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
