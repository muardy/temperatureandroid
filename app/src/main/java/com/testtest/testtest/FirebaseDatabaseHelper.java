package com.testtest.testtest;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class FirebaseDatabaseHelper {
    private FirebaseDatabase mdatabse;
    private DatabaseReference mreference;
    private List<Sens> sens = new ArrayList<>();


    public interface DataStatus{
     void  DataIsLoaded(List<Sens> sens, List<String> keys);
     void  DataIsInserted();
     void  DataIsUpdated();
     void   DataIsDeleted();



    }
    public FirebaseDatabaseHelper() {

        mdatabse=FirebaseDatabase.getInstance();
        mreference = mdatabse.getReference("iyus");


    }

    public void read(final DataStatus dataStatus ){

mreference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        sens.clear();
        List<String> keys = new ArrayList<>();
        for(DataSnapshot keyNode : dataSnapshot.getChildren()){
            keys.add(keyNode.getKey());
            Sens sen  = keyNode.getValue(Sens.class);
            sens.add(sen);

        }
        dataStatus.DataIsLoaded(sens, keys );
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
    }
}

