package com.example.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.n1.CadastroActivity.MEDIA_FINAL;

public class MediaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        Intent intent = getIntent();

        String nomeEstudante = intent.getStringExtra(CadastroActivity.NOME_ESTUDANTE);
        float mediaFinal = intent.getFloatExtra(MEDIA_FINAL, 0);

      String resultadoFinal =  mediaFinal >=7 ? " Aprovado (a)" :  " Reprovado (a)";

       TextView nome = (TextView) findViewById(R.id.textNome);
       nome.setText(nomeEstudante);

       TextView media = (TextView) findViewById(R.id.textMediaFinal);
       media.setText(String.valueOf(mediaFinal));

        TextView resultado = (TextView) findViewById(R.id.textResultado);
        resultado.setText(resultadoFinal);
    }
}
