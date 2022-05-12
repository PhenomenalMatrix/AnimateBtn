package com.mrflaitx.animatebtn;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;

import com.mrflaitx.animatebtn.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setStartTransparent();
        initListeners();
    }

    private void initListeners() {
        binding.animateBtn.setOnClickListener(v -> {
            openContainer();
        });
    }

    private void openContainer() {
        binding.containerForViews.animate().scaleX(1).setDuration(200).start();
        binding.containerForViews.animate().scaleY(1).setDuration(200).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                binding.itemView.setVisibility(View.VISIBLE);
                binding.itemView2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        }).start();
    }

    private void setStartTransparent() {
        binding.containerForViews.setScaleX(0);
        binding.containerForViews.setScaleY(0);
    }
}