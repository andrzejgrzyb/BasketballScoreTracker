package pl.com.andrzejgrzyb.basketballscoretracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    // binding TextViews with Butterknife
    //    http://jakewharton.github.io/butterknife/
    @BindView(R.id.score_a_textview)
    TextView scoreATextView;
    @BindView(R.id.score_b_textview)
    TextView scoreBTextView;
    @BindView(R.id.fouls_a_count_textview)
    TextView foulsATextView;
    @BindView(R.id.fouls_b_count_textview)
    TextView foulsBTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.reset_button)
    public void resetAll() {
        scoreATextView.setText("0");
        scoreBTextView.setText("0");
        foulsATextView.setText("0");
        foulsBTextView.setText("0");
    }

    //    Score buttons for Team A
    @OnClick(R.id.team_a_1_button)
    public void add1TeamA() {
        addToScore(scoreATextView, 1);
    }

    @OnClick(R.id.team_a_2_button)
    public void add2TeamA() {
        addToScore(scoreATextView, 2);
    }

    @OnClick(R.id.team_a_3_button)
    public void add3TeamA() {
        addToScore(scoreATextView, 3);
    }

    //    Score buttons for Team B
    @OnClick(R.id.team_b_1_button)
    public void add1TeamB() {
        addToScore(scoreBTextView, 1);
    }

    @OnClick(R.id.team_b_2_button)
    public void add2TeamB() {
        addToScore(scoreBTextView, 2);
    }

    @OnClick(R.id.team_b_3_button)
    public void add3TeamB() {
        addToScore(scoreBTextView, 3);
    }

    //    Foul buttons
    @OnClick(R.id.team_a_foul_button)
    public void addFoulTeamA() {
        addFoul(foulsATextView);
    }

    @OnClick(R.id.team_b_foul_button)
    public void addFoulTeamB() {
        addFoul(foulsBTextView);
    }

    // Adds points to a value in a TextView
    public void addToScore(TextView scoreTextView, int points) {
        int score = Integer.parseInt(scoreTextView.getText().toString());
        scoreTextView.setText(String.valueOf(score + points));
    }

    // Increments foul counter in a TextView
    public void addFoul(TextView foulTextView) {
        int fouls = Integer.parseInt(foulTextView.getText().toString());
        foulTextView.setText(String.valueOf(fouls + 1));
    }
}
