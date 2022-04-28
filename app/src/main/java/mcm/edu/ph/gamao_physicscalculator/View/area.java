package mcm.edu.ph.gamao_physicscalculator.View;



import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mcm.edu.ph.gamao_physicscalculator.Control.methods;
import mcm.edu.ph.gamao_physicscalculator.Model.gs;
import mcm.edu.ph.gamao_physicscalculator.R;

public class area extends AppCompatActivity implements View.OnClickListener {
    methods m;
    gs g;
    ImageView triangle, rectangle, circle, ellipse;
    TextView fillblanks, answeris, textView3;
    EditText firstTexts, secondTexts;
    Button solve;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area);

        m = new methods();
        g = new gs();



        textView3 = findViewById(R.id.textView3);

        triangle = findViewById(R.id.triangle);
        circle = findViewById(R.id.circle);
        rectangle = findViewById(R.id.rectangle);
        ellipse = findViewById(R.id.ellipse);
        fillblanks = findViewById(R.id.fillblank);
        firstTexts = findViewById(R.id.firstText);
        secondTexts = findViewById(R.id.secondText);
        solve = findViewById(R.id.solve);
        answeris = findViewById(R.id.answeris);
        triangle.setOnClickListener(this);
        circle.setOnClickListener(this);
        rectangle.setOnClickListener(this);
        ellipse.setOnClickListener(this);
        solve.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circle:
                m.invisible(triangle, rectangle, circle, ellipse, textView3);
                g.setsave(1);
                g.setwhatshape("Circle");
                firstTexts.setHint("Radius");
                m.saveArea(g,m,this);
                m.formulatypes(g, firstTexts, secondTexts, this);
                m.showanswering(fillblanks, answeris, firstTexts, secondTexts, solve);
                secondTexts.setVisibility(View.INVISIBLE);
                fillblanks.setText(g.getwhatshape());

                break;
            case R.id.triangle:
                g.setsave(2);
                firstTexts.setHint("Base");
                secondTexts.setHint("Height");
                g.setwhatshape("Triangle");
                m.saveArea(g,m,this);
                m.invisible(triangle, rectangle, circle, ellipse, textView3);
                m.showanswering(fillblanks, answeris, firstTexts, secondTexts, solve);
                fillblanks.setText(g.getwhatshape());
                break;
            case R.id.rectangle:
                g.setsave(4);
                firstTexts.setHint("Length");
                secondTexts.setHint("Width");
                g.setwhatshape("Rectangle");
                m.saveArea(g,m,this);
                fillblanks.setText(g.getwhatshape());
                g.setanswer(g.getlength() * g.getwidth());
                fillblanks.setText(g.getwhatshape());
                m.invisible(triangle, rectangle, circle, ellipse, textView3);
                m.showanswering(fillblanks, answeris, firstTexts, secondTexts, solve);

                break;
            case R.id.ellipse:
                g.setsave(3);
                firstTexts.setHint("Major Axis");
                secondTexts.setHint("Minor Axis");
                g.setwhatshape("Ellipse");
                m.saveArea(g,m,this);
                m.invisible(triangle, rectangle, circle, ellipse, textView3);
                m.showanswering(fillblanks, answeris, firstTexts, secondTexts, solve);
                fillblanks.setText(g.getwhatshape());
                g.setanswer(g.getmajoraxis() * g.getminoraxis() * Math.PI);

                break;
            case R.id.solve:
                g.setformulas(g.getsave());
                m.formulatypes(g, firstTexts, secondTexts,this);
                fillblanks.setText(g.getwhatshape());
                answeris.setText("The Answer is "+ g.getanswer());
                Log.d(TAG, "formula 2");
                if (firstTexts.equals("")) {
                    firstTexts.setText("Unknown");
                    break;
                }
        }

    }}


