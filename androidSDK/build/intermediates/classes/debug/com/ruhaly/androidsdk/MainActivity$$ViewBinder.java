// Generated code from Butter Knife. Do not modify!
package com.ruhaly.androidsdk;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.ruhaly.androidsdk.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427450, "field 'b'");
    target.b = finder.castView(view, 2131427450, "field 'b'");
    view = finder.findRequiredView(source, 2131427451, "field 'timeCountView' and method 'click'");
    target.timeCountView = finder.castView(view, 2131427451, "field 'timeCountView'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.click(p0);
        }
      });
    view = finder.findRequiredView(source, 2131427454, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131427454, "field 'recyclerView'");
  }

  @Override public void unbind(T target) {
    target.b = null;
    target.timeCountView = null;
    target.recyclerView = null;
  }
}
