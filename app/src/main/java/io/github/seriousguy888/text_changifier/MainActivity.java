package io.github.seriousguy888.text_changifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    boolean enableCapitaliseMode = false;
    boolean enableReverseMode = false;
    boolean enableScrambleMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int green = getResources().getColor(R.color.green);
        final int red = getResources().getColor(R.color.red);



//        Timer timer = new Timer(this, System.currentTimeMillis() / 1000 + 120);
//        TextView timerView = findViewById(R.id.timer);
//        timerView.setText((int) timer.getTimeLeft());




        final TextView outputField = findViewById(R.id.outputField);
        final EditText inputField = findViewById(R.id.textInput);

        final Button clearButton = findViewById(R.id.clearButton);
        final Button goButton = findViewById(R.id.goButton);

        final Button capitaliseModeButton = findViewById(R.id.capitaliseMode);
        final Button reverseModeButton = findViewById(R.id.reverseMode);
        final Button scrambleModeButton = findViewById(R.id.scrambleMode);


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText("");
            }
        });
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputField.getText().toString();
                if(enableCapitaliseMode) {
                    text = text.toUpperCase();
                }
                if(enableReverseMode) {
                    text = new StringBuilder(text).reverse().toString();
                }
                if(enableScrambleMode) {
                    List<Character> characters = new ArrayList<Character>();
                    for(char c : text.toCharArray()) {
                        characters.add(c);
                    }
                    StringBuilder scrambledText = new StringBuilder(text.length());
                    while(characters.size() != 0) {
                        int randomCharacter = (int)(Math.random() * characters.size());
                        scrambledText.append(characters.remove(randomCharacter));
                    }

                    text = scrambledText.toString();
                }
                outputField.setText(text);
            }
        });

        capitaliseModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableCapitaliseMode = !enableCapitaliseMode;
                if(enableCapitaliseMode)    capitaliseModeButton.setBackgroundColor(green);
                else                        capitaliseModeButton.setBackgroundColor(red);
            }
        });

        reverseModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableReverseMode = !enableReverseMode;
                if(enableReverseMode)   reverseModeButton.setBackgroundColor(green);
                else                    reverseModeButton.setBackgroundColor(red);
            }
        });

        scrambleModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableScrambleMode = !enableScrambleMode;
                if(enableScrambleMode)   scrambleModeButton.setBackgroundColor(green);
                else                     scrambleModeButton.setBackgroundColor(red);
            }
        });
    }
}