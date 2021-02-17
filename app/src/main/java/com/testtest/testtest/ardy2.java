package com.testtest.testtest;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;



import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
public class ardy2 extends AppCompatActivity {
    Button btn_insert;
    EditText xvalue,yvalue;


    FirebaseDatabase database;
    DatabaseReference reference;
    GraphView graphview;
    LineGraphSeries series;



   // @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ardy2);

        graphview = (GraphView)  findViewById(R.id.graphview);

        series = new LineGraphSeries();
        graphview.addSeries(series);

        database =  FirebaseDatabase.getInstance();
        reference =  database.getReference("iyus");
        setListeners();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataPoint[] dp = new DataPoint[(int) dataSnapshot.getChildrenCount()];
                int index = 0;
                for(DataSnapshot myDataSnapshot : dataSnapshot.getChildren())
                {


                    PointValue pointValue = myDataSnapshot.getValue(PointValue.class);
                    dp[index]= new DataPoint(pointValue.getxvalue(),pointValue.getyvalue());
                    index++;


                }
                series.resetData(dp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    private void setListeners(){


    }

    @Override
    protected void onStart() {
        super.onStart();


    }
}

