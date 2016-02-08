package none.laforge.tmntquiz;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;             //Create variable for next button
    private TextView mQuestionTextView;     // Create variables for textView

    private Question[] mQuestionBank = new Question[] {     // Create question bank
            new Question(R.string.question_01, true),
            new Question(R.string.question_02, false),
            new Question(R.string.question_03, false),
            new Question(R.string.question_04, true),
    };

    private int mCurrentIndex = 0;

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userInput) {                           // Method to check
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue(); // answers
        int messageResId = 0;                                               //
        if (userInput == answerIsTrue) {                                    //
            messageResId = R.string.correct_toast;                          //
        } else {                                                            //
            messageResId = R.string.incorrect_toast;                        //
        }                                                                   //
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();      //
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);   // wiring up
        //int question = mQuestionBank[mCurrentIndex].getTextResId();           // textView for
        //mQuestionTextView.setText(question);                                  // questions

        mTrueButton     = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {     //listener implemented as
            @Override                                                   //anonymous inner class
            //Listener requires onClick(View)
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this,                     // implement private method
                //        R.string.correct_toast,                       //
                //        Toast.LENGTH_SHORT).show();                   //
                checkAnswer(true);
            }
        });

        mFalseButton    = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this,                        // implement private
                //        R.string.incorrect_toast,                        // method
                //        Toast.LENGTH_SHORT).show();                      //
                checkAnswer(false);
            }
        });

        mNextButton     = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
        //        int question = mQuestionBank[mCurrentIndex].getTextResId();   // removing because
        //        mQuestionTextView.setText(question);                          // it updates
            }                                                                   // which is already coded
        });                                                                 // mQuestionTextView
                                                                                // make this a
        updateQuestion();                                                       // private method


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Message when you click on mail icon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
