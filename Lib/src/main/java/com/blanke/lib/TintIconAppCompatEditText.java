package com.blanke.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.View;

public class TintIconAppCompatEditText extends AppCompatEditText implements View.OnFocusChangeListener {
    private Drawable[] compoundDrawables;
    private int focusTintColor;
    private int unFocusTintColor;

    public TintIconAppCompatEditText(Context context) {
        super(context);
        init(context, null);
    }

    public TintIconAppCompatEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TintIconAppCompatEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TintIconAppCompatEditText);
        focusTintColor = a.getColor(R.styleable.TintIconAppCompatEditText_focusIconTintColor, Color.BLUE);
        unFocusTintColor = a.getColor(R.styleable.TintIconAppCompatEditText_unFocusIconTintColor, Color.BLACK);
        a.recycle();
        setOnFocusChangeListener(this);
        compoundDrawables = getCompoundDrawables();
        for (int i = 0; i < compoundDrawables.length; i++) {
            if (compoundDrawables[i] != null) {
                compoundDrawables[i] = DrawableCompat.wrap(compoundDrawables[i]);
            }
        }
        setTint(false);
    }

    private int getTintColor(boolean istint) {
        return istint ? focusTintColor : unFocusTintColor;
    }

    public void setTint(boolean istint) {
        for (int i = 0; i < compoundDrawables.length; i++) {
            if (compoundDrawables[i] != null) {
                DrawableCompat.setTint(compoundDrawables[i], getTintColor(istint));
            }
        }
        setCompoundDrawables(compoundDrawables[0], compoundDrawables[1],
                compoundDrawables[2], compoundDrawables[3]);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        setTint(hasFocus);
    }
}