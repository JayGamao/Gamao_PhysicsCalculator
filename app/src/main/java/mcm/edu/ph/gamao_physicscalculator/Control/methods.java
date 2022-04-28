package mcm.edu.ph.gamao_physicscalculator.Control;

import static android.content.ContentValues.TAG;



import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import mcm.edu.ph.gamao_physicscalculator.Model.gs;
import mcm.edu.ph.gamao_physicscalculator.View.area;
import mcm.edu.ph.gamao_physicscalculator.View.intro_screen;
import mcm.edu.ph.gamao_physicscalculator.View.solvingscreen;
import mcm.edu.ph.gamao_physicscalculator.View.volume;

public class methods {

    public methods() {

        new gs();
        new area();
        new intro_screen();
        new volume();
    }

    public void toSolvingScreen(Context context) {
        context.startActivity(new Intent(context, solvingscreen.class));
    }

    public void saveArea(gs g,methods m,Context context){
        switch (g.getsave()){
            case 1:
                Log.d(TAG, "triangle");
                g.setsave(1);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;


        }
    }
    public  void formulatypes(gs g,EditText firstTexts, EditText secondTexts, Context context) {

        switch (g.getformulas()) {
            case 1:
                Log.d(TAG, "formula 1");
                break;
            case 2:
                g.setanswer(g.getbase() * g.getheight() * 0.5);
                g.setbase(Double.parseDouble(firstTexts.getText().toString()));
                g.setheight(Double.parseDouble(secondTexts.getText().toString()));
                firstTexts.setHint("Base");
                secondTexts.setHint("Height");
                g.setwhatshape("Triangle");
                break;
            case 3:
                g.setanswer(g.getmajoraxis() * g.getminoraxis() * Math.PI);
                g.setmajoraxis(Double.parseDouble(firstTexts.getText().toString()));
                g.setminoraxis(Double.parseDouble(secondTexts.getText().toString()));
                firstTexts.setHint("Major Axis");
                secondTexts.setHint("Minor Axis");
                g.setwhatshape("Ellipse");
                break;
            case 4:
                g.setanswer(g.getlength() * g.getwidth());
                g.setlength(Double.parseDouble(firstTexts.getText().toString()));
                g.setwidth(Double.parseDouble(secondTexts.getText().toString()));
                firstTexts.setHint("Length");
                secondTexts.setHint("Width");
                g.setwhatshape("Rectangle");
                break;
            case 5:
                g.setanswer(g.getradius() * g.getradius() * g.getheight() * Math.PI);
                g.setradius(Double.parseDouble(firstTexts.getText().toString()));
                g.setheight(Double.parseDouble(secondTexts.getText().toString()));
                firstTexts.setHint("Radius");
                secondTexts.setHint("Height");
                g.setwhatshape("Cylinder");
                break;
            case 6:
                g.setanswer(g.getradius() * g.getradius() * g.getradius() * Math.PI * (4 / 3));
                g.setradius(Double.parseDouble(firstTexts.getText().toString()));
                firstTexts.setHint("Radius");
                secondTexts.setVisibility(View.INVISIBLE);
                g.setwhatshape("Sphere");
                break;
            case 7:
                g.setanswer(Math.PI * g.getradius() * g.getradius() * g.getheight());
                g.setradius(Double.parseDouble(firstTexts.getText().toString()));
                g.setheight(Double.parseDouble(secondTexts.getText().toString()));
                firstTexts.setHint("Radius");
                secondTexts.setHint("Height");
                g.setwhatshape("Cone");
                break;
            case 8:
                g.setanswer(g.getside() * g.getside() * g.getside());
                g.setside(Double.parseDouble(firstTexts.getText().toString()));
                firstTexts.setHint("Side");
                secondTexts.setVisibility(View.INVISIBLE);
                g.setwhatshape("Cube");
                break;
        }
    }
    public void invisible(ImageView triangle, ImageView rectangle, ImageView circle, ImageView ellipse, TextView textView3){
        triangle.setVisibility(View.INVISIBLE);
        rectangle.setVisibility(View.INVISIBLE);
        circle.setVisibility(View.INVISIBLE);
        ellipse.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        }

        public void showanswering(TextView fillblanks, TextView answeris, EditText firstTexts, EditText secondTexts, Button solve){
        fillblanks.setVisibility(View.VISIBLE);
        answeris.setVisibility(View.VISIBLE);
        firstTexts.setVisibility(View.VISIBLE);
        secondTexts.setVisibility(View.VISIBLE);
        solve.setVisibility(View.VISIBLE);

        }
        public void invisible2(ImageView sphere, ImageView cone, ImageView cylinder,ImageView cube, TextView textView2){
        sphere.setVisibility(View.INVISIBLE);
        cone.setVisibility(View.INVISIBLE);
        cylinder.setVisibility(View.INVISIBLE);
        cube.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);

        }
}






