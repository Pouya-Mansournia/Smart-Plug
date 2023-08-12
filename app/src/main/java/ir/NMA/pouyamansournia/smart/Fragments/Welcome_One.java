package ir.NMA.pouyamansournia.smart.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import ir.NMA.pouyamansournia.smart.R;

public class Welcome_One extends Fragment {


    public Welcome_One() {
    }
    static ImageView imageView1 , imageView2 , imageView3;
    View view1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view1 = inflater.inflate(R.layout.welcome_one, container, false);

        imageView1 = (ImageView) view1.findViewById(R.id.imageView1);
        imageView2 = (ImageView) view1.findViewById(R.id.imageView2);
        imageView3 = (ImageView) view1.findViewById(R.id.imageView3);

        Animation up1 = AnimationUtils.loadAnimation(getContext(), R.anim.push_left_in);
        Animation left1 = AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left);
        Animation right1 = AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left);
        up1.setDuration(3500);
        left1.setDuration(1500);
        right1.setDuration(2500);
        Welcome_One.SetAnimation(left1, up1, right1, View.VISIBLE);

        return view1;
    }
    //methodi ke maghadire an az class Welcome gerefte mishavad
    public static void SetAnimation(Animation animation1,Animation animation2,Animation animation3,int visible){

        imageView1.startAnimation(animation1);
        imageView2.startAnimation(animation2);
        imageView3.startAnimation(animation3);
        imageView1.setVisibility(visible);
        imageView2.setVisibility(visible);
        imageView3.setVisibility(visible);
    }

}
