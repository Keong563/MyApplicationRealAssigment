package com.example.ax.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

//public class oldImageActivity extends AppCompatActivity{
public class oldImageActivity extends AppCompatActivity implements ImageAdapter.OnItemClickListener {
private RecyclerView mRecyclerView;
private ImageAdapter mAdapter;

private ProgressBar mProgressCircle;

private FirebaseStorage mStorage;
private DatabaseReference mDatabaseRef;
private ValueEventListener mDBListener;

private FirebaseDatabase mDatabase22;
//private StorageReference mStorageRef2;
private DatabaseReference mDatabaseRef2;

private List<uploadOldFood> mUploads;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_image);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mProgressCircle = findViewById(R.id.progress_circular);

        mUploads = new ArrayList<>();

        mAdapter = new ImageAdapter(oldImageActivity.this, mUploads);

        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(oldImageActivity.this);

        mStorage = FirebaseStorage.getInstance();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("oldFoodImage");

        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {

        mUploads.clear();

        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
        uploadOldFood upload = postSnapshot.getValue(uploadOldFood.class);

        upload.setKey(postSnapshot.getKey());
        mUploads.add(upload);
        }

        mAdapter.notifyDataSetChanged();

        mProgressCircle.setVisibility(View.INVISIBLE);
        }

@Override
public void onCancelled(DatabaseError databaseError) {
        Toast.makeText(oldImageActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
        mProgressCircle.setVisibility(View.INVISIBLE);
        }
        });
        }

@Override
public void onItemClick(int position) {
   // public void onItemClick() {
    //Intent intent = new Intent(this, FoodDetail.class);
    //intent.putExtra("getSelectedPosition",position);
   // startActivity(intent);
}

@Override
public void onWhatEverClick(int position) {
        Toast.makeText(this, "Whatever click at position: " + position, Toast.LENGTH_SHORT).show();
    int fff = position;
//
//    uploadOldFood selectedItem = mUploads.get(position);
//    final String selectedKey = selectedItem.getKey();
//
    Intent intent = new Intent(this, FoodDetail.class);
    intent.putExtra("getSelectedPosition",fff);
//  intent.putExtra("getSelectedPosition",selectedKey);
    startActivity(intent);
        }

@Override
public void onDeleteClick(int position) {
    uploadOldFood selectedItem = mUploads.get(position);
    final String selectedKey = selectedItem.getKey();

    // mStorageRef2 = FirebaseStorage.getInstance().getReference("newFoodGG");
    mDatabaseRef2 = FirebaseDatabase.getInstance().getReference("newFoodGG");


    //StorageReference imageRef = mStorage.getReferenceFromUrl(selectedItem.getImageUrl());
    //DatabaseReference imageRef = mDatabase22.getReference("oldFoodImage").child(selectedItem.getImageUrl());
    DatabaseReference imageRef = FirebaseDatabase.getInstance().getReference("oldFoodImage").child(selectedKey);
    //DatabaseReference imageRef2 = mDatabase22.getReferenceFromUrl(selectedKey);
    //uploadOldFood upload = new uploadOldFood(mEditTextFileName.getText().toString().trim(),downloadUrl.toString(),foodDesc.getText().toString());
    uploadOldFood gg = new uploadOldFood(selectedItem.getName().toString(), selectedItem.getImageUrl(), selectedItem.getFoodDescription().toString());
    String uploadId2 = mDatabaseRef2.push().getKey();

    mDatabaseRef2.child(uploadId2).setValue(gg);

    //mDatabaseRef

    //imageRef.removeValue();

    imageRef.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
//
//   // imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
@Override
public void onSuccess(Void aVoid) {
        mDatabaseRef.child(selectedKey).removeValue();
        Toast.makeText(oldImageActivity.this, "Item has been Requested", Toast.LENGTH_SHORT).show(); }
        });
}


@Override
protected void onDestroy() {
        super.onDestroy();
        mDatabaseRef.removeEventListener(mDBListener);
        }

}


