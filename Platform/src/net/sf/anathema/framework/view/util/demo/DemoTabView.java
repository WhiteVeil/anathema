package net.sf.anathema.framework.view.util.demo;

import javax.swing.JComponent;
import javax.swing.JLabel;

import net.sf.anathema.framework.presenter.view.ISimpleTabView;

public final class DemoTabView implements ISimpleTabView {
  private JLabel content = new JLabel("Content"); //$NON-NLS-1$
  private final boolean needsScrollbar;

  public DemoTabView(boolean needsScrollbar) {
    this.needsScrollbar = needsScrollbar;
  }

  public boolean needsScrollbar() {
    return needsScrollbar;
  }

  public JComponent getComponent() {
    return content;
  }
}