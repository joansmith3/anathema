package net.sf.anathema.character.equipment.creation.model;

import net.sf.anathema.character.equipment.creation.presenter.IIntValueModel;
import net.sf.anathema.character.equipment.creation.presenter.IWeaponDamageModel;
import net.sf.anathema.character.equipment.creation.presenter.RangedIntValueModel;
import net.sf.anathema.hero.health.HealthType;
import net.sf.anathema.lib.control.ChangeListener;
import net.sf.anathema.lib.data.Range;
import org.jmock.example.announcer.Announcer;

public class WeaponDamageModel implements IWeaponDamageModel {

  private final Announcer<ChangeListener> changeControl = Announcer.to(ChangeListener.class);
  private final IIntValueModel damageModel;
  private final IIntValueModel minDamageModel;
  private HealthType healthType = HealthType.Lethal;

  public WeaponDamageModel() {
    damageModel = new RangedIntValueModel(new Range(0, Integer.MAX_VALUE), 0);
    minDamageModel = new RangedIntValueModel(new Range(0, Integer.MAX_VALUE), 1);
  }

  @Override
  public IIntValueModel getDamageModel() {
    return damageModel;
  }

  @Override
  public IIntValueModel getMinDamageModel() {
    return minDamageModel;
  }

  @Override
  public HealthType getHealthType() {
    return healthType;
  }

  @Override
  public void addHealthTypeChangeListener(ChangeListener listener) {
    changeControl.addListener(listener);
  }

  @Override
  public void setHealthType(HealthType healthType) {
    if (this.healthType == healthType) {
      return;
    }
    this.healthType = healthType;
    changeControl.announce().changeOccurred();
  }
}