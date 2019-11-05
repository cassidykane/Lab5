package edu.mylanecckanec.kanec.pig;

import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;
import java.util.Random;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GameFragment extends Fragment implements OnEditorActionListener, View.OnClickListener {

    private TextView p1NameLabel;
    private TextView p2NameLabel;
    private TextView p1ScoreLabel;
    private TextView p2ScoreLabel;
    private TextView currentPlayerLabel;
    private TextView pointsThisTurnLabel;
    private TextView pointsToWinLabel;
    private TextView numberOfDiceLabel;
    private EditText p1NameEditText;
    private EditText p2NameEditText;
    private Button rollDieButton;
    private Button newGameButton;
    private Button endTurnButton;
    private ImageView dieImageView;
    private ImageView die2ImageView;
    private PigGame gameLogic;
    private SharedPreferences savedValues;
    private SharedPreferences preferences;
    private boolean aiEnabled;
    private boolean continueAiTurn;
    private Random rando;
    private int aiRollCount;
    private int numberOfDice;
    private boolean customScoreEnabled;
    private int pointsToWin;
    private GameActivity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.game_fragment, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activity = (GameActivity)getActivity();

        p1NameLabel = (TextView) activity.findViewById(R.id.player1Label);
        p2NameLabel = (TextView) activity.findViewById(R.id.player2Label);
        p1ScoreLabel = (TextView) activity.findViewById(R.id.player1ScoreOutputLabel);
        p2ScoreLabel = (TextView) activity.findViewById(R.id.player2ScoreOutputLabel);
        currentPlayerLabel = (TextView) activity.findViewById(R.id.currentTurnLabel);
        pointsThisTurnLabel = (TextView) activity.findViewById(R.id.pointsThisTurnOutputLabel);
        pointsToWinLabel = (TextView) activity.findViewById(R.id.pointsToWinValueLabel);
        p1NameEditText = (EditText) activity.findViewById(R.id.player1EditText);
        p2NameEditText = (EditText) activity.findViewById(R.id.player2EditText);
        rollDieButton = (Button) activity.findViewById(R.id.rollDieButton);
        newGameButton = (Button) activity.findViewById(R.id.newGameButton);
        endTurnButton = (Button) activity.findViewById(R.id.endTurnButton);
        dieImageView = (ImageView) activity.findViewById(R.id.dieImageView);
        die2ImageView = (ImageView) activity.findViewById(R.id.die2ImageView);
        gameLogic = new PigGame();
        rando = new Random();

        p1NameEditText.setOnEditorActionListener(this);
        p2NameEditText.setOnEditorActionListener(this);
        rollDieButton.setOnClickListener(this);
        newGameButton.setOnClickListener(this);
        endTurnButton.setOnClickListener(this);
        //savedValues = activity.getSharedPreferences("SavedValues",MODE_PRIVATE);

        currentPlayerLabel.setText(gameLogic.getCurrentPlayer());
        //savedValues = activity.getSharedPreferences("savedValues", MODE_PRIVATE);

        //preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
}

