package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class FirstFragment extends Fragment {
    private int secretNumber;
    private EditText guessInput;
    private Button checkButton;
    private TextView resultText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate((R.layout.fragment_first), container, false);

        guessInput = v.findViewById(R.id.etGuess);
        checkButton = v.findViewById(R.id.btnSubmitGuess);
        resultText = v.findViewById(R.id.ResultText);

        Button buttonNavigate = v.findViewById(R.id.btnBack);
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода на другую страницу (Activity)
                Intent intent = new Intent(FirstFragment.this.getActivity(), MenuActivity.class);
                startActivity(intent);
            }
        });

        startNewGame();

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });
        return v;
    }

    private void startNewGame() {
        Random random = new Random();
        secretNumber = random.nextInt(101); // Случайное число от 0 до 100
        resultText.setText("");
    }

    private void checkGuess() {
        String guessText = guessInput.getText().toString();
        if (!guessText.isEmpty()) {
            int guess = Integer.parseInt(guessText);

            if (guess == secretNumber) {
                resultText.setText("Поздравляем! Вы выиграли!");
                startNewGame();
            } else if (guess < secretNumber) {
                resultText.setText("Попробуйте больше");
            } else {
                resultText.setText("Попробуйте меньше");
            }
        }
    }
}

