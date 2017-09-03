package br.com.fernandosousa.brewerapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class TelaInicialActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        String nome = params.getString("nome");

        Log.d(DEBUG_TAG, "Nome do usuário: " + nome);
        Toast.makeText(TelaInicialActivity.this, "Nome do usuário: " + nome, Toast.LENGTH_LONG).show();

        TextView texto = (TextView) findViewById(R.id.textoInicial);
        texto.setText(nome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_atualizar) {
            Toast.makeText(TelaInicialActivity.this,
                    "Atualizar",
                    Toast.LENGTH_SHORT).show();
        } else if(id == R.id.action_buscar) {
            Toast.makeText(TelaInicialActivity.this,
                    "Buscar",
                    Toast.LENGTH_SHORT).show();
        } else if(id == R.id.action_adicionar) {
            Toast.makeText(TelaInicialActivity.this,
                    "Buscar",
                    Toast.LENGTH_SHORT).show();
            Intent it = new Intent(TelaInicialActivity.this, CadastroActivity.class);
            startActivityForResult(it, 1);
        } else if(id == R.id.action_config) {
            Toast.makeText(TelaInicialActivity.this,
                    "Config",
                    Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.action_share) {
            Toast.makeText(TelaInicialActivity.this,
                    "Compartilhar",
                    Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                StringBuffer textoRetorno = new StringBuffer();
                textoRetorno.append(data.getStringExtra("nomeCerveja"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("tipoCerveja"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("paisCerveja"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("enderecoCerveja"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("precoCerveja"));

                TextView texto = (TextView)findViewById(R.id.textoInicial);
                texto.setText(textoRetorno.toString());

            }
        }
    }

}
