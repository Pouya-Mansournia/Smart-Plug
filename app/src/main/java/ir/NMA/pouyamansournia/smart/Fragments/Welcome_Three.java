package ir.NMA.pouyamansournia.smart.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import ir.NMA.pouyamansournia.smart.R;


public class Welcome_Three extends Fragment {


    public Welcome_Three() {
    }
    static ImageView imageView7;
    View view3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view3 = inflater.inflate(R.layout.welcome_three, container, false);

        imageView7 = (ImageView) view3.findViewById(R.id.imageView7);

        return view3;
    }

    public static void SetAnimation(Animation animation1,int visible){

        imageView7.startAnimation(animation1);
        imageView7.setVisibility(visible);
    }

}
