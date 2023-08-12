/*
 * Copyright (C) 2016 .all right reserved for Esfandune.ir & Mohammad Rahmani
 * salam
 * in source ba zahmate faravani tahiye va montasher shode
 * lotfan az enteshare source khoddari farmaeid.
 * in kar be lahaze ghanuni va shar'i gheire ghanuni mibashad
 * lotfan baraye hemayat az ma dustane barnamenevise khod ra be Esfandune.ir hedayat konid.
 * ba tashakor az shoma
* MOhammad Rahmani
 */

package ir.NMA.pouyamansournia.smart.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import ir.NMA.pouyamansournia.smart.Fragments.Welcome_Five;
import ir.NMA.pouyamansournia.smart.Fragments.Welcome_Four;
import ir.NMA.pouyamansournia.smart.Fragments.Welcome_One;
import ir.NMA.pouyamansournia.smart.Fragments.Welcome_Three;
import ir.NMA.pouyamansournia.smart.Fragments.Welcome_Two;
import ir.NMA.pouyamansournia.smart.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * by Esfandune.ir(Mohammad Rahmani)
 */
public class Welcome extends AppCompatActivity {

    TextView term;
    CheckBox check;
    Button exit,login;
    RadioGroup radio;
    ViewPager viewPager;
    SharedPreferences sharedPrefer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //taghire fonte activity
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());


        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        exit =(Button) findViewById(R.id.button);
        login=(Button) findViewById(R.id.button2);
        check = (CheckBox) findViewById(R.id.check);
        term = (TextView) findViewById(R.id.term);
        radio= (RadioGroup) findViewById(R.id.radiogroup);
        sharedPrefer = getSharedPreferences("smart", 0);
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        exit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });

        term.setVisibility(View.INVISIBLE);

        login.setEnabled(false);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i = new Intent(Welcome.this, MainActivity.class);
                startActivity(i);
            }
        });

        check.setVisibility(View.INVISIBLE);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check.isChecked()) {
                    login.setEnabled(true);
                } else {
                    login.setEnabled(false);
                }
            }
        });


        setupViewPager(viewPager);

        //ejraye viewpager az akharin safe(baraye rast chin shodane viewpager)
        viewPager.setCurrentItem(4);



        //roydade taghire safahat dar viewpager
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 4:
                        radio.check(R.id.radioButton);
                        login.setEnabled(false);
                        check.setVisibility(View.INVISIBLE);
                        term.setVisibility(View.INVISIBLE);

                        //set kardan animation baraye fragmente marbute
                        Animation up1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_left_in);
                        Animation left1 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
                        Animation right1 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
                        up1.setDuration(3500);
                        left1.setDuration(1500);
                        right1.setDuration(2500);
                        Welcome_One.SetAnimation(left1 , up1 , right1 , View.VISIBLE);
                        break;

                    case 3:
                        radio.check(R.id.radioButton2);
                        login.setEnabled(false);
                        check.setVisibility(View.INVISIBLE);
                        term.setVisibility(View.INVISIBLE);

                        Animation up2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_up_in);
                        Animation left2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_left_in);
                        Animation right2 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
                        up2.setDuration(3000);
                        left2.setDuration(2500);
                        right2.setDuration(2500);
                        Welcome_Two.SetAnimation(left2 ,up2 , right2 , View.VISIBLE);
                        break;

                    case 2:
                        radio.check(R.id.radioButton3);
                        login.setEnabled(false);
                        check.setVisibility(View.INVISIBLE);
                        term.setVisibility(View.INVISIBLE);

                        Animation clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                        Welcome_Three.SetAnimation(clockwise , View.VISIBLE);
                        break;

                    case 1:
                        radio.check(R.id.radioButton4);
                        login.setEnabled(false);
                        check.setVisibility(View.INVISIBLE);
                        term.setVisibility(View.INVISIBLE);

                        Animation blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                        Welcome_Four.SetAnimation(blink , View.VISIBLE);
                        break;

                    case 0:
                        radio.check(R.id.radioButton5);
                        login.setEnabled(false);
                        check.setVisibility(View.VISIBLE);
                        term.setVisibility(View.VISIBLE);
                        if (check.isChecked()) {
                            login.setEnabled(true);
                        } else {
                            login.setEnabled(false);
                        }

                        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                        Welcome_Five.SetAnimation(zoom , View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int position) {
                // TODO Auto-generated method stub
            }
        });
    }

    //methode sakhte viewpager ba fragment
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new Welcome_Five());
        adapter.addFragment(new Welcome_Four());
        adapter.addFragment(new Welcome_Three());
        adapter.addFragment(new Welcome_Two());
        adapter.addFragment(new Welcome_One());

        viewPager.setAdapter(adapter);
    }


    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment) {
            mFragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

     @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}
