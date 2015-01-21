package com.cahalas.interactivestory.model;

/**
 * Created by yayak on 1/18/2015.
 */
public class Page {
    private int mImageid;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    public boolean isFinal=false;

    public Page (int imageId, String text, Choice choice1, Choice choice2 ) {
        mImageid = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }



    public Page (int imageId, String text) {
        mImageid = imageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        isFinal = true;

    }
    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }



    public int getImageid() {
        return mImageid;
    }

    public void setImageid(int imageid) {
        mImageid = imageid;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
