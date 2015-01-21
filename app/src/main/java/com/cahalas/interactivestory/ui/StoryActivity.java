package com.cahalas.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cahalas.interactivestory.R;
import com.cahalas.interactivestory.model.Page;
import com.cahalas.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mButton1;
    private Button mButton2;
    private String mName;

    private Page currentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if(mName == null) mName = "friend";
        Log.d(TAG, "passed name: " + mName);
        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mButton1 = (Button) findViewById(R.id.choiceButton1);
        mButton2 = (Button) findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        currentPage = mStory.getPage(pageNumber);
        Drawable drawable = getResources().getDrawable(currentPage.getImageid());
        mImageView.setImageDrawable(drawable);

        String pageText = currentPage.getText();
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);
        if(currentPage.isFinal) {
            mButton1.setVisibility(View.INVISIBLE);
            mButton2.setText("PLAY AGAIN");
            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }
        else {
            mButton1.setText(currentPage.getChoice1().getText());
            mButton2.setText(currentPage.getChoice2().getText());

            mButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = currentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = currentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }

    }

}






















