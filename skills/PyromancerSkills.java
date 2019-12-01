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
    private Hero hero;

    /**
     * Constructor.
     * @param hero -> A pyromancer.
     * */
    public PyromancerSkills(final Hero hero) {
        this.hero = hero;
        this.level = hero.getLevel();
    }


    /**
     * @return ArrayList<Float> -> Basic damage from fireblast and ignite(including
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
     * Apply damage to a player.
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
     * @param player
     * */
    public void visit(final Pyromancer player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.PYRO_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1),
                IgniteConstants.PASSIVE_COUNTER.getNumber());
    }
    /**
     * Visit method for a Knight.
     * @param player
     * */
    public void visit(final Knight player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.KNIGHT_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1),
                IgniteConstants.PASSIVE_COUNTER.getNumber());
    }

    /**
     * Visit method for a Wizard.
     * @param player
     * */
    public void visit(final Wizard player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.WIZARD_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1),
                IgniteConstants.PASSIVE_COUNTER.getNumber());
    }

    /**
     * Visit method for a Rogue.
     * @param player
     * */
    public void visit(final Rogue player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.ROGUE_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1),
                IgniteConstants.PASSIVE_COUNTER.getNumber());
    }
}
