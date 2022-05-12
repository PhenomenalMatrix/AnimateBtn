package com.mrflaitx.animatebtn;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;

import com.mrflaitx.animatebtn.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Boolean isOpened = false;

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
            if(!isOpened) {
                openContainer();
            }else {
                closeContainer();
            }
        });
    }

    private void closeContainer() {
        isOpened = false;
        binding.containerForViews.animate().scaleX(0).setDuration(200).start();
        binding.containerForViews.animate().scaleY(0).setDuration(200).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                binding.itemView.setVisibility(View.GONE);
                binding.itemView2.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        }).start();
    }

    private void openContainer() {
        isOpened = true;
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