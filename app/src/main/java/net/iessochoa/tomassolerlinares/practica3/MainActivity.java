package net.iessochoa.tomassolerlinares.practica3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnNuevo;
    Button btnCancel;

    TextView txtContactos;

    /**
     * Método encargado de generar los datos cuando se inicia la aplicación.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtenemos una referencia a los controles de la interfaz.
        btnNuevo = (Button)findViewById(R.id.btnNuevo);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        txtContactos = (TextView)findViewById(R.id.txtContactos);
        //Implementamos el evento al hacer click en el botón Nuevo.
        btnNuevo.setOnClickListener(v -> {
            Intent intent = new Intent( MainActivity.this, NuevoContactoActivity.class);
            startActivityForResult(intent, 123);
        });
        //Implementamos el evento al hacer click en el botón Cancel.
        btnCancel.setOnClickListener(v -> finish());
    }

    /**
     * Método encargado de recoger los datos obtenidos de la clase NuevoContactoActivity
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @SuppressLint("SetTextI18n")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //En caso de recibir datos válidos, se almacenan en el TextView.
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "No se ha creado ningún contacto", Toast.LENGTH_SHORT).show();
        } else {
            String contactos = data.getExtras().getString("CONTACTO");
            txtContactos.setText(txtContactos.getText()+ contactos + System.getProperty("line.separator"));
        }
    }
}