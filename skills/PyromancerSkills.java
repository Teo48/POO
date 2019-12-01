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

public class PyromancerSkills implements AttackVisitor {
    private int level;
    private Hero hero;

    public PyromancerSkills(Hero hero) {
        this.hero = hero;
        this.level = hero.getLevel();
    }

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

    private void setSpellsDamage(Hero player, float activeDamageValue, float passiveDamageValue, int passiveCounter) {
        int activeDamage = Math.round(activeDamageValue);
        int passiveDamage = Math.round(passiveDamageValue);
        player.getActiveDamage(activeDamage);
        player.setPassiveDamage(passiveCounter, passiveDamage);
    }

    private ArrayList<Integer> getSpellModifier(float playerModifier) {
        ArrayList<Float> spells = getSpellDamage();
        spells.set(0, spells.get(0) * playerModifier);
        spells.set(1, spells.get(1) * playerModifier);
        spells.set(2, spells.get(2) * playerModifier);

        ArrayList<Integer> modifiedSpells = new ArrayList<>();
        modifiedSpells.add(Math.round(spells.get(0) + spells.get(1)));
        modifiedSpells.add(Math.round(spells.get(2)));

        return modifiedSpells;
    }

    private ArrayList<Integer> applyLandModifier(Map map, Hero player, ArrayList<Integer> spells) {
        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.VOLCANIC) {
            spells.set(0, Math.round(spells.get(0) * LandModifiers.PYRO_LAND_MODIFIER.getNumber()));
            spells.set(1, Math.round(spells.get(1) * LandModifiers.PYRO_LAND_MODIFIER.getNumber()));
        }

        return spells;
    }

    public void visit(Pyromancer player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.PYRO_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), IgniteConstants.PASSIVE_COUNTER.getNumber());
    }

    public void visit(Knight player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.KNIGHT_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), IgniteConstants.PASSIVE_COUNTER.getNumber());
    }

    public void visit(Wizard player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.WIZARD_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), IgniteConstants.PASSIVE_COUNTER.getNumber());
    }

    public void visit(Rogue player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(PlayersModifiers.ROGUE_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), IgniteConstants.PASSIVE_COUNTER.getNumber());
    }
}
