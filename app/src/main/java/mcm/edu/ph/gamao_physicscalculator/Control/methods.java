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
                g.setformulas(1);
                break;
            case 2:
                g.setformulas(2);

                break;
            case 3:
                g.setformulas(3);
                break;
            case 4:
                g.setformulas(4);
                break;
            case 5:
                g.setformulas(5);

                break;
            case 6:
                g.setformulas(6);
                break;
            case 7:
                g.setformulas(7);
                break;
            case 8:
                g.setformulas(8);
                break;


        }
    }
    public  void formulatypes(gs g,EditText firstTexts, EditText secondTexts, Context context) {

        switch (g.getformulas()) {
            case 1:

                try{ g.setradius(Double.parseDouble(firstTexts.getText().toString()));
                    g.setanswer(g.getradius() * g.getradius() * Math.PI);

                } catch(NumberFormatException ex){

                }                break;
            case 2:
                g.setanswer(g.getbase() * g.getheight() * 0.5);
                try{ g.setbase(Double.parseDouble(firstTexts.getText().toString())); } catch(NumberFormatException ex){ }
                try{ g.setheight(Double.parseDouble(secondTexts.getText().toString())); } catch(NumberFormatException ex){ }

                break;
            case 3:
                try{ g.setmajoraxis(Double.parseDouble(firstTexts.getText().toString())); } catch(NumberFormatException ex){ }
                try{ g.setminoraxis(Double.parseDouble(secondTexts.getText().toString())); } catch(NumberFormatException ex){ }

                g.setanswer(g.getmajoraxis() * g.getminoraxis() * Math.PI);
                break;
            case 4:
                try{ g.setlength(Double.parseDouble(firstTexts.getText().toString())); } catch(NumberFormatException ex){ }
                try{ g.setwidth(Double.parseDouble(secondTexts.getText().toString())); } catch(NumberFormatException ex){ }
                g.setanswer(g.getlength() * g.getwidth());

                break;
            case 5:
                try{ g.setradius(Double.parseDouble(firstTexts.getText().toString())); } catch(NumberFormatException ex){ }
                try{ g.setheight(Double.parseDouble(secondTexts.getText().toString())); } catch(NumberFormatException ex){ }
                g.setanswer(g.getradius() * g.getradius() * g.getheight() * Math.PI);

                break;
            case 6:
                try{ g.setradius(Double.parseDouble(firstTexts.getText().toString())); } catch(NumberFormatException ex){ }
                g.setanswer(g.getradius() * g.getradius() * g.getradius() * Math.PI * (4 / 3));
                break;
            case 7:
                try{ g.setradius(Double.parseDouble(firstTexts.getText().toString())); } catch(NumberFormatException ex){ }
                try{  g.setheight(Double.parseDouble(secondTexts.getText().toString()));
                } catch(NumberFormatException ex){ }
                g.setanswer(Math.PI * g.getradius() * g.getradius() * g.getheight());

                break;
            case 8:
                try{g.setside(Double.parseDouble(firstTexts.getText().toString()));
                } catch(NumberFormatException ex){ }
                g.setanswer(g.getside() * g.getside() * g.getside());
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






