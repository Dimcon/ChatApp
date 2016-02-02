package com.cybermelon.chatappmain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daimon on 1/27/2016.
 */
public class MultiViewHolder extends RelativeLayout {
    float fXunit;
    float fYunit;
    Rect rOutSpace;
    int iScreenCount = -1;
    int iStartView = 0;
    int iEndView = 0;
    int iCurrentView = 0;
    float fLeft = 0;
    float KeyboardMargin = 0;
    float ViewMargin = 5;
    List<ScreenView> screens = new ArrayList<ScreenView>();
    Burrito bSlider;
    boolean bFirstViewAdded = false;

    private void Init(float fHeight, float fWidth) {
        fXunit = (fWidth)/100;
        fYunit = (fHeight)/100;
        Log.e("",fXunit + ":" + fYunit);
        bSlider = new Burrito(-50*fXunit,0*fXunit,250,Interpolator.sin);
        setWillNotDraw(false);
        for (int i = 0; i < iScreenCount + 1;i++) {
            screens.add(new ScreenView(i));
        }
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                invalidate();
                float X = event.getX();
                float Y = event.getY();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    fDistBetweenViewAndTouch = X - fLeft;
                    Log.e("", "eeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    fLeft = X - fDistBetweenViewAndTouch;
                    for (int i = 0; i < screens.size(); i++) {
                        ScreenView sv = screens.get(i);
                        sv.AlignLeft(fLeft);
                    }
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    int iScreenToGoTo = iCurrentView;
                    float fRelativeLeft = -fLeft % (100*fXunit);
                    float LessThan = ((-iCurrentView)*100*fXunit) - (10*fXunit);
                    float MoreThan = ((-iCurrentView)*100*fXunit) + (10*fXunit);
                    if (fLeft < LessThan) iScreenToGoTo = iCurrentView + 1;
                    if (fLeft > MoreThan) iScreenToGoTo = iCurrentView - 1;
                    if (iScreenToGoTo < 0) iScreenToGoTo = 0;
                    if (iScreenToGoTo > iScreenCount) iScreenToGoTo = iScreenCount;
                    if (iCurrentView > iScreenToGoTo) {
                        bSlider = new Burrito(fLeft,-iScreenToGoTo * (100*fXunit),250, Interpolator.sin);
                    } else {
                        bSlider = new Burrito(fLeft,-iScreenToGoTo * (100*fXunit),250, Interpolator.cosin);
                    }
                    iCurrentView = iScreenToGoTo;
                }
                return true;
            }
        });
    }

    float fDistBetweenViewAndTouch = 0;

    public MultiViewHolder(Context context,Rect rOut,int Screens) {
        super(context);
        iScreenCount = Screens - 1;
        this.rOutSpace = rOut;
        Init(rOut.height(),rOut.width());
    }

    float fTouchDownY;
    float fTouchDownX;
    boolean bMovingHorizontally = false;
    boolean bMovingVertically = false;

    public MultiViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void GoToScreen(int iScreen) {
        if (iCurrentView > iScreen) {
            bSlider = new Burrito(fLeft,-iScreen * (100*fXunit),110, Interpolator.sin);
        } else {
            bSlider = new Burrito(fLeft,-iScreen * (100*fXunit),110, Interpolator.cosin);
        }
        iCurrentView = iScreen;
    }

    public void GoToScreen(String s) {
        for (int i = 0; i < screens.size(); i++) {
            ScreenView s1 = screens.get(i);
            for (String s2 : s1.sIDs) {
                if (s2.equals(s)) {
                    GoToScreen(i);
                    break;
                }
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!bSlider.Animate()) {
            invalidate();
            fLeft = bSlider.GetValue();
        }
        for (int i = 0; i < screens.size(); i++) {
            screens.get(i).AlignLeft(fLeft);
        }
    }

    public void AddScreen(boolean bToEnd,View... v) {

    }

    public View AddView(int iResource,int Screen,int Stepheight, String sID,boolean bIsTextView) {
        if (!bFirstViewAdded) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.blankview,this);
            bFirstViewAdded = true;
        }
        View v = findViewById(iResource);
        float iTop = 0;
        iTop = screens.get(Screen).iHeight;
        LayoutParams lp;
        if (bIsTextView) {
            lp = new LayoutParams((int)((100 - (2*KeyboardMargin))*fXunit),(int)(45*fYunit));
            screens.get(Screen).iHeight = screens.get(Screen).iHeight + (45*fYunit) + (2*fXunit);
            v.setTranslationX((int) ((KeyboardMargin*fXunit) + fLeft + (Screen * (100 * fXunit))));
            v.setTranslationY(65*fYunit);
        } else {
            lp = new LayoutParams((int) ((100 - (2*ViewMargin)) * fXunit), (int) (Stepheight * fYunit));
            screens.get(Screen).iHeight = screens.get(Screen).iHeight + (Stepheight * fYunit) + (2 * fXunit);
            v.setTranslationX((int) ((ViewMargin * fXunit) + fLeft + (Screen * (100 * fXunit))));
            v.setTranslationY(rOutSpace.top + iTop);
        }
        v.setLayoutParams(lp);
        screens.get(Screen).AddView(v,Stepheight,bIsTextView,sID);
        return v;
    }

    public View AddDuplicateView(View Parent,int iResource,int Screen,int Stepheight, String sID,boolean bIsTextView) {
        if (!bFirstViewAdded) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.blankview,this);
            bFirstViewAdded = true;
        }
        View v = Parent.findViewById(iResource);
        float iTop = 0;
        iTop = screens.get(Screen).iHeight;
        LayoutParams lp;
        if (bIsTextView) {
            lp = new LayoutParams((int)((100 - (2*KeyboardMargin))*fXunit),(int)(45*fYunit));
            screens.get(Screen).iHeight = screens.get(Screen).iHeight + (45*fYunit) + (2*fXunit);
            v.setTranslationX((int) ((KeyboardMargin*fXunit) + fLeft + (Screen * (100 * fXunit))));
            v.setTranslationY(65*fYunit);
        } else {
            lp = new LayoutParams((int) ((100 - (2*ViewMargin)) * fXunit), (int) (Stepheight * fYunit));
            screens.get(Screen).iHeight = screens.get(Screen).iHeight + (Stepheight * fYunit) + (2 * fXunit);
            v.setTranslationX((int) ((ViewMargin * fXunit) + fLeft + (Screen * (100 * fXunit))));
            v.setTranslationY(rOutSpace.top + iTop);
        }
        v.setLayoutParams(lp);
        screens.get(Screen).AddView(v,Stepheight,bIsTextView,sID);
        return v;
    }

    public void HeightChanged(Rect rOutSpaceP,boolean bKeyboardUp) {
        float fPrevHeight = rOutSpace.height();
        float fDiff = (fPrevHeight - rOutSpaceP.height()) - ((!bKeyboardUp)?0:rOutSpace.top);
        for (ScreenView sv: screens) {
            sv.AdjustHeights((-fDiff));
        }
    }
    class ScreenView {
        List<View> Views = new ArrayList<View>();
        List<Float> ViewHeight = new ArrayList<Float>();
        List<String> sIDs = new ArrayList<String>();
        float iHeight = 0;
        int iTextView = -1;
        int iScreenNum = 0;
        int iTextViewHeight = 0;

        public ScreenView(int iScreenNumP) {
        iScreenNum = iScreenNumP;
        }

        public void AddView(View v,float iViewHeight,Boolean bIsTextView,String sID) {
            Views.add(v);
            sIDs.add(sID);
            ViewHeight.add(iViewHeight);
            if (bIsTextView) {
                iTextView = Views.size() - 1;
            }
        }

        public void AdjustHeights(float fFrom) {
            iHeight = fFrom;
            for (int i = 0; i < Views.size(); i++) {
                View v = Views.get(i);
                float iTop = 0;
                iTop = screens.get(iScreenNum).iHeight;
                LayoutParams lp;
                if (i == iTextView) {
                    //lp = new LayoutParams((int)(98f*fXunit),(int)(100*fYunit));
                    screens.get(iScreenNum).iHeight = screens.get(iScreenNum).iHeight + (45*fYunit) + (2*fXunit);
                    v.setTranslationX((int) ((KeyboardMargin * fXunit) + fLeft + (iScreenNum * (100 * fXunit))));
                    v.setTranslationY(fFrom + (65*fYunit));
                } else {
                    //lp = new LayoutParams((int) (90 * fXunit), (int) (ViewHeight.get(i) * fYunit));
                    screens.get(iScreenNum).iHeight = screens.get(iScreenNum).iHeight + (ViewHeight.get(i) * fYunit) + (2 * fXunit);
                    v.setTranslationX((int) ((ViewMargin * fXunit) + fLeft + (iScreenNum * (100 * fXunit))));
                    v.setTranslationY(rOutSpace.top + iTop);
                }
                //v.setLayoutParams(lp);
            }
        }

        public void AlignLeft(float fLeft) {
            if (iTextView < 0) {
                for (int i = 0; i < Views.size(); i++) {
                    View v = Views.get(i);
                    v.setTranslationX((int) ((ViewMargin*fXunit) + fLeft + (iScreenNum * (100 * fXunit))));
                }
            } else {
                for (int i = 0; i < Views.size(); i++) {
                    View v = Views.get(i);
                    if (i != iTextView) v.setTranslationX((int) ((ViewMargin*fXunit) + fLeft + (iScreenNum * (100 * fXunit))));
                    else v.setTranslationX((int) ((KeyboardMargin*fXunit) + fLeft + (iScreenNum * (100 * fXunit))));
                }
            }
        }
    }
}

