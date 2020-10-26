package net.iessochoa.tomassolerlinares.practica3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NuevoContactoActivity extends AppCompatActivity {
    private final static int option_request_nombre=1;
    private final static int option_request_apellido=2;
    private final static int option_request_empresa=3;

    TextView txtNombre;
    TextView txtApellidos;
    TextView txtEmpresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        txtNombre = (TextView)findViewById(R.id.txtNombre);
        txtApellidos = (TextView)findViewById(R.id.txtApellidos);
        txtEmpresa = (TextView)findViewById(R.id.txtEmpresa);

        TextView txtEdad = (TextView)findViewById(R.id.txtEdad);

        RadioGroup rdgEmpresas = (RadioGroup)findViewById(R.id.rdgEmpresas);
        RadioGroup rdgSexo = (RadioGroup)findViewById(R.id.rdgSexo);

        RadioButton rdbEmpresa = (RadioButton)findViewById(R.id.rdbEmpresa);
        RadioButton rdbParticular = (RadioButton)findViewById(R.id.rdbParticular);
        RadioButton rdbHombre = (RadioButton)findViewById(R.id.rdbHombre);
        RadioButton rdbMujer = (RadioButton)findViewById(R.id.rdbMujer);

        Switch swcFavorito = (Switch)findViewById(R.id.swcFavorito);

        SeekBar skbEdad = (SeekBar)findViewById(R.id.skbEdad);
        skbEdad.setMax(getResources().getInteger(R.integer.maximaEdad));
        skbEdad.setProgress(getResources().getInteger(R.integer.maximaEdad)/2);

        CheckBox ckbRecordarLlamar = (CheckBox)findViewById(R.id.ckbRecordarLlamar);

        EditText edtTelefono = (EditText)findViewById(R.id.edtTelefono);

        ImageView imgEmpresa = (ImageView)findViewById(R.id.imgEmpresa);
        imgEmpresa.setVisibility(View.INVISIBLE);
        ImageView imgFav = (ImageView)findViewById(R.id.imgFav);
        imgFav.setVisibility(View.INVISIBLE);
        ImageView imgSexo = (ImageView)findViewById(R.id.imgSexo);
        imgFav.setImageResource(R.drawable.ic_favourite);
        imgSexo.setVisibility(View.INVISIBLE);
        ImageView imgTelefono = (ImageView)findViewById(R.id.imgTelefono);
        imgTelefono.setImageResource(R.drawable.ic_phone);
        imgTelefono.setVisibility(View.INVISIBLE);

        Button btnOk = (Button)findViewById(R.id.btnOk);
        Button btnCancel = (Button)findViewById(R.id.btnCancel);

        txtNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevoContactoActivity.this, StartActivyForResultActivity.class);
                intent.putExtra("textoHint", "Nombre: ");
                startActivityForResult(intent, option_request_nombre);
            }
        });

        txtApellidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevoContactoActivity.this, StartActivyForResultActivity.class);
                intent.putExtra("textoHint", "Apellidos: ");
                startActivityForResult(intent, option_request_apellido);
            }
        });

        txtEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevoContactoActivity.this, StartActivyForResultActivity.class);
                intent.putExtra("textoHint", "Empresa: ");
                startActivityForResult(intent, option_request_empresa);
            }
        });

        rdgEmpresas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                imgEmpresa.setVisibility(View.VISIBLE);
                switch (checkedId) {
                    case R.id.rdbEmpresa:
                        imgEmpresa.setImageResource(R.drawable.ic_business);
                        break;
                    case R.id.rdbParticular:
                        imgEmpresa.setImageResource(R.drawable.ic_person);
                        break;
                }
            }
        });

        rdgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                imgSexo.setVisibility(View.VISIBLE);
                switch (checkedId) {
                    case R.id.rdbHombre:
                        imgSexo.setImageResource(R.drawable.ic_male);
                        break;
                    case R.id.rdbMujer:
                        imgSexo.setImageResource(R.drawable.ic_female);
                        break;
                }
            }
        });

        swcFavorito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    imgFav.setVisibility(View.VISIBLE);
                } else{
                    imgFav.setVisibility(View.INVISIBLE);
                }
            }
        });

        ckbRecordarLlamar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton CheckBox, boolean isChecked) {
                if(isChecked){
                    imgTelefono.setVisibility(View.VISIBLE);
                } else{
                    imgTelefono.setVisibility(View.INVISIBLE);
                }
            }
        });

        skbEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtEdad.setText("Edad: " + progress);
                Toast.makeText(NuevoContactoActivity.this, "Edad: "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().length() != 0 || !txtNombre.getText().equals("Nombre: ")) {
                    String nombre = txtNombre.getText().toString();
                    String apellidos = txtApellidos.getText().toString();
                    String telefono = edtTelefono.getText().toString();
                    Intent intent = getIntent();
                    intent.putExtra("CONTACTO", nombre + " " + apellidos + " - " + telefono);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(NuevoContactoActivity.this, "No se ha introducido un nombre de contacto y/o un número de teléfono", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Se ha cancelado la acción", Toast.LENGTH_SHORT).show();
        } else {
            String texto = data.getExtras().getString("TEXTO");
            switch (requestCode) {
                case option_request_nombre:
                    txtNombre.setText(texto);
                    break;
                case option_request_apellido:
                    txtApellidos.setText(texto);
                    break;
                case option_request_empresa:
                    txtEmpresa.setText(texto);
                    break;
            }
        }
    }
}