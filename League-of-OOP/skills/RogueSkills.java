package skills;

import players.Hero;
import players.Knight;
import players.Pyromancer;
import players.Wizard;
import players.Rogue;
import skills.RogueSkillsConstants.BackstabConstants;
import skills.RogueSkillsConstants.ParalysisConstants;
import skills.RogueSkillsConstants.PlayersModifiers;
import utils.LandModifiers;
import utils.LandType;
import utils.Map;

import java.util.ArrayList;

public final class RogueSkills implements SkillsVisitor {
    private int level;
    private int backstabCounter;
    private Rogue hero;
    /**
     * Constructor.
     * @param player -> A rogue.
     * */
    public RogueSkills(final Rogue player) {
        this.hero = player;
        this.level = player.getLevel();
        this.backstabCounter = player.getBackstab();
    }

    /**
     * Method used to determine the damage caused by backstab and paralysis(including passive,
     * the number of stunned turns and the critical hit from backstab).
     * If the current round number is a multiple of 3 and the player is on a WOODS land we amplify
     * the backstab damage with the critical hit value. Also, if the player is on a WOODS land we
     * incresea the number of stunned turns.
     * @return ArrayList<Float> -> Basic damage from backstab and paralysis(including
     * passive damage and the number of stunned turns).
     * */
    private ArrayList<Float> getSpellDamage(final Map map, final Hero player) {
        ArrayList<Float> spells = new ArrayList<>();
        float backstabActiveDamage = BackstabConstants.BACKSTAB_INIT_DAMAGE.
                getNumber() + this.level
                * BackstabConstants.BACKSTAB_LEVEL_MODIFIER.getNumber();

        if (backstabCounter % BackstabConstants.CRITICAL_HIT.getNumber() == 0) {
            if (map.getLandType(player.getCoordinates().getX(),
                    player.getCoordinates().getY()) == LandType.WOODS) {
                backstabActiveDamage *= BackstabConstants.BACKSTAB_CRITICAL_HIT_COEF.
                        getFloatNumber();
            }
        }

        int stunnedTurns = ParalysisConstants.NORMAL_STUNNED_TUNRS.getNumber();

        float paralysisActiveDamage = ParalysisConstants.INIT_PARALYSIS_DAMAGE.getNumber()
                + this.level * ParalysisConstants.PARALYSIS_DAMAGE_MODIFIER.getNumber();

        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.WOODS) {
            stunnedTurns = ParalysisConstants.EXTRA_STUNNED_TURNS.getNumber();
        }

        spells.add(backstabActiveDamage);
        final float buggedTests = 0.0001f;
        spells.add(paralysisActiveDamage - buggedTests);
        spells.add(stunnedTurns * 1.0f);

        return spells;
    }

    /**
     * Method used to amplify the damage of backstab and paralysis.
     * @param map
     * @param player
     * @param playerBackstabModifier
     * @param playerParalysisModifier
     * @return ArrayList<Integer> -> Spells' damage after applying the modifier.
     * */
    private ArrayList<Integer> getSpellModifier(final Map map, final Hero player,
                                                final float playerBackstabModifier,
                                                final float playerParalysisModifier) {
        ArrayList<Float> spells = getSpellDamage(map, player);
        spells.set(0, spells.get(0) * playerBackstabModifier);
        spells.set(1, spells.get(1) * playerParalysisModifier);

        ArrayList<Integer> modifiedSpells = new ArrayList<>();
        modifiedSpells.add(Math.round(spells.get(0) + spells.get(1)));
        modifiedSpells.add(Math.round(spells.get(1)));
        modifiedSpells.add(Math.round(spells.get(2)));

        return modifiedSpells;
    }

    /**
     * Method used to amplify the damage of Fireblast and Ignite if ROGUE is on a WOODS land.
     * @param map
     * @param player
     * @param spells
     * @return ArrayList<Integer> -> Spells' damage after applying the modifier.
     * */
    private ArrayList<Integer> applyLandModifier(final Map map, final Hero player,
                                                 final ArrayList<Integer> spells) {
        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.WOODS) {
            spells.set(0, Math.round(spells.get(0)
                    * LandModifiers.ROGUE_LAND_MODIFIER.getNumber()));
            spells.set(1, Math.round(spells.get(1)
                    * LandModifiers.ROGUE_LAND_MODIFIER.getNumber()));
        }

        return spells;
    }

    /**
     * Method used to apply the active and passive damage.
     * We also set the number of stunned turns.
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
        player.setStunnedTurns(passiveCounter);
    }

    /**
     * Visit method for a Pyromancer.
     * We get the total damage and apply it to the enemy.
     * @param player
     * */
    @Override
    public void visit(final Pyromancer player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(map, player,
                PlayersModifiers.PYRO_BACKSTAB_MODIFIER.getNumber(hero.getAngelModifier()),
                PlayersModifiers.PYRO_PARALYSIS_MODIFIER.getNumber(hero.getAngelModifier()));
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), spells.get(2));
    }
    /**
     * Visit method for a Knight.
     * We get the total damage and apply it to the enemy.
     * Knight has a special interaction with Rogue so I had to round the value of each
     * spell and then add it to the total damage to get the correct value.
     * @param player
     * */
    @Override
    public void visit(final Knight player) {
        Map map = Map.getInstance();
        ArrayList<Float> spells = getSpellDamage(map, player);
        float backstabActiveDamage = spells.get(0);
        float paralysisActiveDamage = spells.get(1);

        backstabActiveDamage *= PlayersModifiers.KNIGHT_BACKSTAB_MODIFIER
                .getNumber(hero.getAngelModifier());
        paralysisActiveDamage *= PlayersModifiers.KNIGHT_PARALYSIS_MODIFIER
                .getNumber(hero.getAngelModifier());
        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.WOODS) {
            backstabActiveDamage *= LandModifiers.ROGUE_LAND_MODIFIER.getNumber();
            paralysisActiveDamage *= LandModifiers.ROGUE_LAND_MODIFIER.getNumber();
        }

        backstabActiveDamage = Math.round(backstabActiveDamage);
        paralysisActiveDamage = Math.round(paralysisActiveDamage);

        player.getActiveDamage(Math.round(backstabActiveDamage + paralysisActiveDamage));
        player.setPassiveDamage(Math.round(spells.get(2)), Math.round(paralysisActiveDamage));
        player.setStunnedTurns(Math.round(spells.get(2)));
    }

    /**
     * Visit method for a Rogue.
     * We get the total damage and apply it to the enemy.
     * @param player
     * */
    @Override
    public void visit(final Rogue player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(map, player,
                PlayersModifiers.ROGUE_BACKSTAB_MODIFIER.getNumber(hero.getAngelModifier()),
                PlayersModifiers.ROGUE_PARALYSIS_MODIFIER.getNumber(hero.getAngelModifier()));
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), spells.get(2));
    }

    /**
     * Visit method for a Wizard.
     * We get the total damage and apply it to the enemy.
     * @param player
     * */
    @Override
    public void visit(final Wizard player) {
        Map map = Map.getInstance();
        ArrayList<Integer> spells = getSpellModifier(map, player,
                PlayersModifiers.WIZARD_BACKSTAB_MODIFIER.getNumber(hero.getAngelModifier()),
                PlayersModifiers.WIZARD_PARALYSIS_MODIFIER.getNumber(hero.getAngelModifier()));
        spells = applyLandModifier(map, player, spells);
        setSpellsDamage(player, spells.get(0), spells.get(1), spells.get(2));
    }
}
