package ir.NMA.pouyamansournia.smart.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import ir.NMA.pouyamansournia.smart.R;


public class Welcome_Four extends Fragment {


    public Welcome_Four() {
    }

    static ImageView imageView8;
    View view4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view4 = inflater.inflate(R.layout.welcome_four, container, false);

        imageView8 = (ImageView) view4.findViewById(R.id.imageView8);

        return view4;
    }
    public static void SetAnimation(Animation animation1,int visible){

        imageView8.startAnimation(animation1);
        imageView8.setVisibility(visible);
    }
}
