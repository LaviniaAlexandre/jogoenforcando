package com.example.enforcando;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
    private ArrayList<Integer> listaIdsButtons;
    private int indiceListaImagem, contaAcerto, contaErro;

    private TextView texto, txAcerto, txErro;

    private Button b1;

    private String palavra;
    private char[] estado;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_jogo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.id08), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txAcerto = findViewById(R.id.textView4);
        txErro = findViewById(R.id.textView8);
        contaAcerto = 0;
        contaErro = 0;
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

        listaIdsButtons = new ArrayList<Integer>();
        listaIdsButtons.add(R.id.id01);
        listaIdsButtons.add(R.id.id02);
        listaIdsButtons.add(R.id.id03);
        listaIdsButtons.add(R.id.id04);
        listaIdsButtons.add(R.id.id05);
        listaIdsButtons.add(R.id.id06);
        listaIdsButtons.add(R.id.id07);
        listaIdsButtons.add(R.id.id08);
        listaIdsButtons.add(R.id.id09);
        listaIdsButtons.add(R.id.id10);
        listaIdsButtons.add(R.id.id11);
        listaIdsButtons.add(R.id.id12);
        listaIdsButtons.add(R.id.id13);
        listaIdsButtons.add(R.id.id14);
        listaIdsButtons.add(R.id.id15);
        listaIdsButtons.add(R.id.id16);
        listaIdsButtons.add(R.id.id17);
        listaIdsButtons.add(R.id.id18);
        listaIdsButtons.add(R.id.id19);
        listaIdsButtons.add(R.id.id20);
        listaIdsButtons.add(R.id.id21);
        listaIdsButtons.add(R.id.id22);
        listaIdsButtons.add(R.id.id23);
        listaIdsButtons.add(R.id.id24);
        listaIdsButtons.add(R.id.id25);
        listaIdsButtons.add(R.id.id26);

        for (int j = 0; j<listaIdsButtons.size();j++)
        {
            Button b = findViewById(listaIdsButtons.get(j));
            b.setOnClickListener(this);
        }

    }
     private String sorteiapalavras(){
        String retorno = new String();
         Collections.shuffle(listapalavras);
         retorno = listapalavras.get(0);
         return retorno;
     }

     public void inicializajogo(){
        imagem.setImageResource((R.drawable.forca_0_9));
        indiceListaImagem = 0;
        palavra = sorteiapalavras();
        estado = new char[palavra.length()];
        for(int i=0; i<estado.length;i++){
            estado[i] = '_';
        }

        txAcerto.setText("o");
        txAcerto.setText(Integer.toString((contaAcerto))'+'/'+' Integer.toString(listaimagens.size());
        atualizatexto();
         for (int j = 0; j<listaIdsButtons.size();j++)
         {
             Button b = findViewById(listaIdsButtons.get(j));
             b.setEnabled(true);
         }
     }

     public void cheaseterminou(){
        boolean verifica = false;
        for(int i=0; i<estado.length; i++) {
            if (estado [i]=='-') {
                //se der true, ainda tem jogo
                verifica = true;
            }
         }
        //se tiver false, é pq ganhou
         if(!verifica){
             AlertDialog.Builder caixa = new AlertDialog.Builder(this);
             caixa.setTitle("Você Venceu!!!!!");
             caixa.setMessage("Deseja jogar novamente??");
             caixa.setPositiveButton("Jogar", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     inicializajogo();
                 }
             });
             caixa.show();
         }
         if(contaErro >= listaimagens.size()){
             AlertDialog.Builder caixa = new AlertDialog.Builder(this);
             caixa.setTitle("Você Perdeu Playboy!!!!!");
             caixa.setMessage("Deseja jogar novamente??");
             caixa.setPositiveButton("Jogar", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     inicializajogo();
                 }
             });
             caixa.show();
         }
     }

     public void verificaLetra(char c){
        boolean status = false;
        for(int i=0; i<palavra.length();i++){
            if(palavra.charAt(i)==c){
                status = true;
                estado[i] = c;
            }
         }
        if(status){
            atualizaForca();
            contaErro++;
            txErro.setText(Integer.toString((contaErro))"+"/"+" Integer.toString(listaimagens.size()));
        }
        else {
            atualizatexto();
            contaAcerto++;
            txAcerto.setText(Integer.toString((contaAcerto))"+"/"+" Integer.toString(listaimagens.size()));

        }
         cheaseterminou();
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
        atualizaForca();
        texto = findViewById(R.id.textView3);
        imagem.setImageResource(listaimagens.get(indiceListaImagem));
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        verificaLetra(b.getText().toString().charAt(0));
        b.setEnabled(false);
        texto.setText(b.getText().toString());

    }

}