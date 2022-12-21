// Generated by view binder compiler. Do not edit!
package com.example.gumbuddy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gumbuddy.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView_;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final BottomNavigationView bottomNavigationView;

  @NonNull
  public final FragmentContainerView navHostFragment;

  @NonNull
  public final ConstraintLayout rootView;

  @NonNull
  public final MaterialToolbar toolbar;

  @NonNull
  public final TextView tvToolbarTitle;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView_,
      @NonNull AppBarLayout appBarLayout, @NonNull BottomNavigationView bottomNavigationView,
      @NonNull FragmentContainerView navHostFragment, @NonNull ConstraintLayout rootView,
      @NonNull MaterialToolbar toolbar, @NonNull TextView tvToolbarTitle) {
    this.rootView_ = rootView_;
    this.appBarLayout = appBarLayout;
    this.bottomNavigationView = bottomNavigationView;
    this.navHostFragment = navHostFragment;
    this.rootView = rootView;
    this.toolbar = toolbar;
    this.tvToolbarTitle = tvToolbarTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView_;
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
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appBarLayout;
      AppBarLayout appBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.bottomNavigationView;
      BottomNavigationView bottomNavigationView = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigationView == null) {
        break missingId;
      }

      id = R.id.navHostFragment;
      FragmentContainerView navHostFragment = ViewBindings.findChildViewById(rootView, id);
      if (navHostFragment == null) {
        break missingId;
      }

      ConstraintLayout rootView_ = (ConstraintLayout) rootView;

      id = R.id.toolbar;
      MaterialToolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tvToolbarTitle;
      TextView tvToolbarTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvToolbarTitle == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, appBarLayout,
          bottomNavigationView, navHostFragment, rootView_, toolbar, tvToolbarTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
