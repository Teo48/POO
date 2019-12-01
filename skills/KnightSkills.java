package skills;

import players.*;
import skills.KnightSkillsConstants.ExecuteConstants;
import skills.KnightSkillsConstants.PlayersModifiers;
import skills.KnightSkillsConstants.SlamConstants;
import utils.LandModifiers;
import utils.LandType;
import utils.Map;

import java.util.ArrayList;

public class KnightSkills implements SkillsVisitor {
    private int level;
    private Hero hero;

    public KnightSkills(Hero hero) {
        this.hero = hero;
        this.level = hero.getLevel();
    }

    private float getHpLimit(Hero player) {
        float hpLimit = ExecuteConstants.HP_MIN_LIMIT_COEF.getFloatNumber() * player.getMaxHp();

        if (ExecuteConstants.EXEC_MAX_DAMAGE_LEVEL.getNumber() > this.level) {
            hpLimit += ((float) this.level / 100) * player.getMaxHpLevelUp();

            return hpLimit;
        }

        return hpLimit + ExecuteConstants.HP_MAX_LIMIT_COEF.getFloatNumber() * player.getMaxHp();
    }

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

    private int getTotalDamage(Map map, float playerExecuteModifier, float playerSlamModifier) {
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


    @Override
    public void visit(Pyromancer player) {
        Map map = Map.getInstance();
        if (player.getHp() > 0 && (float) player.getHp() < getHpLimit(player)) {
            player.getActiveDamage(player.getHp());
        } else {
            player.getActiveDamage(getTotalDamage(map, PlayersModifiers.PYRO_EXECUTE_MODIFIER.getNumber(),
                    PlayersModifiers.PYRO_SLAM_MODIFIER.getNumber()));
            player.setStunnedTurns(ExecuteConstants.STUN_SLAM_TURNS.getNumber());
        }
    }

    @Override
    public void visit(Knight player) {
        Map map = Map.getInstance();
        if (player.getHp() > 0 && (float) player.getHp() < getHpLimit(player)) {
            player.getActiveDamage(player.getHp());
        } else {
            player.getActiveDamage(getTotalDamage(map, PlayersModifiers.KNIGHT_EXECUTE_MODIFIER.getNumber(),
                    PlayersModifiers.KNIGHT_SLAM_MODIFIER.getNumber()));
            player.setStunnedTurns(ExecuteConstants.STUN_SLAM_TURNS.getNumber());
        }
    }

    @Override
    public void visit(Rogue player) {
        Map map = Map.getInstance();
        if (player.getHp() > 0 && (float) player.getHp() < getHpLimit(player)) {
            player.getActiveDamage(player.getHp());
        } else {
            player.getActiveDamage(getTotalDamage(map, PlayersModifiers.ROGUE_EXECUTE_MODIFIER.getNumber(),
                    PlayersModifiers.ROGUE_SLAM_MODIFIER.getNumber()));
            player.setStunnedTurns(ExecuteConstants.STUN_SLAM_TURNS.getNumber());
        }
    }

    @Override
    public void visit(Wizard player) {
        Map map = Map.getInstance();
        if (player.getHp() > 0 && (float) player.getHp() < getHpLimit(player)) {
            player.getActiveDamage(player.getHp());
        } else {
            player.getActiveDamage(getTotalDamage(map, PlayersModifiers.WIZARD_EXECUTE_MODIFIER.getNumber(),
                    PlayersModifiers.WIZARD_SLAM_MODIFIER.getNumber()));
            player.setStunnedTurns(ExecuteConstants.STUN_SLAM_TURNS.getNumber());
        }
    }
}
