package app.walymoss.com.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txtResultado = (TextView)findViewById(R.id.txtResultado);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras!=null){
            txtResultado.setText(extras.getString("resultado"));

        }


    }
}
