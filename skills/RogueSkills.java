package skills;

import players.*;
import skills.RogueSkillsConstants.BackstabConstants;
import skills.RogueSkillsConstants.ParalysisConstants;
import skills.RogueSkillsConstants.PlayersModifiers;
import utils.LandModifiers;
import utils.LandType;
import utils.Map;

import java.util.ArrayList;

public class RogueSkills implements SkillsVisitor {
    private int level;
    private int backstabCounter;
    private Hero hero;

    public RogueSkills(Hero player) {
        this.hero = player;
        this.level = player.getLevel();
        this.backstabCounter = player.getBackstab();
    }

    private ArrayList<Float> getSpellDamage(Map map, Hero player) {
        ArrayList<Float> spells = new ArrayList<>();
        float backstabActiveDamage = BackstabConstants.BACKSTAB_INIT_DAMAGE.getNumber() + this.level
                * BackstabConstants.BACKSTAB_LEVEL_MODIFIER.getNumber();

        if (backstabCounter % BackstabConstants.CRITICAL_HIT.getNumber() == 0) {
            if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY()) ==
                    LandType.WOODS) {
                backstabActiveDamage *= BackstabConstants.BACKSTAB_CRITICAL_HIT_COEF.getFloatNumber();
            }
        }

        int stunnedTurns = ParalysisConstants.NORMAL_STUNNED_TUNRS.getNumber();

        float paralysisActiveDamage = ParalysisConstants.INIT_PARALYSIS_DAMAGE.getNumber() + this.level *
                ParalysisConstants.PARALYSIS_DAMAGE_MODIFIER.getNumber();

        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY()) ==
                LandType.WOODS) {
            stunnedTurns = ParalysisConstants.EXTRA_STUNNED_TURNS.getNumber();
        }

        spells.add(backstabActiveDamage);
        spells.add(paralysisActiveDamage);
        spells.add(stunnedTurns * 1.0f);

        return spells;
    }

    private ArrayList<Integer> getSpellModifier(Map map, Hero player,
                                                float playerBackstabModifier, float playerParalysisModifier) {
        ArrayList<Float> spells = getSpellDamage(map, player);
        spells.set(0, spells.get(0) * playerBackstabModifier);
        spells.set(1, spells.get(1) * playerParalysisModifier);

        ArrayList<Integer> modifiedSpells = new ArrayList<>();
        modifiedSpells.add(Math.round(spells.get(0) + spells.get(1)));
        modifiedSpells.add(Math.round(spells.get(1)));
        modifiedSpells.add(Math.round(spells.get(2)));

        return modifiedSpells;
    }

    private ArrayList<Integer> applyLandModifier(Map map, Hero player, ArrayList<Integer> spells) {
        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.WOODS) {
            spells.set(0, Math.round(spells.get(0) * LandModifiers.ROGUE_LAND_MODIFIER.getNumber()));
            spells.set(1, Math.round(spells.get(1) * LandModifiers.ROGUE_LAND_MODIFIER.getNumber()));
        }

        return spells;
    }

    private void setSpellsDamage(Hero player, float activeDamageValue, float passiveDamageValue, int passiveCounter) {
        int activeDamage = Math.round(activeDamageValue);
        int passiveDamage = Math.round(passiveDamageValue);
        player.getActiveDamage(activeDamage);
        player.setPassiveDamage(passiveCounter, passiveDamage);
        player.setStunnedTurns(passiveCounter);
    }


    @Override
    public void visit(Pyromancer player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(map, player, PlayersModifiers.PYRO_BACKSTAB_MODIFIER.getNumber(),
                PlayersModifiers.PYRO_PARALYSIS_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), spells.get(2));
    }

    @Override
    public void visit(Knight player) {
        Map map = Map.getInstance();
        ArrayList<Float> spells = getSpellDamage(map, player);
        float backstabActiveDamage = spells.get(0);
        float paralysisActiveDamage = spells.get(1);

        backstabActiveDamage *= PlayersModifiers.KNIGHT_BACKSTAB_MODIFIER.getNumber();
        paralysisActiveDamage *= PlayersModifiers.KNIGHT_PARALYSIS_MODIFIER.getNumber();
        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY()) ==
                LandType.WOODS) {
            backstabActiveDamage *= LandModifiers.ROGUE_LAND_MODIFIER.getNumber();
            paralysisActiveDamage *= LandModifiers.ROGUE_LAND_MODIFIER.getNumber();
        }

        backstabActiveDamage = Math.round(backstabActiveDamage);
        paralysisActiveDamage = Math.round(paralysisActiveDamage);

        player.getActiveDamage(Math.round(backstabActiveDamage + paralysisActiveDamage));
        player.setPassiveDamage(Math.round(spells.get(2)), Math.round(paralysisActiveDamage));
        player.setStunnedTurns(Math.round(spells.get(2)));
    }

    @Override
    public void visit(Rogue player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(map, player, PlayersModifiers.ROGUE_BACKSTAB_MODIFIER.getNumber(),
                PlayersModifiers.ROGUE_PARALYSIS_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), spells.get(2));
    }

    @Override
    public void visit(Wizard player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(map, player, PlayersModifiers.WIZARD_BACKSTAB_MODIFIER.getNumber(),
                PlayersModifiers.WIZARD_PARALYSIS_MODIFIER.getNumber());
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), spells.get(2));
    }
}
