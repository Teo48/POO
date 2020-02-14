package strategies;

import strategies.AttackStrategies.KnightAttackStrategy;
import strategies.AttackStrategies.PyromancerAttackStrategy;
import strategies.AttackStrategies.RogueAttackStrategy;
import strategies.AttackStrategies.WizardAttackStrategy;
import strategies.DefensiveStrategies.KnightDefensiveStrategy;
import strategies.DefensiveStrategies.PyromancerDefensiveStrategy;
import strategies.DefensiveStrategies.RogueDefensiveStrategy;
import strategies.DefensiveStrategies.WizardDefensiveStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that implements a factory for strategies.
 * */
public abstract class HeroStrategyFactory {
    private static Map<String, Strategy> heroStrategies = new HashMap<>();

    static {
        heroStrategies.put("PyromancerAttackStrategy", new PyromancerAttackStrategy());
        heroStrategies.put("PyromancerDefensiveStrategy", new PyromancerDefensiveStrategy());
        heroStrategies.put("KnightAttackStrategy", new KnightAttackStrategy());
        heroStrategies.put("KnightDefensiveStrategy", new KnightDefensiveStrategy());
        heroStrategies.put("RogueAttackStrategy", new RogueAttackStrategy());
        heroStrategies.put("RogueDefensiveStrategy", new RogueDefensiveStrategy());
        heroStrategies.put("WizardAttackStrategy", new WizardAttackStrategy());
        heroStrategies.put("WizardDefensiveStrategy", new WizardDefensiveStrategy());
    }

    public static Strategy getInstance(final String str) {
        return heroStrategies.get(str);
    }
}
