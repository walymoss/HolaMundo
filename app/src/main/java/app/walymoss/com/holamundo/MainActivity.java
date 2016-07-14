package app.walymoss.com.holamundo;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener, SensorEventListener{
    GridLayout gr;
    SensorManager sm;
    Sensor sensor;
    TextView txtValor;
    Button btnCero, btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho,
            btnNueve, btnDelete, btnSuma, btnResta, btnMultiplicacion, btnDivision, btnIgual, btnCorreccion;
    Double primerValor, segundoValor, resultado;
    String operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gr = (GridLayout) findViewById(R.id.gridLayout);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        txtValor = (TextView)findViewById(R.id.txtValor);
        txtValor.setText("0");

        btnCero = (Button)findViewById(R.id.btnCero);
        btnCero.setOnClickListener(this);

        btnUno = (Button)findViewById(R.id.btnUno);
        btnUno.setOnClickListener(this);

        btnDos = (Button)findViewById(R.id.btnDos);
        btnDos.setOnClickListener(this);

        btnTres = (Button)findViewById(R.id.btnTres);
        btnTres.setOnClickListener(this);

        btnCuatro = (Button)findViewById(R.id.btnCuatro);
        btnCuatro.setOnClickListener(this);

        btnCinco = (Button)findViewById(R.id.btnCinco);
        btnCinco.setOnClickListener(this);

        btnSeis = (Button)findViewById(R.id.btnSeis);
        btnSeis.setOnClickListener(this);

        btnSiete = (Button)findViewById(R.id.btnSiete);
        btnSiete.setOnClickListener(this);

        btnOcho = (Button)findViewById(R.id.btnOcho);
        btnOcho.setOnClickListener(this);

        btnNueve = (Button)findViewById(R.id.btnNueve);
        btnNueve.setOnClickListener(this);

        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        btnSuma = (Button)findViewById(R.id.btnSuma);
        btnSuma.setOnClickListener(this);

        btnResta = (Button)findViewById(R.id.btnResta);
        btnResta.setOnClickListener(this);

        btnMultiplicacion = (Button)findViewById(R.id.btnMultiplicacion);
        btnMultiplicacion.setOnClickListener(this);

        btnDivision = (Button)findViewById(R.id.btnDivision);
        btnDivision.setOnClickListener(this);

        btnIgual = (Button)findViewById(R.id.btnIgual);
        btnIgual.setOnClickListener(this);

        btnCorreccion = (Button)findViewById(R.id.btnCorreccion);
        btnCorreccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Está seguro que desea borrar el contenido?"); //Message
                builder.setIcon(android.R.drawable.ic_dialog_alert); //Icon
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { //Yes Button
                        txtValor.setText("0");
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { //No Button
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create(); //create
                alert.show(); //show
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCero:
                ActualizarValor("0");
                break;
            case R.id.btnUno:
                ActualizarValor("1");
                break;
            case R.id.btnDos:
                ActualizarValor("2");
                break;
            case R.id.btnTres:
                ActualizarValor("3");
                break;
            case R.id.btnCuatro:
                ActualizarValor("4");
                break;
            case R.id.btnCinco:
                ActualizarValor("5");
                break;
            case R.id.btnSeis:
                ActualizarValor("6");
                break;
            case R.id.btnSiete:
                ActualizarValor("7");
                break;
            case R.id.btnOcho:
                ActualizarValor("8");
                break;
            case R.id.btnNueve:
                ActualizarValor("9");
                break;
            case R.id.btnDelete:
                txtValor.setText(txtValor.getText().subSequence(0, txtValor.getText().length()-1));
                if(txtValor.getText().length() == 0)
                {
                    txtValor.setText("0");
                }
                break;
            case R.id.btnSuma:
                operacion = "Suma";
                primerValor = Double.parseDouble(txtValor.getText().toString());
                txtValor.setText("");
                break;
            case R.id.btnResta:
                operacion = "Resta";
                primerValor = Double.parseDouble(txtValor.getText().toString());
                txtValor.setText("");
                break;
            case R.id.btnMultiplicacion:
                operacion = "Multiplicacion";
                primerValor = Double.parseDouble(txtValor.getText().toString());
                txtValor.setText("");
                break;
            case R.id.btnDivision:
                operacion = "Division";
                primerValor = Double.parseDouble(txtValor.getText().toString());
                txtValor.setText("");
                break;
            case R.id.btnIgual:
                segundoValor = Double.parseDouble(txtValor.getText().toString());
                switch (operacion){
                    case "Suma":
                        resultado = primerValor + segundoValor;
                        txtValor.setText(resultado.toString());
                        break;
                    case "Resta":
                        resultado = primerValor - segundoValor;
                        txtValor.setText(resultado.toString());
                        break;
                    case "Multiplicacion":
                        resultado = primerValor * segundoValor;
                        txtValor.setText(resultado.toString());
                        break;
                    case "Division":
                        if (segundoValor == 0){
                            Toast.makeText(this.getApplicationContext(),"No sea pendejo, la división entre cero no existe", Toast.LENGTH_SHORT).show();
                        }else{
                            resultado = primerValor / segundoValor;
                            txtValor.setText(resultado.toString());
                        }
                        break;
                }
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra("resultado", resultado.toString());
                startActivity(intent);
                break;
        }
    }

    private void ActualizarValor(String val){
        if (txtValor.getText().equals("0"))
        {
            txtValor.setText(val);
        }
        else
        {
            txtValor.setText(txtValor.getText() + val);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String texto = String.valueOf(event.values[0]);
        float valor = Float.parseFloat(texto);
        if (valor == 0){
            gr.setBackgroundColor(Color.BLUE);
        }
        else {
            gr.setBackgroundColor(Color.YELLOW);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
