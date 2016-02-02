package com.cybermelon.chatappmain;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.*;
import android.widget.RelativeLayout;
import com.cybermelon.chatappmain.adapters.ChatListAdapter;
import com.cybermelon.chatappmain.adapters.ContactListAdapter;

public class ChatAppMain extends Activity {


    int iNormalHeight = 0;
    boolean bFirsRun = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final CustomView v = new CustomView(this);
        v.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int height = v.getHeight();
                Log.w("Foo", String.format("layout height: %d", height));
                Rect r = new Rect();
                v.getWindowVisibleDisplayFrame(r);
                int visible = r.bottom - r.top;
                if (!bFirsRun){
                    iNormalHeight = visible;
                    bFirsRun = true;
                }
                if (iNormalHeight != visible) {
                    v.LayoutChanged(r.height(),r.width());
                    iNormalHeight = visible;
                }
                Log.e("Foo", String.format("visible height: %d", visible));
                Log.w("Foo", String.format("keyboard height: %d", height - visible));
            }
        });
        setContentView(v);
    }

    class CustomView extends RelativeLayout {

        float fXunit;
        float fYunit;
        android.support.v7.widget.RecyclerView Contacts;
        View ContactCard;
        android.support.v7.widget.RecyclerView Chats;
        View Chats2;
        View Favourites;
        View Profile;
        View BlankView;
        float fDistBetweenProfileAndTouch;
        float fProfileUpSeperator = 200;
        float fProfileDownSeperator = 700;
        float fProfileTopPosition = 915;
        boolean bProfileGoingDown = false;
        Burrito bProfileTop = new Burrito((fProfileTopPosition / 3)*2,fProfileTopPosition,250,Interpolator.sin);
        MultiViewHolder m;
        boolean bKeyboardUp = false;
        int fWidth = 0;
        int fHeight = 0;

        public CustomView(Context context) {
            super(context);
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y;
            fWidth = width;
            fHeight = height;
            fXunit = width/100;
            fYunit = height/100;
            fProfileUpSeperator = 11.2f*fYunit;
            fProfileDownSeperator = 39.4f*fYunit;
            fProfileTopPosition = 54f*fYunit;
            Log.e("",width + ":" + height);

            m = new MultiViewHolder(context,new Rect(0,(int)(13*fYunit),width,height),3);
            addView(m);

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.activity_contacts,m);
            ContactCard = m.AddView(R.id.contactcard,0,60,"Contacts",false);
            Contacts = (RecyclerView)ContactCard.findViewById(R.id.contact_recycler_list);
            Contacts.setAdapter(new ContactListAdapter());
            Contacts.setLayoutManager(new StaggeredGridLayoutManager(3,1));

            inflater.inflate(R.layout.layout_favourites,m);
            Favourites = m.AddView(R.id.favourites,0,32,"Favourites",false);

            inflater.inflate(R.layout.chat_view,m);
            Chats2 = m.AddView(R.id.chats_view,1,80,"Chat",false);
            Chats = (android.support.v7.widget.RecyclerView ) Chats2.findViewById(R.id.chats_recycler_view);
            Chats.setAdapter(new ChatListAdapter("Daimon"));
            Chats.setLayoutManager(new LinearLayoutManager(context));

            inflater.inflate(R.layout.text_entry_layout,m);
            Chats2 = m.AddView(R.id.text_entry_view,1,15,"Text",true);

            Chats2 = inflater.inflate(R.layout.chat_view,null);
            m.addView(Chats2);
            Chats2 = m.AddDuplicateView(Chats2,R.id.chats_view,2,80,"Chat2",false);
            Chats = (android.support.v7.widget.RecyclerView) Chats2.findViewById(R.id.chats_recycler_view);
            Chats.setAdapter(new ChatListAdapter("Daimon"));
            Chats.setLayoutManager(new LinearLayoutManager(context));

            Chats2 = inflater.inflate(R.layout.text_entry_layout,null);
            m.addView(Chats2);
            Chats2 = m.AddDuplicateView(Chats2, R.id.text_entry_view, 2, 15, "Text2",true);

            setWillNotDraw(false);
            Profile = getLayoutInflater().inflate(R.layout.profile_layout,this);
            Profile = Profile.findViewById(R.id.profile_view);
            Profile.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    invalidate();
                    float Y = event.getY();
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        fDistBetweenProfileAndTouch= Y - Profile.getPaddingTop();
                        return true;
                    } else if (event.getAction() == MotionEvent.ACTION_MOVE &&
                            Y > Profile.getPaddingTop() &&
                            Y < Profile.getPaddingTop() + (67*fYunit)) {
                        Profile.setPadding(0,(int)(Y - fDistBetweenProfileAndTouch), 0, 0);
                        return true;
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        if (Profile.getPaddingTop() > -fProfileDownSeperator && !bProfileGoingDown) {
                            bProfileTop = new Burrito(Profile.getPaddingTop(),0,250,Interpolator.sin);
                            bProfileGoingDown = true;
                        } else if (Profile.getPaddingTop() < -fProfileUpSeperator){
                            bProfileTop = new Burrito(-Profile.getPaddingTop(),fProfileTopPosition,250,Interpolator.sin);
                            bProfileGoingDown = false;
                        } else if (Profile.getPaddingTop() > -fProfileUpSeperator) {
                            bProfileTop = new Burrito(Profile.getPaddingTop(),0,250,Interpolator.sin);
                            bProfileGoingDown = true;
                        }
                        return true;
                    }
                    return false;
                }
            });
        }

        public void LayoutChanged(int iNewHeight, int iNewWidth) {
            float fNewYunit = iNewHeight / 100;
            if (iNewHeight < 0.8*(100*fYunit)) bKeyboardUp = true;
            else bKeyboardUp = false;
            if (bKeyboardUp) m.HeightChanged(new Rect(0,(int)(20*fYunit),(int)(100*fXunit),iNewHeight),true);
            else m.HeightChanged(new Rect(0,(int)(13*fYunit),fWidth,fHeight),false);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            invalidate();
            return super.onTouchEvent(event);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //canvas.drawARGB(255,255,255,255);
            canvas.drawARGB(150 - (int) (
                    ((((Profile.getPaddingTop() < 0) ? -1 : 1) * Math.min(0,Math.max(Profile.getPaddingTop(), -fProfileTopPosition)))
                            / fProfileTopPosition)
                            * 150), 0, 0, 0);
            if (!bProfileTop.Animate()) {
                Profile.setPadding(0,(bProfileGoingDown?1:-1)*(int)bProfileTop.GetValue(),0,0);
                invalidate();
            }
        }
    }
}
