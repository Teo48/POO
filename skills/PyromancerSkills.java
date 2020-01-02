package skills;

import players.Hero;
import players.Knight;
import players.Pyromancer;
import players.Wizard;
import players.Rogue;
import skills.PyromancerSkillsConstants.FireblastConstants;
import skills.PyromancerSkillsConstants.IgniteConstants;
import skills.PyromancerSkillsConstants.PlayersModifiers;
import utils.LandModifiers;
import utils.LandType;
import utils.Map;

import java.util.ArrayList;

public final class PyromancerSkills implements SkillsVisitor {
    private int level;
    private Pyromancer hero;

    /**
     * Constructor.
     * @param hero -> A pyromancer.
     * */
    public PyromancerSkills(final Pyromancer hero) {
        this.hero = hero;
        this.level = hero.getLevel();
    }


    /**
     * Method used to determine the damage caused by Fireblast and Ignite(including the passive
     * damage from ignite).
     * @return ArrayList<Float> -> Basic damage from Fireblast and Ignite(including
     * passive damage from ignite).
     * */
    private ArrayList<Float> getSpellDamage() {
        ArrayList<Float> spells = new ArrayList<>();
        float fireBlastActiveDamage = FireblastConstants.INIT_FB_DAMAGE.getNumber();
        fireBlastActiveDamage += this.level * FireblastConstants.FB_MODIFIER.getNumber();

        float igniteActiveDamage = IgniteConstants.INIT_IGNITE_DAMAGE.getNumber();
        igniteActiveDamage += this.level * IgniteConstants.IGNITE_DAMAGE_MODIFIER.getNumber();

        float ignitePassiveDamage = IgniteConstants.INIT_IGNITE_PASSIVE.getNumber();
        ignitePassiveDamage += this.level * IgniteConstants.IGNITE_PASSIVE_MODIFIER.getNumber();

        spells.add(fireBlastActiveDamage);
        spells.add(igniteActiveDamage);
        spells.add(ignitePassiveDamage);

        return spells;
    }

    /**
     * Method used to apply the active and passive damage.
     * @param player -> Current player.
     * @param activeDamageValue
     * @param passiveDamageValue
     * @param passiveCounter
     * */
    private void setSpellsDamage(final Hero player, final float activeDamageValue,
                                 final float passiveDamageValue, final int passiveCounter) {
        int activeDamage = Math.round(activeDamageValue);
        int passiveDamage = Math.round(passiveDamageValue);
        player.getActiveDamage(activeDamage);
        player.setPassiveDamage(passiveCounter, passiveDamage);
    }

    /**
     * Method used to amplify the damage of Fireblast and Ignite.
     * @param playerModifier
     * @return ArrayList<Integer> -> Spells' damage after applying the modifier.
     * */
    private ArrayList<Integer> getSpellModifier(final float playerModifier) {
        ArrayList<Float> spells = getSpellDamage();
        spells.set(0, spells.get(0) * playerModifier);
        spells.set(1, spells.get(1) * playerModifier);
        spells.set(2, spells.get(2) * playerModifier);

        ArrayList<Integer> modifiedSpells = new ArrayList<>();
        modifiedSpells.add(Math.round(spells.get(0) + spells.get(1)));
        modifiedSpells.add(Math.round(spells.get(2)));

        return modifiedSpells;
    }

    /**
     * Method used to amplify the damage of Fireblast and Ignite if Pyromancer
     * is on a VOLCANIC land.
     * @param map
     * @param player
     * @param spells
     * @return ArrayList<Integer> -> Spells' damage after applying the modifier.
     * */
    private ArrayList<Integer> applyLandModifier(final Map map, final Hero player,
                                                 final ArrayList<Integer> spells) {
        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.VOLCANIC) {
            spells.set(0, Math.round(spells.get(0)
                    * LandModifiers.PYRO_LAND_MODIFIER.getNumber()));
            spells.set(1, Math.round(spells.get(1)
                    * LandModifiers.PYRO_LAND_MODIFIER.getNumber()));
        }

        return spells;
    }

    /**
     * Visit method for a Pyromancer.
     * We get the total damage and apply it to the enemy.
     * @param player
     * */
    public void visit(final Pyromancer player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.PYRO_MODIFIER
                .getNumber(hero.getAngelModifier()));
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1),
                IgniteConstants.PASSIVE_COUNTER.getNumber());
    }
    /**
     * Visit method for a Knight.
     * We get the total damage and apply it to the enemy.
     * Since Pyromancer has a special interaction with Knight,
     * it has to apply the land modifiers first.
     * @param player
     * */
    public void visit(final Knight player) {
        Map map = Map.getInstance();
        float fireBlastActiveDamage = FireblastConstants.INIT_FB_DAMAGE.getNumber();
        fireBlastActiveDamage += this.level * FireblastConstants.FB_MODIFIER.getNumber();

        float igniteActiveDamage = IgniteConstants.INIT_IGNITE_DAMAGE.getNumber();
        igniteActiveDamage += this.level * IgniteConstants.IGNITE_DAMAGE_MODIFIER.getNumber();

        float ignitePassiveDamage = IgniteConstants.INIT_IGNITE_PASSIVE.getNumber();
        ignitePassiveDamage += this.level * IgniteConstants.IGNITE_PASSIVE_MODIFIER.getNumber();

        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.VOLCANIC) {
            fireBlastActiveDamage *=  LandModifiers.PYRO_LAND_MODIFIER.getNumber();
            igniteActiveDamage *=  LandModifiers.PYRO_LAND_MODIFIER.getNumber();
            ignitePassiveDamage *= LandModifiers.PYRO_LAND_MODIFIER.getNumber();
        }

        fireBlastActiveDamage = Math.round(fireBlastActiveDamage);
        igniteActiveDamage = Math.round(igniteActiveDamage);
        ignitePassiveDamage = Math.round(ignitePassiveDamage);

        fireBlastActiveDamage *= PlayersModifiers.KNIGHT_MODIFIER
                .getNumber(hero.getAngelModifier());
        igniteActiveDamage *= PlayersModifiers.KNIGHT_MODIFIER.getNumber(hero.getAngelModifier());
        ignitePassiveDamage *= PlayersModifiers.KNIGHT_MODIFIER.getNumber(hero.getAngelModifier());

        player.getActiveDamage(Math.round(fireBlastActiveDamage) + Math.round(igniteActiveDamage));
        player.setPassiveDamage(IgniteConstants.PASSIVE_COUNTER.getNumber(),
                Math.round(ignitePassiveDamage));
    }

    /**
     * Visit method for a Wizard.
     * We get the total damage and apply it to the enemy.
     * @param player
     * */
    public void visit(final Wizard player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.WIZARD_MODIFIER
                .getNumber(hero.getAngelModifier()));
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1),
                IgniteConstants.PASSIVE_COUNTER.getNumber());
    }

    /**
     * Visit method for a Rogue.
     * We get the total damage and apply it to the enemy.
     * @param player
     * */
    public void visit(final Rogue player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.ROGUE_MODIFIER
                .getNumber(hero.getAngelModifier()));
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1),
                IgniteConstants.PASSIVE_COUNTER.getNumber());
    }
}
