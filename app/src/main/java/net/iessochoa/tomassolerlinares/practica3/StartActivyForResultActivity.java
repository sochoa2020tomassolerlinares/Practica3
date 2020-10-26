package net.iessochoa.tomassolerlinares.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivyForResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activy_for_result);

        EditText edtTexto = (EditText)findViewById(R.id.edtTexto);
        Button btnAceptar = (Button)findViewById(R.id.btnAceptar);
        Button btnCancelar = (Button)findViewById(R.id.btnCancelar);

        Bundle bundle = getIntent().getExtras();
        String textoHint = bundle.getString("textoHint");

        edtTexto.setHint(textoHint);

        btnAceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (edtTexto.getText().length() != 0) {
                    String texto = edtTexto.getText().toString();
                    Intent intent = getIntent();
                    intent.putExtra("TEXTO", texto);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(StartActivyForResultActivity.this, "Error. Debe de introducir texto...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }


}