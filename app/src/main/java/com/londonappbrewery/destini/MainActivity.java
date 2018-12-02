package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mStory;
    private Button mFirstAnswer;
    private Button mSecondAnswer;
    private int[] Descriptions = {R.string.T1_Story, R.string.T2_Story, R.string.T3_Story, R.string.T4_End, R.string.T5_End, R.string.T6_End};
    private int[] Answers1 = {R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1};
    private int[] Answers2 = {R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2};


    private int mStorySelected = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mStory = (TextView) findViewById(R.id.storyTextView);

        mFirstAnswer = (Button) findViewById(R.id.buttonTop);
        mFirstAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mStorySelected) {
                    case 1:
                    case 2:
                        mStory.setText(Descriptions[mStorySelected + 1]);
                        mFirstAnswer.setText(Answers1[mStorySelected + 1]);
                        mSecondAnswer.setText(Answers2[mStorySelected + 1]);
                        mStorySelected = 3;
                        break;
                    case 3:
                        mStory.setText(Descriptions[Descriptions.length - 1]);
                        mSecondAnswer.setVisibility(View.GONE);
                        mFirstAnswer.setVisibility(View.GONE);
                        break;
                }
            }
        });

        mSecondAnswer = (Button) findViewById(R.id.buttonBottom);
        mSecondAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mStorySelected) {
                    case 1:
                        mStory.setText(Descriptions[mStorySelected]);
                        mFirstAnswer.setText(Answers1[mStorySelected]);
                        mSecondAnswer.setText(Answers2[mStorySelected]);
                        mStorySelected = 2;
                        break;
                    case 2:
                        mStory.setText(Descriptions[mStorySelected + 1]);
                        mSecondAnswer.setVisibility(View.GONE);
                        mFirstAnswer.setVisibility(View.GONE);
                        break;
                    case 3:
                        mStory.setText(Descriptions[mStorySelected + 1]);
                        mSecondAnswer.setVisibility(View.GONE);
                        mFirstAnswer.setVisibility(View.GONE);
                        break;
                }

            }
        });
    }

    private void update() {
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putInt(answer);
    }
}
