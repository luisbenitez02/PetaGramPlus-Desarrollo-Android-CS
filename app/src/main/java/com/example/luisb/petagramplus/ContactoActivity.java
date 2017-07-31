package com.example.luisb.petagramplus;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class ContactoActivity extends AppCompatActivity {

    private EditText editNombre;
    private EditText editMailSecond;
    private EditText editMensaje;
    Toolbar miToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        miToolbar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.contacto));

        /*vamos a activar el funcionamiento del boton "atras"*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Activamos el Boton de subir

         /*vamos a activar el funcionamiento del boton "atras"*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*asocio los elementos con las vistas*/

        editNombre = (EditText) findViewById(R.id.inputName);
        editMailSecond = (EditText) findViewById(R.id.inputMail);
        editMensaje = (EditText) findViewById(R.id.inputMensaje);

        FloatingActionButton send = (FloatingActionButton) findViewById(R.id.sendEmailButton);

        /*
        * Al boton ser pulsado llamara a este metodo
        * */

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //capturamos los textos en cada campo
                String nombre = editNombre.getText().toString();
                String sencondmail = editMailSecond.getText().toString();
                String mensaje = editMensaje.getText().toString();

                enviarMail(nombre,sencondmail,mensaje);
            }
        });

    }

    private void enviarMail(String nombre, String mail2, String mensaje){

        String[] mimail = new String[] {"luisbenitez_14@hotmail.com"};//a donde quieres enviarlo?
        String asunto = "Comentarios App Petagram";


        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));//que tipo de envio sera? mailto: email
        i.setType("message/rfc822");

        i.putExtra(Intent.EXTRA_EMAIL, mimail);//a quien se lo enviamos?
        i.putExtra(Intent.EXTRA_SUBJECT, asunto);
        i.putExtra(Intent.EXTRA_TEXT, mensaje + "\n Email secundario: " + mail2);

        startActivity(Intent.createChooser(i,"Enviar Email"));//que dice en el chooser?

    }
}
