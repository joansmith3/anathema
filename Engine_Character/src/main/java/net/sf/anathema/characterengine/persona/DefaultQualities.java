package net.sf.anathema.characterengine.persona;

import net.sf.anathema.characterengine.engine.Engine;
import net.sf.anathema.characterengine.quality.Quality;
import net.sf.anathema.characterengine.quality.QualityKey;
import net.sf.anathema.characterengine.quality.Type;

import java.util.HashMap;
import java.util.Map;

public class DefaultQualities implements Qualities {
  private final Map<QualityKey, Quality> qualityMap = new HashMap<QualityKey, Quality>();
  private final Engine engine;

  public DefaultQualities(Engine engine) {
    this.engine = engine;
  }

  @Override
  public void addQuality(final QualityKey qualityKey) {
    Quality quality = engine.createQuality(qualityKey);
    qualityMap.put(qualityKey, quality);
  }

  @Override
  public void doFor(QualityKey qualityKey, QualityClosure closure) {
    if (qualityMap.containsKey(qualityKey)) {
      Quality quality = qualityMap.get(qualityKey);
      closure.execute(quality);
    }
  }

  @Override
  public void doForEach(final Type type, final QualityClosure closure) {
    for (Map.Entry<QualityKey, Quality> entry : qualityMap.entrySet()) {
      Quality quality = entry.getValue();
      QualityKey key = entry.getKey();
      key.withTypeDo(new ExecuteQualityClosureIfTypeMatches(type, quality, closure));
    }
  }
}