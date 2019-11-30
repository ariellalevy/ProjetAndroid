package com.example.ariellalevy.projetandroid_levy_ariella_grp31;

import android.support.v4.app.Fragment;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue.MainActivity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    MainActivity mainActivity;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void loadFragment(Fragment fragment){
        boolean res = mainActivity.loadFragment(fragment);
        assertEquals(true,res);
    }


}