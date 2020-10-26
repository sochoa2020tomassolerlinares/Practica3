package net.iessochoa.tomassolerlinares.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivyForResultActivity extends AppCompatActivity {

    EditText edtTexto;
    Button btnAceptar;
    Button btnCancelar;

    /**
     * Método encargado de generar los datos cuando se inicia la clase.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activy_for_result);
        //Obtenemos una referencia a los controles de la interfaz
        edtTexto = (EditText)findViewById(R.id.edtTexto);
        btnAceptar = (Button)findViewById(R.id.btnAceptar);
        btnCancelar = (Button)findViewById(R.id.btnCancelar);

        Bundle bundle = getIntent().getExtras();
        String textoHint = bundle.getString("textoHint");

        edtTexto.setHint(textoHint);

        //Implementamos el evento al hacer click en botón Aceptar.
        btnAceptar.setOnClickListener(v -> {
            //Detecta si los el textView tiene datos.
            //De ser así, envia los datos a NuevoContactoActivity.
            //En caso de no haber ningún dato, muestra un mensaje de error.
            if (edtTexto.getText().length() != 0) {
                String texto = edtTexto.getText().toString();
                Intent intent = getIntent();
                intent.putExtra("TEXTO", texto);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(StartActivyForResultActivity.this, "Error. Debe de introducir texto...", Toast.LENGTH_SHORT).show();
            }
        });

        //Implementamos el evento al hacer click en el botón Cancel.
        btnCancelar.setOnClickListener(v -> {
            //Enviamos un resultado cancelado a NuevoContactoActivity y cerramos la ventana actual.
            setResult(RESULT_CANCELED);
            finish();
        });
    }


}