package skills;

import players.Hero;
import players.Knight;
import players.Pyromancer;
import players.Wizard;
import players.Rogue;
import skills.KnightSkillsConstants.ExecuteConstants;
import skills.KnightSkillsConstants.PlayersModifiers;
import skills.KnightSkillsConstants.SlamConstants;
import skills.WizardSkillsConstants.DrainConstants;
import utils.LandModifiers;
import utils.LandType;
import utils.Map;

import java.util.ArrayList;

public class KnightSkills implements SkillsVisitor {
    private int level;
    private Hero hero;

    /**
     * Constructor.
     * @param hero -> A Knight.
     * */
    public KnightSkills(final Hero hero) {
        this.hero = hero;
        this.level = hero.getLevel();
    }

    /**
     * Method used to determine the hpLimit of the enemy.
     * @param player
     * @return float -> Player's hplimit for the execute spell.
     * */
    private float getHpLimit(final Hero player) {
        float hpLimit = ExecuteConstants.HP_MIN_LIMIT_COEF.getFloatNumber() * player.getMaxHp();

        if (ExecuteConstants.EXEC_MAX_DAMAGE_LEVEL.getNumber() > this.level) {
            hpLimit += ((float) this.level / DrainConstants.HUNDREAD.getNumber())
                    * player.getMaxHpLevelUp();

            return hpLimit;
        }

        return hpLimit + ExecuteConstants.HP_MAX_LIMIT_COEF.getFloatNumber() * player.getMaxHp();
    }

    /**
     * Method used to determine the basic damage caused by the execute and slam spells.
     * @return ArrayList<Float> -> Basic damage from execute and slam.
     * */
    private ArrayList<Float> getSpellsDamage() {
        ArrayList<Float> spells = new ArrayList<>();
        float executeDamage = ExecuteConstants.INIT_EXEC_DAMAGE.getNumber();
        executeDamage += this.level * ExecuteConstants.EXEC_LEVEL_MODIFIER.getNumber();

        float slamDamage = SlamConstants.INIT_SLAM_DAMAGE.getNumber();
        slamDamage += this.level * SlamConstants.SLAM_LEVEL_MODIFIER.getNumber();

        spells.add(executeDamage);
        spells.add(slamDamage);

        return spells;
    }

    /**
     * Method used to determine the total damage a Knight player is gonna deal.
     * If the Knight player is on a LAND cell we amplify the damage with the land modifier.
     * @param map
     * @param playerExecuteModifier
     * @param playerSlamModifier
     * @return int -> total damage dealt by the Knight player.
     * */
    private int getTotalDamage(final Map map, final float playerExecuteModifier,
                               final float playerSlamModifier) {
        ArrayList<Float> spells = getSpellsDamage();
        spells.set(0, spells.get(0) * playerExecuteModifier);
        spells.set(1, spells.get(1) * playerSlamModifier);

        float totalDamage = spells.get(0) + spells.get(1);
        if (map.getLandType(hero.getCoordinates().getX(), hero.getCoordinates().getY())
                == LandType.LAND) {
            totalDamage *= LandModifiers.KNIGHT_LAND_MODIFIER.getNumber();
        }

        return Math.round(totalDamage);
    }

    /**
     * Visit method for a Pyromancer. It also sets the number of stunned turns.
     * If player's hp is lower than the hpLimit then he is instantlly killed, otherwise
     * he takes the active damage.
     * @param player
     * */
    @Override
    public void visit(final Pyromancer player) {
        Map map = Map.getInstance();
        if (player.getHp() > 0 && (float) player.getHp() < getHpLimit(player)) {
            player.getActiveDamage(player.getHp());
        } else {
            player.getActiveDamage(getTotalDamage(map,
                    PlayersModifiers.PYRO_EXECUTE_MODIFIER.getNumber(),
                    PlayersModifiers.PYRO_SLAM_MODIFIER.getNumber()));
            player.setStunnedTurns(ExecuteConstants.STUN_SLAM_TURNS.getNumber());
        }
    }

    /**
     * Visit method for a Knight. It also sets the number of stunned turns.
     * If player's hp is lower than the hpLimit then he is instantlly killed, otherwise
     * he takes the active damage.
     * @param player
     * */
    @Override
    public void visit(final Knight player) {
        Map map = Map.getInstance();
        if (player.getHp() > 0 && (float) player.getHp() < getHpLimit(player)) {
            player.getActiveDamage(player.getHp());
        } else {
            player.getActiveDamage(getTotalDamage(map,
                    PlayersModifiers.KNIGHT_EXECUTE_MODIFIER.getNumber(),
                    PlayersModifiers.KNIGHT_SLAM_MODIFIER.getNumber()));
            player.setStunnedTurns(ExecuteConstants.STUN_SLAM_TURNS.getNumber());
        }
    }

    /**
     * Visit method for a Rogue. It also sets the number of stunned turns.
     * If player's hp is lower than the hpLimit then he is instantlly killed, otherwise
     * he takes the active damage.
     * @param player
     * */
    @Override
    public void visit(final Rogue player) {
        Map map = Map.getInstance();
        if (player.getHp() > 0 && (float) player.getHp() < getHpLimit(player)) {
            player.getActiveDamage(player.getHp());
        } else {
            player.getActiveDamage(getTotalDamage(map,
                    PlayersModifiers.ROGUE_EXECUTE_MODIFIER.getNumber(),
                    PlayersModifiers.ROGUE_SLAM_MODIFIER.getNumber()));
            player.setStunnedTurns(ExecuteConstants.STUN_SLAM_TURNS.getNumber());
        }
    }

    /**
     * Visit method for a Wizard. It also sets the number of stunned turns.
     * If player's hp is lower than the hpLimit then he is instantlly killed, otherwise
     * he takes the active damage.
     * @param player
     * */
    @Override
    public void visit(final Wizard player) {
        Map map = Map.getInstance();
        if (player.getHp() > 0 && (float) player.getHp() < getHpLimit(player)) {
            player.getActiveDamage(player.getHp());
        } else {
            player.getActiveDamage(getTotalDamage(map,
                    PlayersModifiers.WIZARD_EXECUTE_MODIFIER.getNumber(),
                    PlayersModifiers.WIZARD_SLAM_MODIFIER.getNumber()));
            player.setStunnedTurns(ExecuteConstants.STUN_SLAM_TURNS.getNumber());
        }
    }
}
