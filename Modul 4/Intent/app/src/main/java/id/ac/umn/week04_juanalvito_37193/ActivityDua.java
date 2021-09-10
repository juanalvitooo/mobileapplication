package id.ac.umn.week04_juanalvito_37193;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityDua extends AppCompatActivity {

    private TextView tvPesanDiterima;
    private EditText etJawaban;
    private Button btnBalasKirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);

        tvPesanDiterima = findViewById(R.id.pesanDiterima);
        etJawaban = findViewById(R.id.pesanBalik);
        btnBalasKirim = findViewById(R.id.kirimBalik);

        Intent mainIntent = getIntent();
        String pesanDiterima = mainIntent.getStringExtra("PesanDariMain");
        tvPesanDiterima.setText(pesanDiterima);

        /*btnBalasKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jawaban = etJawaban.getText().toString();
                Intent balasIntent = new Intent(ActivityDua.this, MainActivity.class);
                balasIntent.putExtra("Jawaban", jawaban);
                startActivity(balasIntent);
            }
        });*/
    }

    public void kirimBalik(View v){
        String jawaban = etJawaban.getText().toString();
        Intent balasIntent = new Intent();
        balasIntent.putExtra("Jawaban", jawaban);
        setResult(RESULT_OK, balasIntent);
        finish();
    }
}