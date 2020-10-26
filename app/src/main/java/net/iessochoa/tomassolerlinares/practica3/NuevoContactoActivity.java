package net.iessochoa.tomassolerlinares.practica3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class NuevoContactoActivity extends AppCompatActivity {
    private final static int option_request_nombre=1;
    private final static int option_request_apellido=2;
    private final static int option_request_empresa=3;

    TextView txtNombre;
    TextView txtApellidos;
    TextView txtEmpresa;
    TextView txtEdad;

    RadioGroup rdgEmpresas;
    RadioGroup rdgSexo;

    RadioButton rdbEmpresa;
    RadioButton rdbParticular;
    RadioButton rdbHombre;
    RadioButton rdbMujer;

    Switch swcFavorito;

    SeekBar skbEdad;

    CheckBox ckbRecordarLlamar;

    EditText edtTelefono;

    ImageView imgEmpresa;
    ImageView imgFav;
    ImageView imgSexo;
    ImageView imgTelefono;

    Button btnOk;
    Button btnCancel;

    /**
     * Método encargado de generar los datos cuando se inicia la clase.
     * @param savedInstanceState
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        //Obtenemos una referencia a los botones de la interfaz.
        txtNombre = (TextView)findViewById(R.id.txtNombre);
        txtApellidos = (TextView)findViewById(R.id.txtApellidos);
        txtEmpresa = (TextView)findViewById(R.id.txtEmpresa);

        txtEdad = (TextView)findViewById(R.id.txtEdad);

        rdgEmpresas = (RadioGroup)findViewById(R.id.rdgEmpresas);
        rdgSexo = (RadioGroup)findViewById(R.id.rdgSexo);

        rdbEmpresa = (RadioButton)findViewById(R.id.rdbEmpresa);
        rdbParticular = (RadioButton)findViewById(R.id.rdbParticular);
        rdbHombre = (RadioButton)findViewById(R.id.rdbHombre);
        rdbMujer = (RadioButton)findViewById(R.id.rdbMujer);

        swcFavorito = (Switch)findViewById(R.id.swcFavorito);

        skbEdad = (SeekBar)findViewById(R.id.skbEdad);
        skbEdad.setMax(getResources().getInteger(R.integer.maximaEdad));
        skbEdad.setProgress(getResources().getInteger(R.integer.maximaEdad)/2);

        ckbRecordarLlamar = (CheckBox)findViewById(R.id.ckbRecordarLlamar);

        edtTelefono = (EditText)findViewById(R.id.edtTelefono);

        imgEmpresa = (ImageView)findViewById(R.id.imgEmpresa);
        imgEmpresa.setVisibility(View.INVISIBLE);

        imgFav = (ImageView)findViewById(R.id.imgFav);
        imgFav.setVisibility(View.INVISIBLE);
        imgFav.setImageResource(R.drawable.ic_favourite);

        imgSexo = (ImageView)findViewById(R.id.imgSexo);
        imgSexo.setVisibility(View.INVISIBLE);

        imgTelefono = (ImageView)findViewById(R.id.imgTelefono);
        imgTelefono.setImageResource(R.drawable.ic_phone);
        imgTelefono.setVisibility(View.INVISIBLE);

        btnOk = (Button)findViewById(R.id.btnOk);
        btnCancel = (Button)findViewById(R.id.btnCancelC);

        //Implementamos el evento al hacer click en el Texto Nombre.
        txtNombre.setOnClickListener(v -> {
            //Se crea un intent a StartActivyForResultAtcivity y se almacena el Hint con el texto Nombre:
            Intent intent = new Intent(NuevoContactoActivity.this, StartActivyForResultActivity.class);
            intent.putExtra("textoHint", "Nombre: ");
            startActivityForResult(intent, option_request_nombre);
        });

        //Implementamos el evento al hacer click en el Texto Apellidos.
        txtApellidos.setOnClickListener(v -> {
            //Se crea un intent a StartActivyForResultAtcivity y se almacena el Hint con el texto Apellidos:
            Intent intent = new Intent(NuevoContactoActivity.this, StartActivyForResultActivity.class);
            intent.putExtra("textoHint", "Apellidos: ");
            startActivityForResult(intent, option_request_apellido);
        });

        //Implementamos el evento al hacer click en el Texto Empresa.
        txtEmpresa.setOnClickListener(v -> {
            //Se crea un intent a StartActivyForResultAtcivity y se almacena el Hint con el texto Empresa:
            Intent intent = new Intent(NuevoContactoActivity.this, StartActivyForResultActivity.class);
            intent.putExtra("textoHint", "Empresa: ");
            startActivityForResult(intent, option_request_empresa);
        });

        //Implementamos el evento en RadioGroup al seleccionar Empresa o Particular.
        rdgEmpresas.setOnCheckedChangeListener((group, checkedId) -> {
            imgEmpresa.setVisibility(View.VISIBLE);
            //Si está checkeado el botón Empresa, se muestra la imagen Empresa
            //Si está checkeado el botón Particular, se muestra la imagen Particular
            switch (checkedId) {
                case R.id.rdbEmpresa:
                    imgEmpresa.setImageResource(R.drawable.ic_business);
                    break;
                case R.id.rdbParticular:
                    imgEmpresa.setImageResource(R.drawable.ic_person);
                    break;
            }
        });

        //Implementamos el evento en RadioGroup al seleccionar Hombre o Mujer.
        rdgSexo.setOnCheckedChangeListener((group, checkedId) -> {
            imgSexo.setVisibility(View.VISIBLE);
            //Si está checkeado el botón Hombre, se muestra la imagen Hombre
            //Si está checkeado el botón Mujer, se muestra la imagen Mujer
            switch (checkedId) {
                case R.id.rdbHombre:
                    imgSexo.setImageResource(R.drawable.ic_male);
                    break;
                case R.id.rdbMujer:
                    imgSexo.setImageResource(R.drawable.ic_female);
                    break;
            }
        });

        //Implementamos el evento al activar el switch Favorito.
        swcFavorito.setOnCheckedChangeListener((buttonView, isChecked) -> {
            //Si está checkeado, la imagen del Favorito se pone visible y viceversa.
            if(isChecked){
                imgFav.setVisibility(View.VISIBLE);
            } else{
                imgFav.setVisibility(View.INVISIBLE);
            }
        });

        //Implementamos el evento al hacer click en el CheckBox.
        ckbRecordarLlamar.setOnCheckedChangeListener((CheckBox, isChecked) -> {
            //Si está checkeado, la imagen del Telefono se pone visible y viceversa.
            if(isChecked){
                imgTelefono.setVisibility(View.VISIBLE);
            } else{
                imgTelefono.setVisibility(View.INVISIBLE);
            }
        });

        //Implementamos el evento al modificar el SeekBar y actualizamos el TextView Edad.
        skbEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * Método que detecta la posición del SeekBar y actualiza los datos del TextView Edad con la posición.
             * @param seekBar
             * @param progress
             * @param fromUser
             */
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtEdad.setText("Edad: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Implementamos el evento al hacer click en el botón Ok.
        btnOk.setOnClickListener(v -> {
            //Detecta si los campos Nombre Apellidos y Telefono contienen datos.
            //De ser así, envia los datos a MainActivity.
            //En caso de faltar algún campo, muestra un mensaje de error.
            if ((txtNombre.getText().length() != 0 && !txtNombre.getText().toString().equals("Nombre"))&&(txtApellidos.getText().length() != 0 && !txtApellidos.getText().toString().equals("Apellidos"))) {
                if(edtTelefono.getText().length() !=0){
                    String nombre = txtNombre.getText().toString();
                    String apellidos = txtApellidos.getText().toString();
                    String telefono = edtTelefono.getText().toString();
                    Intent intent = getIntent();
                    intent.putExtra("CONTACTO", nombre + " " + apellidos + " - " + telefono);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    Toast.makeText(NuevoContactoActivity.this, "No se ha introducido un número de teléfono", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(NuevoContactoActivity.this, "No se ha introducido nombre y apellido del contacto", Toast.LENGTH_SHORT).show();
            }
        });

        //Implementamos el evento al hacer click en el botón Cancel.
        btnCancel.setOnClickListener(v -> {
            //Enviamos un resultado cancelado a MainAcitivity y cerramos la ventana actual.
            setResult(RESULT_CANCELED);
            finish();
        });
    }


    /**
     * Método encargado de recoger los datos obtenidos de la clase StartActivyForResultActivity
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //En caso de recibir datos válidos, se almacenan en sus campos dependiendo del option_request recibido..
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