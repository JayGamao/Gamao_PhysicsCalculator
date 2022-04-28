package mcm.edu.ph.gamao_physicscalculator.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import mcm.edu.ph.gamao_physicscalculator.R;

public class intro_screen extends AppCompatActivity {

    ImageView area, volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introscreen);

        area = findViewById(R.id.imgArea);
        volume = findViewById(R.id.imgVolume);
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(intro_screen.this, area.class));
            }
        });
        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(intro_screen.this, volume.class));
            }

        });
    }
    }