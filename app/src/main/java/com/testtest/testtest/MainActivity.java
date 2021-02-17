package com.testtest.testtest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * membuat variable Button, saya buat dengan nama "button"
     */

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utama);

        button = (Button) findViewById(R.id.txt_mulai);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /**STEP A
                 *
                 *    "i" adalah variable Intent
                 *    kemudian kita akan memanggil method Intent dengan perintah New Intent()
                 *    memasukan parameter Intent() dengan MainActivity kemudian ActivityTujuan
                 */

                Intent i = new Intent(MainActivity.this, utama.class);


                /**STEP B
                 *
                 *    memulai Aktifitas perintah yang dibuat di bagian A
                 *    yaitu "i"
                 *    dengan method startActivity()
                 */

                startActivity(i);

            }
        });
    }
}