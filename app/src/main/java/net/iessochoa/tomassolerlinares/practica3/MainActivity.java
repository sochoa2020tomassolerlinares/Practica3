package net.iessochoa.tomassolerlinares.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNuevo = (Button)findViewById(R.id.btnNuevo);
        Button btnCancel = (Button)findViewById(R.id.btnCancel);
        txtContactos = (TextView)findViewById(R.id.txtContactos);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, NuevoContactoActivity.class);
                startActivityForResult(intent, 123);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "No se ha creado ningún contacto", Toast.LENGTH_SHORT).show();
        } else {
            String contactos = data.getExtras().getString("CONTACTO");
            txtContactos.setText(txtContactos.getText()+"<br>"+ contactos);
        }
    }
}