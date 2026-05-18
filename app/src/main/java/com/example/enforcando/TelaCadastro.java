package com.example.enforcando;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaCadastro extends AppCompatActivity, RadioGroup.OnCheckedChangeListener {

    private EditText textoDaPalavra;
    private Button btnCadastrar, btnListar;

    private RadioGroup grupo;

    private String categoriaSelecionada, palavra;


    public AppCompatActivityimplements View.

    OnClickListener {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textoDaPalavra = findViewById(R.id.Palavra);
        btnCadastrar = findViewById(R.id.configurações);
        btnCadastrar.set.OnClickListener(this);
        btnListar = findViewById(R.id.button3);
        btnListar.setOnClickListener(this);
        grupo = findViewById(R.id.id_grupo);
        grupo.setOnClickListener(this);

    }

    public void onClick(View view) {
        if (view == b) {
            startActivity(new Intent(this, TelaJogo.class));
        }
        if (view == b2) {
            startActivity(new Intent (this, TelaCadastro.class));
        }
    }

    public void onCheckedChanged(@NonNull RadioGroup, int i) {
        if (radioGroup == grupo) {
            RadioButton temporario = findViewById(i);
            Toast.makeText(TelaCadastro.this, temporario.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }

}