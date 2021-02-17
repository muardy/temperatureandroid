package com.testtest.testtest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class utama  extends AppCompatActivity {
    private RecyclerView mseRecyclerView;
    private Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn_g);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /**STEP A
                 *
                 *    "i" adalah variable Intent
                 *    kemudian kita akan memanggil method Intent dengan perintah New Intent()
                 *    memasukan parameter Intent() dengan MainActivity kemudian ActivityTujuan
                 */

                Intent i = new Intent(utama.this, ardy2.class);


                /**STEP B
                 *
                 *    memulai Aktifitas perintah yang dibuat di bagian A
                 *    yaitu "i"
                 *    dengan method startActivity()
                 */

                startActivity(i);

            }
        });


        mseRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        new FirebaseDatabaseHelper().read(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Sens> sens, List<String> keys) {
                new RecyclerView_Config().setConfig(mseRecyclerView, utama.this, sens, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });




    }



}