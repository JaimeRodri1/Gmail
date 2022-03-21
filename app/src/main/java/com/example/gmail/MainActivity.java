package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mail;
    private EditText asunt;
    private EditText mensa;
    private ImageButton envia;
    private ImageButton about;
    String asu;
    String correo;
    String menj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        about = (ImageButton) findViewById(R.id.About);
        envia = (ImageButton) findViewById(R.id.enviar);
        mail = (EditText) findViewById(R.id.email);
        asunt = (EditText) findViewById(R.id.asunto);
        mensa = (EditText) findViewById(R.id.mensaje);

        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correo = mail.getText().toString();
                asu = asunt.getText().toString();
                menj = mensa.getText().toString();
                if(correo.equals("") || asu.equals("") || menj.equals("")){
                    Toast.makeText(MainActivity.this, "¡Falta llenar campos!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL,
                            new String[] { correo });
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, asu);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, menj);
                    emailIntent.setType("message/rfc822");
                    startActivity(Intent.createChooser(emailIntent, "¡Seleccione una aplicación!"));
                }
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),creator.class);
                startActivity(a);
                finish();
            }
        });

    }
}