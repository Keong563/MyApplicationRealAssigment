package com.example.ax.myapplication;

import com.google.firebase.database.Exclude;

public class uploadOldFood {
    private String mName;
    private String mImageUrl;
    private String foodDescription;
    private String mKey;

    public uploadOldFood() {
        //empty constructor needed
    }

//    public uploadOldFood(String name, String imageUrl) {
//        if (name.trim().equals("")) {
//            name = "No Name";
//        }
//
//        mName = name;
//        mImageUrl = imageUrl;
//
//    }

    public uploadOldFood(String name, String imageUrl,String foodDesc1) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;

        if (foodDesc1.trim().equals("")){
            foodDescription = "No Description";
        }

        foodDescription = foodDesc1;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String mKey) {
        this.mKey = mKey;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }
}