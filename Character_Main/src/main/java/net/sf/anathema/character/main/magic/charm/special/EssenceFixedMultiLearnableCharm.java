package net.sf.anathema.character.main.magic.charm.special;

import net.sf.anathema.character.main.traits.EssenceTemplate;
import net.sf.anathema.character.main.traits.types.OtherTraitType;

public class EssenceFixedMultiLearnableCharm extends TraitDependentMultiLearnableCharm {

  public EssenceFixedMultiLearnableCharm(String charmId) {
    super(charmId, EssenceTemplate.SYSTEM_ESSENCE_MAX, OtherTraitType.Essence);
  }

  @Override
  public int getMinimumLearnCount(LearnRangeContext learnRangeContext) {
    return getMaximumLearnCount(learnRangeContext);
  }
}