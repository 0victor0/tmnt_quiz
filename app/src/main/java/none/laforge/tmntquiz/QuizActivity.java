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

    private Button mBlueButton;
    private Button mRedButton;
    private Button mOrangeButton;
    private Button mPurpleButton;
    private Button mNextButton;             //Create variable for next button
    private TextView mQuestionTextView;     // Create variables for textView

    private Question[] mQuestionBank = new Question[] {     // Create question bank
            new Question(R.string.question_01, "blue"),
            new Question(R.string.question_02, "red"),
            new Question(R.string.question_03, "orange"),
            new Question(R.string.question_04, "purple"),
    };

    private int mCurrentIndex = 0;

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(String userInput) {                           // Method to check
        String answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue(); // answers
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

        mBlueButton     = (Button) findViewById(R.id.blue_button);
        mBlueButton.setOnClickListener(new View.OnClickListener() {     //listener implemented as
            @Override                                                   //anonymous inner class
            //Listener requires onClick(View)
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this,                     // implement private method
                //        R.string.correct_toast,                       //
                //        Toast.LENGTH_SHORT).show();                   //
                checkAnswer("blue");
            }
        });

        mRedButton     = (Button) findViewById(R.id.red_button);
        mRedButton.setOnClickListener(new View.OnClickListener() {     //listener implemented as
            @Override                                                   //anonymous inner class
            //Listener requires onClick(View)
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this,                     // implement private method
                //        R.string.correct_toast,                       //
                //        Toast.LENGTH_SHORT).show();                   //
                checkAnswer("red");
            }
        });

        mOrangeButton     = (Button) findViewById(R.id.orange_button);
        mOrangeButton.setOnClickListener(new View.OnClickListener() {     //listener implemented as
            @Override                                                   //anonymous inner class
            //Listener requires onClick(View)
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this,                     // implement private method
                //        R.string.correct_toast,                       //
                //        Toast.LENGTH_SHORT).show();                   //
                checkAnswer("orange");
            }
        });

        mPurpleButton     = (Button) findViewById(R.id.purple_button);
        mPurpleButton.setOnClickListener(new View.OnClickListener() {     //listener implemented as
            @Override                                                   //anonymous inner class
            //Listener requires onClick(View)
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this,                     // implement private method
                //        R.string.correct_toast,                       //
                //        Toast.LENGTH_SHORT).show();                   //
                checkAnswer("purple");
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
