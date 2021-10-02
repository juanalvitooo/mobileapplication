package id.ac.umn.uts_37193_juanalvito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class FormInput extends AppCompatActivity {

    EditText nama;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_form);

        nama = (EditText) findViewById(R.id.nama);
        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(nama.getText())){
                    nama.setError("Harap Diisi");
                } else{
                    Intent intentLibrary = new Intent(FormInput.this, Library.class);
                    String namaLogin = nama.getText().toString();
                    intentLibrary.putExtra("Nama", namaLogin);
                    startActivity(intentLibrary);
                }
            }
        });
    }
}