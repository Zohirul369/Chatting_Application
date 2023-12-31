// Generated by view binder compiler. Do not edit!
package com.example.chatting_application.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.chatting_application.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySingInBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView appIcon;

  @NonNull
  public final TextView clickSingUp;

  @NonNull
  public final Button facebookButton;

  @NonNull
  public final Button googleButton;

  @NonNull
  public final Button singInButton;

  @NonNull
  public final TextView singInWithPhone;

  @NonNull
  public final EditText userEmail;

  @NonNull
  public final EditText userPassword;

  private ActivitySingInBinding(@NonNull LinearLayout rootView, @NonNull ImageView appIcon,
      @NonNull TextView clickSingUp, @NonNull Button facebookButton, @NonNull Button googleButton,
      @NonNull Button singInButton, @NonNull TextView singInWithPhone, @NonNull EditText userEmail,
      @NonNull EditText userPassword) {
    this.rootView = rootView;
    this.appIcon = appIcon;
    this.clickSingUp = clickSingUp;
    this.facebookButton = facebookButton;
    this.googleButton = googleButton;
    this.singInButton = singInButton;
    this.singInWithPhone = singInWithPhone;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySingInBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySingInBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sing_in, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySingInBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_icon;
      ImageView appIcon = ViewBindings.findChildViewById(rootView, id);
      if (appIcon == null) {
        break missingId;
      }

      id = R.id.click_sing_up;
      TextView clickSingUp = ViewBindings.findChildViewById(rootView, id);
      if (clickSingUp == null) {
        break missingId;
      }

      id = R.id.facebook_button;
      Button facebookButton = ViewBindings.findChildViewById(rootView, id);
      if (facebookButton == null) {
        break missingId;
      }

      id = R.id.google_button;
      Button googleButton = ViewBindings.findChildViewById(rootView, id);
      if (googleButton == null) {
        break missingId;
      }

      id = R.id.singIn_button;
      Button singInButton = ViewBindings.findChildViewById(rootView, id);
      if (singInButton == null) {
        break missingId;
      }

      id = R.id.singIn_with_phone;
      TextView singInWithPhone = ViewBindings.findChildViewById(rootView, id);
      if (singInWithPhone == null) {
        break missingId;
      }

      id = R.id.user_email;
      EditText userEmail = ViewBindings.findChildViewById(rootView, id);
      if (userEmail == null) {
        break missingId;
      }

      id = R.id.user_password;
      EditText userPassword = ViewBindings.findChildViewById(rootView, id);
      if (userPassword == null) {
        break missingId;
      }

      return new ActivitySingInBinding((LinearLayout) rootView, appIcon, clickSingUp,
          facebookButton, googleButton, singInButton, singInWithPhone, userEmail, userPassword);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
