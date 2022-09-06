package com.example.buatquiz;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Mobil Asal Jepang ?",
            "2. Mobil Iconic Di Need For Speed Most Wanted ?",
            "3. Orang yang membantu Player mendapatkan mobil kembali ?",
            "4. Soundtrack Iconic Need For Speed Most Wanted ?",
            "5. Mobil yang selalu digunakan Paul Walker ?",
            "6. Siapa Yang berperan sebagai Roman Pearce ?",
            "7. Fast And Furious berapakah Paul Walker Berhenti ? ",
            "8. Orang kepala botak di fast and furious ?",
            "9. Mobil Yang dipakai Paul Walker saat kecelakaan ?",
            "10. Siapakah Istri Reyvan ? "
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "Suzuki", "Honda", "BMW", "Audi",
            "Mitsubishi Lancer", "Toyota Supra Mk4", "Porsche 911", "BMW GTR",
            "Lawhi", "Smokey", "Craig", "Mia",
            "Hotel California", "Da Ya Thang", "Im Upset", "Hotline Blink",
            "1998 Honda Civic", "1994 Toyota Supra", "Dodge Charger 1970", "Toyota Agya",
            "Tyrese Gibson","John Cena","Sung Kang","Vin Diesel",
            "2Fast 2Furious","Furious 8","Fast 9","Furious 7",
            "Roman Pearce","Mia Toretto","Vin Diesel","Paul Walker",
            "Porsche 919 Hybrid","Porsche Carrera GT","Porsche RS Spyder","Porsche 911 RSR-19",
            "Seulgi","Mina","Tsuki","Semua Benar"
    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
            "Honda",
            "BMW GTR",
            "Mia",
            "Da Ya Thang",
            "1994 Toyota Supra",
            "Tyrese Gibson",
            "Furious 7",
            "Vin Diesel",
            "Porsche Carrera GT",
            "Semua Benar"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                hasil = benar * 10;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Kamu Jawab Dulu",Toast.LENGTH_LONG).show();
        }
    }
}