package com.example.android.librarydisplayjoke;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokeDisplayActivity extends AppCompatActivity {
    public static final String INTENT_JOKE = "INTENT_JOKE";
    private String mJoke;
    @BindView(R2.id.tv_joke)
    TextView mJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        ButterKnife.bind(this);

        Intent parameters = getIntent();
        if(parameters != null) {
            onRestoreInstanceState(parameters.getExtras());
        }
        onRestoreInstanceState(savedInstanceState);
        if(mJoke == null){
            throw new IllegalArgumentException("No joke parameter");
        }

        if(getCallingActivity() != null) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);

            }
        }
        mJokeTextView.setText(mJoke);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home && getCallingActivity() != null) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            Intent intent = new Intent();
            intent.setClassName(this, getCallingActivity().getClassName());

            navigateUpTo(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState == null){
            return;
        }else if (savedInstanceState.containsKey(INTENT_JOKE)){
            mJoke = savedInstanceState.getString(INTENT_JOKE);
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if(outState == null){
            return;
        }
        outState.putString(INTENT_JOKE, mJoke);
        super.onSaveInstanceState(outState);
    }
}
