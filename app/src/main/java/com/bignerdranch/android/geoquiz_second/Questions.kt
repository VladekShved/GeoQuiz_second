package com.bignerdranch.android.geoquiz_second

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int,
                    val answer: Boolean,
                    var answered: Boolean = false)
//<LinearLayout
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:orientation="horizontal"
//android:layout_gravity="center_vertical|center_horizontal">
//<Button
//android:id="@+id/false_button"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="@string/false_button" />
//<Button
//android:id="@+id/true_button"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="@string/true_button" />
//</LinearLayout>
//<Button
//android:id="@+id/next_button"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_gravity="bottom|right"
//android:text="@string/next_button"
//android:drawableEnd="@drawable/arrow_right"
//android:drawablePadding="4dp"/>
//<Button
//android:id="@+id/back_button"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_gravity="bottom|left"
//android:drawableLeft="@drawable/arrow_left"
//android:text="@string/back_button"
//android:drawablePadding="4dp"/>