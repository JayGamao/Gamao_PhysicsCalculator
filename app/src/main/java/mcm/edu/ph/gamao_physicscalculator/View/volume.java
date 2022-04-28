package mcm.edu.ph.gamao_physicscalculator.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mcm.edu.ph.gamao_physicscalculator.Control.methods;
import mcm.edu.ph.gamao_physicscalculator.Model.gs;
import mcm.edu.ph.gamao_physicscalculator.R;

public class volume extends AppCompatActivity implements View.OnClickListener {

    methods m;
    gs g;
    ImageView cylinder, sphere, cube, cone;
    TextView fillblanks, answeris, textView2;
    EditText firstTexts, secondTexts;
    Button solve;
    double answer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume);
        g = new gs();
        m = new methods();




        textView2 = findViewById(R.id.textView2);
        fillblanks = findViewById(R.id.fillblank);
        firstTexts = findViewById(R.id.firstText);
        secondTexts = findViewById(R.id.secondText);
        solve = findViewById(R.id.solve);
        answeris = findViewById(R.id.answeris);
        solve.setOnClickListener(this);

        cylinder=findViewById(R.id.cylinder);
        cone=findViewById(R.id.cone);
        cube=findViewById(R.id.cube);
        sphere=findViewById(R.id.sphere);

        cylinder.setOnClickListener(this);
        cone.setOnClickListener(this);
        cube.setOnClickListener(this);
        sphere.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cylinder:
                try{ g.setradius(Double.parseDouble(firstTexts.getText().toString())); } catch(NumberFormatException ex){ }
                try{ g.setheight(Double.parseDouble(secondTexts.getText().toString())); } catch(NumberFormatException ex){ }
                m.invisible2(sphere,cone,cylinder,cube,textView2);
                m.showanswering(fillblanks, answeris, firstTexts, secondTexts, solve);
                answer = (g.getradius() * g.getradius() * g.getheight() * Math.PI);
                firstTexts.setHint("Radius");
                secondTexts.setHint("Height");
                g.setwhatshape("Cylinder");
                fillblanks.setText(g.getwhatshape());

                break;
            case R.id.cube:

                firstTexts.setHint("Side");
                g.setwhatshape("Cube");
                m.invisible2(sphere,cone,cylinder,cube,textView2);
                m.showanswering(fillblanks, answeris, firstTexts, secondTexts, solve);
                secondTexts.setVisibility(View.INVISIBLE);
                fillblanks.setText(g.getwhatshape());
                try{g.setside(Double.parseDouble(firstTexts.getText().toString()));
                } catch(NumberFormatException ex){ }
                g.setanswer(g.getside() * g.getside() * g.getside());
                break;
            case R.id.sphere:
                firstTexts.setHint("Radius");
                g.setwhatshape("Sphere");
                m.invisible2(sphere,cone,cylinder,cube,textView2);
                m.showanswering(fillblanks, answeris, firstTexts, secondTexts, solve);
                secondTexts.setVisibility(View.INVISIBLE);
                fillblanks.setText(g.getwhatshape());
                try{ g.setradius(Double.parseDouble(firstTexts.getText().toString())); } catch(NumberFormatException ex){ }
                g.setanswer(g.getradius() * g.getradius() * g.getradius() * Math.PI * (4 / 3));
                break;
            case R.id.cone:
                firstTexts.setHint("Radius");
                secondTexts.setHint("Height");
                g.setwhatshape("Cone");
                m.invisible2(sphere,cone,cylinder,cube,textView2);
                m.showanswering(fillblanks, answeris, firstTexts, secondTexts, solve);
                fillblanks.setText(g.getwhatshape());
                try{ g.setradius(Double.parseDouble(firstTexts.getText().toString())); } catch(NumberFormatException ex){ }
                try{                 g.setheight(Double.parseDouble(secondTexts.getText().toString()));
                } catch(NumberFormatException ex){ }
                g.setanswer(Math.PI * g.getradius() * g.getradius() * g.getheight());
                break;
            case R.id.solve:
                answeris.setText("The Answer is "+ answer);
                if (firstTexts.equals("")) {
                    firstTexts.setText("Unknown");
                }
                break;
        }
    }
}
