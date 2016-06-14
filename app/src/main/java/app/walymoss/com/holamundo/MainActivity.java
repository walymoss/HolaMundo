package app.walymoss.com.holamundo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    TextView txtValor;
    Button btnCero;
    Button btnUno;
    Button btnDos;
    Button btnTres;
    Button btnCuatro;
    Button btnCinco;
    Button btnSeis;
    Button btnSiete;
    Button btnOcho;
    Button btnNueve;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
}
