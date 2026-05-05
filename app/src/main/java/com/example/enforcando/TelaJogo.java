package com.example.enforcando;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class TelaJogo extends AppCompatActivity implements View.OnClickListener{
    private ImageView imagem;

    private ArrayList<Integer> listaimagens;
    private ArrayList<String> listapalavras;
    private int indiceListaImagem;

    private TextView texto;

    private Button b1;

    private String palavra;
    private char[] estado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_jogo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.id08), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imagem = findViewById(R.id.imageView2);
        indiceListaImagem = -1;
        listaimagens = new ArrayList<Integer>();
        listaimagens.add(R.drawable.forca_1_9);
        listaimagens.add(R.drawable.forca_2_9);
        listaimagens.add(R.drawable.forca_3_9);
        listaimagens.add(R.drawable.forca_4_9);
        listaimagens.add(R.drawable.forca_5_9);
        listaimagens.add(R.drawable.forca_6_9);
        listaimagens.add(R.drawable.forca_7_9);
        listaimagens.add(R.drawable.forca_8_9);
        listaimagens.add(R.drawable.forca_10_9);
        listaimagens.add(R.drawable.forca_11_9);

        b1 = findViewById((R.id.id01));
        b1.setOnClickListener(this);

        listapalavras = new ArrayList<String>();
        listapalavras.add("DOCE");
        listapalavras.add("MORANGO");
        listapalavras.add("MACACO");
        listapalavras.add("PERFUME");
        listapalavras.add("CACHORRO");
        listapalavras.add("GATO");
        listapalavras.add("ROUPA");
        listapalavras.add("SUCO");
        listapalavras.add("MELANCIA");
        listapalavras.add("SAPATO");

        texto = findViewById(R.id.textView3);

    }
     private String sorteiapalavras(){
        String retorno = new String();
         Collections.shuffle(listapalavras);
         retorno = listapalavras.get(0);
         return retorno;
     }

     public void inicializajogo(){
        imagem.setImageResource((R.drawable.forca_0_9));
        palavra = sorteiapalavras();
        estado = new char[palavra.length()];
        for(int i=0; i<estado.length;i++){
            estado[1] = '_';
        }
     }

     public void  atualizatexto(){
        String temporaria = new String();
        temporaria="";
        for(int i=0; i<estado.length; i++){
            temporaria+= estado[i] + " ";
        }
        texto.setText(temporaria);
     }


    public void atualizaForca(){indiceListaImagem++;
        imagem.setImageResource(listaimagens.get(indiceListaImagem));
    }

    @Override
    public void onClick(View v) {
        atualizaForca();
        texto = findViewById(R.id.textView3);

    }
}