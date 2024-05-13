package it.saimao.tictactoe;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import it.saimao.tictactoe.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {

    private ActivityIntroBinding binding;
    public static final String PLAYER_ONE = "playerOne", PLAYER_TWO = "playerTwo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initListeners();

    }

    private void initListeners() {

        binding.btStartPlay.setOnClickListener(v -> {
            gotoMainActivity();
        });

    }

    private void gotoMainActivity() {
        var playerOne = binding.etPlayerOne.getText();
        var playerTwo = binding.etPlayerTwo.getText();
        if (playerOne != null && playerOne.length() > 0 && playerTwo != null && playerTwo.length() > 0) {
            var intent = new Intent(this, MainActivity.class);
            intent.putExtra(PLAYER_ONE, playerOne.toString());
            intent.putExtra(PLAYER_TWO, playerTwo.toString());
            startActivity(intent);
            this.finish();
        }
    }

}