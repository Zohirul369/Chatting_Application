// Generated by view binder compiler. Do not edit!
package com.example.chatting_application.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.chatting_application.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ShowUsersBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView lastMassage;

  @NonNull
  public final CircleImageView profilePic;

  @NonNull
  public final TextView userNameList;

  private ShowUsersBinding(@NonNull LinearLayout rootView, @NonNull TextView lastMassage,
      @NonNull CircleImageView profilePic, @NonNull TextView userNameList) {
    this.rootView = rootView;
    this.lastMassage = lastMassage;
    this.profilePic = profilePic;
    this.userNameList = userNameList;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ShowUsersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ShowUsersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.show_users, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ShowUsersBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.last_massage;
      TextView lastMassage = ViewBindings.findChildViewById(rootView, id);
      if (lastMassage == null) {
        break missingId;
      }

      id = R.id.profile_pic;
      CircleImageView profilePic = ViewBindings.findChildViewById(rootView, id);
      if (profilePic == null) {
        break missingId;
      }

      id = R.id.user_name_list;
      TextView userNameList = ViewBindings.findChildViewById(rootView, id);
      if (userNameList == null) {
        break missingId;
      }

      return new ShowUsersBinding((LinearLayout) rootView, lastMassage, profilePic, userNameList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
