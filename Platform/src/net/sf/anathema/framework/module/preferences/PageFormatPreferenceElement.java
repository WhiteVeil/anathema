package net.sf.anathema.framework.module.preferences;

import net.disy.commons.swing.layout.grid.IDialogComponent;
import net.sf.anathema.framework.presenter.action.preferences.IPreferencesElement;
import net.sf.anathema.framework.reporting.pdf.PageSize;
import net.sf.anathema.framework.view.EnumSelectCellRenderer;
import net.sf.anathema.initialization.PreferenceElement;
import net.sf.anathema.lib.gui.gridlayout.IGridDialogPanel;
import net.sf.anathema.lib.resources.IResources;
import net.sf.anathema.lib.util.Identified;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static net.sf.anathema.framework.presenter.action.preferences.IAnathemaPreferencesConstants.PAGE_FORMAT_PREFERENCE;
import static net.sf.anathema.framework.reporting.pdf.PageSize.Letter;

@PreferenceElement
public class PageFormatPreferenceElement implements IPreferencesElement {

  private PageSize pageFormat = loadPreference();

  private boolean dirty;
  private LabelledPreferenceComboBox<PageSize> box;

  @Override
  public void addComponent(IGridDialogPanel panel, IResources resources) {
    panel.add(getComponent(resources));
  }

  private IDialogComponent getComponent(IResources resources) {
    String labelText = resources.getString("AnathemaReporting.Tools.Preferences.PageFormat") + ":"; //$NON-NLS-1$ //$NON-NLS-2$
    EnumSelectCellRenderer renderer = new EnumSelectCellRenderer("PageSize.", resources); //$NON-NLS-1$
    box = new LabelledPreferenceComboBox<PageSize>(labelText, renderer, PageSize.values());
    box.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        PageSize selectedFormat = box.getSelectedItem();
        if (selectedFormat != pageFormat) {
          pageFormat = selectedFormat;
          dirty = true;
        }
      }
    });
    box.setSelectedItem(pageFormat);
    return box.getDialogComponent();
  }

  @Override
  public void savePreferences() {
    SYSTEM_PREFERENCES.put(PAGE_FORMAT_PREFERENCE, pageFormat.name());
  }

  public static PageSize loadPreference() {
    return PageSize.valueOf(SYSTEM_PREFERENCES.get(PAGE_FORMAT_PREFERENCE, Letter.name()));
  }

  @Override
  public void reset() {
    pageFormat = loadPreference();
    box.setSelectedItem(pageFormat);
    dirty = false;
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public boolean isDirty() {
    return dirty;
  }

  @Override
  public Identified getCategory() {
      return SYSTEM_CATEGORY;
  }
}
