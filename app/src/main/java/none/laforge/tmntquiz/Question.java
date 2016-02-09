package none.laforge.tmntquiz;

/**
 * Created by laforge on 2/7/16.
 */

public class Question {

    private int mTextResId;     // member variable, hence the m
    private String mAnswerTrue;    // member variable, hence the m

    public Question(int textResId, String answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public String isAnswerTrue() {                      //getter
        return mAnswerTrue;
    }
    public int getTextResId() {                      //getter
        return mTextResId;
    }
    public void setTextResId(int textResId) {        //setter
        mTextResId = textResId;
    }
    public void setAnswerTrue(String answerTrue) {      //setter
        mAnswerTrue = answerTrue;
    }

}


