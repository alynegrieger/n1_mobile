package com.example.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String NOME_ALUNO = "com.example.n1.NOME_ALUNO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.formSendName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastroActivity();
            }
        });

    }

    public void cadastroActivity() {

        EditText nomeInput = (EditText) findViewById(R.id.formNome);
        String nome = nomeInput.getText().toString();

        Intent intent = new Intent(this, CadastroActivity.class);
        intent.putExtra(NOME_ALUNO, nome);
        startActivity(intent);
    }

}


