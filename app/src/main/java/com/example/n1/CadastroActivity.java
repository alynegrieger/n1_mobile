package com.example.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n1.R;

public class CadastroActivity extends AppCompatActivity {
    public static final int QUANTIDADE_NOTAS = 2;
    public static final String MEDIA_FINAL = "com.example.n1.MEDIA_FINAL";
    public static final String NOME_ESTUDANTE = "com.example.n1.NOME_ESTUDANTE";
    private EditText nota1;
    private EditText nota2;
    private String nomeAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nota1 = findViewById(R.id.formNota1);
        nota2 = findViewById(R.id.formNota2);
        Intent intent = getIntent();
        this.nomeAluno = intent.getStringExtra(MainActivity.NOME_ALUNO);


        Button botaoSalvar = (Button) findViewById(R.id.formSend);
        botaoSalvar.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick (View v) {
                Float notaUmValue = Float.parseFloat(nota1.getText().toString());
                Float notaDoisValue = Float.parseFloat(nota2.getText().toString());


                Float media = calculateMedia(notaUmValue, notaDoisValue);

                Intent intentMostraMedia = new Intent (CadastroActivity.this, MediaActivity.class );
                intentMostraMedia.putExtra(MEDIA_FINAL, media);
                intentMostraMedia.putExtra(NOME_ESTUDANTE, nomeAluno);
                startActivity(intentMostraMedia);


            }
        });

    }

    private Float calculateMedia(Float notaUm, Float notaDois) {
      return (notaUm + notaDois) / QUANTIDADE_NOTAS;
    }
}
