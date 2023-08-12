package ir.NMA.pouyamansournia.smart.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import ir.NMA.pouyamansournia.smart.R;


public class Welcome_Two extends Fragment {


    public Welcome_Two() {
    }
    public View view2;
    static ImageView imageView4 , imageView5 , imageView6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view2 = inflater.inflate(R.layout.welcome_two, container, false);

        imageView4 = (ImageView) view2.findViewById(R.id.imageView4);
        imageView5 = (ImageView) view2.findViewById(R.id.imageView5);
        imageView6 = (ImageView) view2.findViewById(R.id.imageView6);



        return view2;
    }
     public static void SetAnimation(Animation animation1,Animation animation2,Animation animation3,int visible){



         imageView4.startAnimation(animation1);
         imageView5.startAnimation(animation2);
         imageView6.startAnimation(animation3);
         imageView4.setVisibility(visible);
         imageView5.setVisibility(visible);
         imageView6.setVisibility(visible);
     }



}
