package fr.nathantouze.sarcasticwords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.widget.EditText;
import java.lang.*;

public class MainActivity extends AppCompatActivity {

    private EditText textIn;
    private Button converter;
    private TextView textOut;
    private Button copieur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.converter = (Button) findViewById(R.id.button);
        this.textIn = (EditText) findViewById(R.id.TextToBeConverted);
        this.textOut = (TextView) findViewById(R.id.response);
        this.copieur = (Button) findViewById(R.id.copy);

        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texte = textIn.getText().toString();
                texte = texte.toLowerCase();
                for (int i = 0; i < texte.length(); i++) {
                    if (i % 2 == 1)
                        texte = texte.substring(0, i) + Character.toUpperCase(texte.charAt(i)) + texte.substring(i + 1);
                }
                textOut.setText(texte);
            }
        });
        copieur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", textOut.getText().toString());
                clipboard.setPrimaryClip(clip);
            }
        });
    }
}