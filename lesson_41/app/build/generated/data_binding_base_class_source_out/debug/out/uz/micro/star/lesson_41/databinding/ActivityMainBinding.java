// Generated by view binder compiler. Do not edit!
package uz.micro.star.lesson_41.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import uz.micro.star.lesson_41.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  private ActivityMainBinding(@NonNull FrameLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ActivityMainBinding((FrameLayout) rootView);
  }
}
