package com.example.galarteia;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.galarteia.R;

public class MainActivity extends AppCompatActivity {
    int [] zdjecia = {R.drawable.bibo1, R.drawable.bibo2, R.drawable.bibo3, R.drawable.bibo4, R.drawable.bibo5,};
    private Button next;
    private Button prev;
    private ImageView zdj;
    private Switch zmienTlo;
    private EditText wybierz;
    private View main2;
    int obraz = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        next = findViewById(R.id.button);
        prev = findViewById(R.id.button2);
        zdj = findViewById(R.id.imageView);
        zdj.setImageResource(zdjecia[0]);
        zmienTlo = findViewById(R.id.switch1);
        wybierz = findViewById(R.id.editTextText);
        main2 = findViewById(R.id.main);

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(obraz!=4){
                            obraz++;
                            zdj.setImageResource(zdjecia[obraz]);
                        }
                        else{
                            obraz=0;
                            zdj.setImageResource(zdjecia[obraz]);
                        }
                    }
                }
        );

        prev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(obraz!=0){
                            obraz--;
                            zdj.setImageResource(zdjecia[obraz]);
                        }
                        else{
                            obraz=4;
                            zdj.setImageResource(zdjecia[obraz]);
                        }
                    }
                }
        );

        zmienTlo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if(b){
                    main2.setBackgroundColor(Color.parseColor("blue"));
                }
                else{
                    main2.setBackgroundColor(Color.parseColor("#00796B"));
                }
            }
        });
        wybierz.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    if (Integer.parseInt(charSequence.toString()) >= 0 && Integer.parseInt(charSequence.toString()) <= zdjecia.length) {
                        zdj.setImageResource(zdjecia[Integer.parseInt(charSequence.toString())]);
                    }
                }
            }
        });
    }
}