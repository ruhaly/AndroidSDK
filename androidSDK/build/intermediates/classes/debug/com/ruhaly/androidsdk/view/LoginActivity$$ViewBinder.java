// Generated code from Butter Knife. Do not modify!
package com.ruhaly.androidsdk.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.ruhaly.androidsdk.view.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427434, "field 'etName'");
    target.etName = finder.castView(view, 2131427434, "field 'etName'");
    view = finder.findRequiredView(source, 2131427435, "field 'etPwd'");
    target.etPwd = finder.castView(view, 2131427435, "field 'etPwd'");
    view = finder.findRequiredView(source, 2131427436, "method 'btnLoginClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.btnLoginClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.etName = null;
    target.etPwd = null;
  }
}
