package skills;

import players.*;
import skills.KnightSkillsConstants.ExecuteConstants;
import skills.KnightSkillsConstants.SlamConstants;
import skills.PyromancerSkillsConstants.FireblastConstants;
import skills.PyromancerSkillsConstants.IgniteConstants;
import skills.RogueSkillsConstants.BackstabConstants;
import skills.RogueSkillsConstants.ParalysisConstants;
import skills.WizardSkillsConstants.DeflectConstants;
import skills.WizardSkillsConstants.DrainConstants;
import skills.WizardSkillsConstants.PlayersModifiers;
import utils.LandModifiers;
import utils.LandType;
import utils.Map;

public class WizardSkills implements SkillsVisitor {
    private int level;
    private int hp;
    private int maxHp;
    private Hero hero;

    public WizardSkills(Hero hero) {
        this.hero = hero;
        this.level = hero.getLevel();
        this.hp = hero.getHp();
        this.maxHp = hero.getMaxHp();
    }

    private float getDrainDamage(Map map, final float playerModifier, Hero player) {
        float drainProcent = DrainConstants.INIT_DRAIN_PROCENT.getNumber()
                + this.level * DrainConstants.DRAIN_MODIFIER.getNumber();

        float baseHp = Math.min(DrainConstants.HP_COEF.getFloatNumber() * (float) player.getMaxHp(), (float) player.getHp());

        drainProcent *= playerModifier;
        drainProcent /= DrainConstants.HUNDREAD.getNumber();
        drainProcent = drainProcent * baseHp;

        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.DESERT) {
            drainProcent *= LandModifiers.WIZARD_LAND_MODIFIER.getNumber();
        }

        return drainProcent;
    }

    private float getDeflectDamage(Map map, Hero player, float playerModifier, float opponentPower) {
        float deflectProcent = DeflectConstants.INIT_DEFLECT_PROCENT.getNumber()
                + this.level * DeflectConstants.DEFlECT_MODIFIER.getNumber();
        deflectProcent = Math.min(deflectProcent, DeflectConstants.MAX_PROC.getNumber());
        deflectProcent /= DrainConstants.HUNDREAD.getNumber();
        deflectProcent *= playerModifier;

        float deflectDamage = deflectProcent * opponentPower;

        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.DESERT) {
            deflectDamage *= LandModifiers.WIZARD_LAND_MODIFIER.getNumber();
        }

        return deflectDamage;
    }

    @Override
    public void visit(Pyromancer player) {
        Map map = Map.getInstance();
        float drainDamage = getDrainDamage(map, PlayersModifiers.PYRO_DRAIN_MODIFIER.getNumber(), player);
        drainDamage = Math.round(drainDamage);

        float fireBlastActiveDamage = FireblastConstants.INIT_FB_DAMAGE.getNumber();
        fireBlastActiveDamage += this.level * FireblastConstants.FB_MODIFIER.getNumber();
        float igniteActiveDamage = IgniteConstants.INIT_IGNITE_DAMAGE.getNumber();
        igniteActiveDamage += this.level * IgniteConstants.IGNITE_DAMAGE_MODIFIER.getNumber();

        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.VOLCANIC) {
            fireBlastActiveDamage *= LandModifiers.PYRO_LAND_MODIFIER.getNumber();
            igniteActiveDamage *= LandModifiers.PYRO_LAND_MODIFIER.getNumber();
        }

        fireBlastActiveDamage = Math.round(fireBlastActiveDamage);
        igniteActiveDamage = Math.round(igniteActiveDamage);
        float opponentPower = fireBlastActiveDamage + igniteActiveDamage;
        float deflectDamage = getDeflectDamage(map, player, PlayersModifiers.PYRO_ATTACK_MODIFIER.getNumber(),
                opponentPower);
        deflectDamage = Math.round(deflectDamage);
        float totalActiveDamage = deflectDamage + drainDamage;
        player.getActiveDamage(Math.round(totalActiveDamage));

    }

    @Override
    public void visit(Knight player) {
        Map map = Map.getInstance();
        float drainDamage = getDrainDamage(map, PlayersModifiers.KNIGHT_DRAIN_MODIFIER.getNumber(), player);
        drainDamage = Math.round(drainDamage);

        float opponentPower = 0;
        float hpLimit = ExecuteConstants.HP_MIN_LIMIT_COEF.getFloatNumber() * this.maxHp;
        if (ExecuteConstants.EXEC_MAX_DAMAGE_LEVEL.getNumber() > player.getLevel()) {
            hpLimit += ((float) this.level / DrainConstants.HUNDREAD.getNumber()) * player.getMaxHpLevelUp();
        } else {
            hpLimit += ExecuteConstants.HP_MAX_LIMIT_COEF.getFloatNumber() * this.maxHp;
        }

        boolean isExecuted = false;
        if ((float) this.hp < hpLimit && this.hp > 0) {
            isExecuted = true;
            opponentPower = this.hp;
        } else {
            float executeDamage = ExecuteConstants.INIT_EXEC_DAMAGE.getNumber();
            executeDamage += this.level * ExecuteConstants.EXEC_LEVEL_MODIFIER.getNumber();

            float slamDamage = SlamConstants.INIT_SLAM_DAMAGE.getNumber();
            slamDamage += this.level * SlamConstants.SLAM_LEVEL_MODIFIER.getNumber();

            opponentPower = executeDamage + slamDamage;
        }

        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.LAND && !isExecuted) {
            opponentPower *= LandModifiers.KNIGHT_LAND_MODIFIER.getNumber();
        }

        float deflectDamage = getDeflectDamage(map, player, PlayersModifiers.KNIGHT_ATTACK_MODIFIER.getNumber(),
                opponentPower);
        deflectDamage = Math.round(deflectDamage);
        float totalActiveDamage = deflectDamage + drainDamage;
        player.getActiveDamage(Math.round(totalActiveDamage));
    }

    @Override
    public void visit(Rogue player) {
        Map map = Map.getInstance();
        float drainDamage = getDrainDamage(map, PlayersModifiers.ROGUE_DRAIN_MODIFIER.getNumber(), player);
        drainDamage = Math.round(drainDamage);

        float backstabActiveDamage = BackstabConstants.BACKSTAB_INIT_DAMAGE.getNumber() + this.level
                * BackstabConstants.BACKSTAB_LEVEL_MODIFIER.getNumber();

        if (player.getBackstab() % BackstabConstants.CRITICAL_HIT.getNumber() == 0) {
            if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY()) ==
                    LandType.WOODS) {
                backstabActiveDamage *= BackstabConstants.BACKSTAB_CRITICAL_HIT_COEF.getFloatNumber();
            }
        }

        float paralysisActiveDamage = ParalysisConstants.INIT_PARALYSIS_DAMAGE.getNumber() + this.level *
                ParalysisConstants.PARALYSIS_DAMAGE_MODIFIER.getNumber();


        float opponentPower = backstabActiveDamage + paralysisActiveDamage;
        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.WOODS) {
            opponentPower *= LandModifiers.ROGUE_LAND_MODIFIER.getNumber();
        }

        float deflectDamage = getDeflectDamage(map, player, PlayersModifiers.ROGUE_ATTACK_MODIFIER.getNumber(),
                opponentPower);
        deflectDamage = Math.round(deflectDamage);
        float totalActiveDamage = deflectDamage + drainDamage;
        player.getActiveDamage(Math.round(totalActiveDamage));
    }

    @Override
    public void visit(Wizard player) {
        Map map = Map.getInstance();
        float drainDamage = getDrainDamage(map, PlayersModifiers.WIZARD_DRAIN_MODIFIER.getNumber(), player);
        drainDamage = Math.round(drainDamage);
        player.getActiveDamage(Math.round(drainDamage));

    }
}
