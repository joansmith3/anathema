package net.sf.anathema.character.sidereal.template;

import net.sf.anathema.character.generic.impl.magic.MartialArtsUtilities;
import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.character.generic.magic.charms.MartialArtsLevel;
import net.sf.anathema.character.generic.template.magic.IMartialArtsRules;
import net.sf.anathema.character.generic.template.magic.MartialArtsCharmConfiguration;

public class RoninMartialArtsRules implements IMartialArtsRules {

  @Override
  public void setHighLevelAtCreation(boolean highLevelAtCreation) {
  }

  @Override
  public MartialArtsLevel getStandardLevel() {
    return MartialArtsLevel.Sidereal;
  }

  @Override
  public boolean isCharmAllowed(ICharm martialArtsCharm, MartialArtsCharmConfiguration charmConfiguration,
                                boolean isExperienced) {
    return isExperienced || MartialArtsUtilities.getLevel(martialArtsCharm) != MartialArtsLevel.Sidereal;
  }
}