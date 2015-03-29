package com.ourporc.virtualcash.virtualcash;

import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ViewFlipper;


public class MainActivity extends Activity implements OnGestureListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    // 加速器
    private Interpolator accelerate = new AccelerateInterpolator();
    // 减速器
    private Interpolator decelerate = new DecelerateInterpolator();
    // 消失动画
    private ObjectAnimator disappear = null;
    // 出现动画
    private ObjectAnimator appear = null;

    // 手势是否为从左往右
    private boolean leftToRight = false;

    // 图片资源
    private int[] imageIDs = new int[]{
            R.drawable.gallery_photo_1,
            R.drawable.gallery_photo_2,
            R.drawable.gallery_photo_3,
            R.drawable.gallery_photo_4,
            R.drawable.gallery_photo_5
    };

    // 支持View切换的控件，它包含一个以上的子View，同一个时刻只有一个子View显示
    private ViewFlipper vfContent;
    // 支持检测各种手势事件
    private GestureDetector gestureDetector = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.vfContent = (ViewFlipper) findViewById(R.id.vf_content);
        this.gestureDetector = new GestureDetector(this, this);
        for(int i = 0; i < this.imageIDs.length; i++) {
            ImageView imgv = new ImageView(this);
            imgv.setImageResource(this.imageIDs[i]);
            // 充满父控件
            imgv.setScaleType(ImageView.ScaleType.FIT_XY);
            // 添加到ViewFlipper实例中
            this.vfContent.addView(
                    imgv,
                    new LayoutParams(
                            LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onDown(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        // 对手指滑动的距离进行计算，如果滑动距离大于120，则开始切换动作
        /*
         *  e1 滑动开始事件
         *  e2 滑动进行时事件
         *  velocityX X轴方向的滑动速度
         *  velocityY Y轴方向的滑动速度
         */
        float start = e1.getX();
        float end = e2.getX();

        // 从左向右滑动
        if(start < end && (end - start) > 120) {
//          --------------------------------push效果---------------------------------------------------
            // 添加左边push进入动画
//          this.vfContent.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
            // 添加右边push离开动画
//          this.vfContent.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
//          --------------------------------------------------------------------------------------------------

//          --------------------------------rotate效果---------------------------------------------------
            // 添加左边rotate进入动画
//          this.vfContent.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation_left_in));
            // 添加右边rotate离开动画
//          this.vfContent.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation_right_out));
//          --------------------------------------------------------------------------------------------------

//          --------------------------------scale效果---------------------------------------------------
            // 添加左边scale进入动画
//          this.vfContent.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_in));
            // 添加右边scale离开动画
//          this.vfContent.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_out));
//          --------------------------------------------------------------------------------------------------

//          this.vfContent.showPrevious(); // 显示上一个视图

//          --------------------------------page效果---------------------------------------------------
            leftToRight = true;
            flipit();
//          --------------------------------------------------------------------------------------------------

            return true;

        } else if(start > end && (start - end) > 120) { // 从右向左滑动
//          --------------------------------push效果---------------------------------------------------
//          this.vfContent.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
//          this.vfContent.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
//          --------------------------------------------------------------------------------------------------

//          --------------------------------rotate效果---------------------------------------------------
//          this.vfContent.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation_right_in));
//          this.vfContent.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation_left_out));
//          --------------------------------------------------------------------------------------------------
//          --------------------------------scale效果---------------------------------------------------
//          this.vfContent.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_in));
//          this.vfContent.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_out));
//          --------------------------------------------------------------------------------------------------

//          this.vfContent.showNext(); // 显示下一个视图
//          --------------------------------page效果---------------------------------------------------
            leftToRight = false;
            flipit();
//          --------------------------------------------------------------------------------------------------

            return true;
        }


        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 把触摸事件交给手势检测器处理
        return this.gestureDetector.onTouchEvent(event);

    }

    private void flipit() {

        if(leftToRight) { // 如果手势为从左往右滑动
            // 目标控件为this.vfContent
            // 消失动画属性名称，在此为以Y轴作为旋转轴
            // 消失动画从0角度开始到90角度（顺时针）
            disappear = ObjectAnimator.ofFloat(this.vfContent, "rotationY", 0f, 90f);
            appear = ObjectAnimator.ofFloat(this.vfContent, "rotationY", 270f, 360f);
        } else {
            // 目标控件为this.vfContent
            // 消失动画属性名称，在此为以Y轴作为旋转轴
            // 消失动画从0角度开始到-90角度（逆时针）
            disappear = ObjectAnimator.ofFloat(this.vfContent, "rotationY", 0f, -90f);
            appear = ObjectAnimator.ofFloat(this.vfContent, "rotationY", -270f, -360f);
        }

        disappear.setDuration(700); // 设置动画持续时间
        disappear.setInterpolator(this.accelerate); // 设置加速器
        appear.setDuration(700);
        appear.setInterpolator(decelerate); // 设置减速器

        disappear.addListener(new AnimatorListenerAdapter(){
            @Override
            public void onAnimationEnd(Animator animation) {
                appear.start(); // 当消失动画结束后，开始显示动画
                if(leftToRight) {
                    vfContent.showPrevious(); // 如果手势为从左往右，则显示上一个视图
                } else {
                    vfContent.showNext();
                }

            }
        });

        disappear.start();
    }
}
