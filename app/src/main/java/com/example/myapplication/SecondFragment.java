package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import java.util.Random;

public class SecondFragment extends Fragment {

    private Button rockButton, scissorsButton, paperButton;
    private TextView textResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate((R.layout.fragment_second), container, false);

        rockButton = v.findViewById(R.id.rockButton);
        scissorsButton = v.findViewById(R.id.scissorsButton);
        paperButton = v.findViewById(R.id.paperButton);
        textResult = v.findViewById(R.id.textResult);

        Button buttonNavigate = v.findViewById(R.id.btnBack);
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода на другую страницу (Activity)
                Intent intent = new Intent(SecondFragment.this.getActivity(), MenuActivity.class);
                startActivity(intent);
            }
        });

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Камень");
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Ножницы");
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Бумага");
            }
        });
        return v;
    }

    private void playGame(String userChoice) {
        String[] choices = {"Камень", "Ножницы", "Бумага"};
        Random random = new Random();
        int index = random.nextInt(3);
        String computerChoice = choices[index];

        String result = determineWinner(userChoice, computerChoice);

        textResult.setText("Ваш выбор: " + userChoice + "\nВыбор компьютера: " + computerChoice + "\n" + result);
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Ничья!";
        } else if ((userChoice.equals("Камень") && computerChoice.equals("Ножницы")) ||
                (userChoice.equals("Ножницы") && computerChoice.equals("Бумага")) ||
                (userChoice.equals("Бумага") && computerChoice.equals("Камень"))) {
            return "Вы победили!";
        } else {
            return "Вы проиграли!";
        }
    }
}