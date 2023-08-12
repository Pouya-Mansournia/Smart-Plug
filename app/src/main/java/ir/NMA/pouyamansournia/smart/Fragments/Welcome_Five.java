package ir.NMA.pouyamansournia.smart.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import ir.NMA.pouyamansournia.smart.R;

public class Welcome_Five extends Fragment {


    public Welcome_Five() {
    }

    static ImageView imageView9;
    View view5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view5 = inflater.inflate(R.layout.welcome_five, container, false);

        imageView9 = (ImageView) view5.findViewById(R.id.imageView9);

        return view5;
    }

    public static void SetAnimation(Animation animation1,int visible){

        imageView9.startAnimation(animation1);
        imageView9.setVisibility(visible);
    }

}
