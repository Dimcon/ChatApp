package com.cybermelon.chatappmain;

/**
 * Created by Daimon on 6/18/2015.
 */
public class Burrito {
    private float Start, End, Position, Amount;
    private boolean bReachedEnd = false;
    private Interpolator Interp = Interpolator.sin;
    boolean bNegative = false;

/**
 *	Time-value animation class (Time in milliseconds assuming Animate()
 * 	is called every 0.016s (1s/60frames))
 */


/**
*   if working backwards:
 *   start = 200
 *   end = 100
 *   position = 175
 *
 *   Switch around for calculations, use alternate interpolator
 *   end = 200
 *   start = 100
 *   position = 25
 *
 *   return end - position
 *
 *
* */

    Burrito(float Start, float End,float Timems) {
        this.Start = Start;
        this.End = End;
        this.Position = Start;
        this.Amount = (End - Start) / (Timems/8f);
        this.Interp = Interpolator.sin;
        if (Start > End) {
            bNegative = true;
            float tmp = this.Start;
            this.Start = this.End;
            this.End = tmp;
        }
    }
    Burrito(float Start, float End, float Timems,Interpolator interp) {
        this.Start = Start;
        this.End = End;
        this.Position = Start;
        this.Amount = (End - Start) / (Timems/8f);
        this.Interp = interp;
        if (Start > End) {
            bNegative = true;
            float tmp = this.Start;
            this.Start = this.End;
            this.End = tmp;
        }
    }
    Burrito(float Start, float End, float SkipTo, float Timems,Interpolator interp) {
        this.Start = Start;
        this.End = End;
        this.Position = SkipTo;
        this.Amount = (End - Start) / (Timems/8f);
        this.Interp = interp;
        if (Start > End) {
            bNegative = true;
            float tmp = this.Start;
            this.Start = this.End;
            this.End = tmp;
        }
    }

    public boolean Animate() {
        if (bReachedEnd) {
            return true;
        } else {
            Position += Amount;
        }
        return false;
    }

    public float GetValue() {
        if (bReachedEnd) {
            return End;
        } else {
            Position += Amount;
            //  Increment current position
            float fTmp = Position;
            float Percentage = ((fTmp - Start) / (End - Start));
            Percentage = Math.max(Percentage,0);
            if ((End - Start) == 0) {
                // No point to conitnue
                Percentage = 0;
                bReachedEnd = true;
            }
            if (!bNegative && Percentage >= (End - Amount - Start) / (End - Start)) {
                // if percentage is more than (100% - percentage of one amount)
                bReachedEnd = true;
                return End;
            } else if (bNegative && Percentage <= (Amount) / (Start - End)){
                bReachedEnd = true;
                return Start;
            }
            float fReturn = Interp.Interpolate(Percentage);
            //Return current percentage
            return Start + ((End - Start) * fReturn);
        }
    }
    /*  Fixed animations (Workingperfectly now)
    *   Added backwards functionality (bNegative)
    *   TODO Add different graphs for animation*/
}

enum Interpolator {
	/*
	*	Float value interpolator, input must be between 0.00 and 1.00
	*/
    sin, cosin, normal,accel,decel;

    public float Interpolate(float fPercent) {
        float angle = (float)(0.5f*Math.PI) * fPercent;
        switch (this) {
            case sin:decel:
                return (float)Math.sin(angle);
            case cosin:accel:
                return 1 - (float)Math.cos(angle);
            case normal:
                return fPercent;
        }
        return (float)Math.sin(angle);
    }
}
