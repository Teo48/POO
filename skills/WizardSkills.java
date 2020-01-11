package skills;

import players.Hero;
import players.Knight;
import players.Pyromancer;
import players.Wizard;
import players.Rogue;
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

public final class WizardSkills implements SkillsVisitor {
    private int level;
    private int hp;
    private int maxHp;
    private Wizard hero;

    /**
     * Constructor.
     * @param hero -> A wizzard.
     * */
    public WizardSkills(final Wizard hero) {
        this.hero = hero;
        this.level = hero.getLevel();
        this.hp = hero.getHp();
        this.maxHp = hero.getMaxHp();
    }

    /**
     * Method used to get the drain damage.
     * If the player is on a DESERT land we amplify amplify the drainProcent with
     * the wizzard land modifier.
     * @param map
     * @param playerModifier
     * @param player
     * @return float -> Drain damage.
     * */
    private float getDrainDamage(final Map map, final float playerModifier, final Hero player) {
        float drainProcent = DrainConstants.INIT_DRAIN_PROCENT.getNumber()
                + this.level * DrainConstants.DRAIN_MODIFIER.getNumber();

        float baseHp = Math.min(DrainConstants.HP_COEF.getFloatNumber()
                * (float) player.getMaxHp(), (float) player.getHp());

        drainProcent *= playerModifier;
        drainProcent /= DrainConstants.HUNDREAD.getNumber();
        drainProcent *= baseHp;

        if (map.getLandType(player.getCoordinates().getX(),
                player.getCoordinates().getY()) == LandType.DESERT) {
            drainProcent *= LandModifiers.WIZARD_LAND_MODIFIER.getNumber();
        }

        return drainProcent;
    }


    /**
     * Method used to get the deflect damage.
     *If the player is on a DESERT land we amplify amplify the drainProcent
     * with the wizzard land modifier.
     * @param map
     * @param player
     * @param playerModifier
     * @param opponentPower
     * @return float -> Deflect damage.
     * */
    private float getDeflectDamage(final Map map, final Hero player, final float playerModifier,
                                   final float opponentPower) {
        float deflectProcent = DeflectConstants.INIT_DEFLECT_PROCENT.getNumber()
                + this.level * DeflectConstants.DEFlECT_MODIFIER.getNumber();
        deflectProcent = Math.min(deflectProcent, DeflectConstants.MAX_PROC.getNumber());
        deflectProcent /= DrainConstants.HUNDREAD.getNumber();
        deflectProcent *= playerModifier;

        float deflectDamage = deflectProcent * opponentPower;

        if (map.getLandType(player.getCoordinates().getX(),
                player.getCoordinates().getY()) == LandType.DESERT) {
            deflectDamage *= LandModifiers.WIZARD_LAND_MODIFIER.getNumber();
        }

        return deflectDamage;
    }

    /**
     * Visit method for a Pyromancer.
     * Firstly we get the drainDamage, and then we calculate the damage that is going
     * to be deflect from pyromancer's abilities.
     * @param player
     * */
    @Override
    public void visit(final Pyromancer player) {
        Map map = Map.getInstance();
        float drainDamage = getDrainDamage(map,
                PlayersModifiers.PYRO_DRAIN_MODIFIER.getNumber(hero.getAngelModifier()), player);
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
        float deflectDamage = getDeflectDamage(map, player,
                PlayersModifiers.PYRO_ATTACK_MODIFIER.getNumber(hero.getAngelModifier()),
                opponentPower);
        deflectDamage = Math.round(deflectDamage);
        float totalActiveDamage = deflectDamage + drainDamage;
        player.getActiveDamage(Math.round(totalActiveDamage));
    }

    /**
     * Visit method for a Knight.
     * Firstly we get the drainDamage and then we check if Knight can execute a Wizard.
     * If so, the wizard is dead. Otherwise we calculate the damage that is going
     *to be deflect from knight's abilities.
     * @param player
     * */
    @Override
    public void visit(final Knight player) {
        Map map = Map.getInstance();
        float drainDamage = getDrainDamage(map,
                PlayersModifiers.KNIGHT_DRAIN_MODIFIER
                        .getNumber(hero.getAngelModifier()), player);
        drainDamage = Math.round(drainDamage);

        float opponentPower = 0;
        float hpLimit = ExecuteConstants.HP_MIN_LIMIT_COEF.getFloatNumber() * hero.getMaxHp();
        if (ExecuteConstants.EXEC_MAX_DAMAGE_LEVEL.getNumber() > player.getLevel()) {
            hpLimit += ((float) this.level / DrainConstants.HUNDREAD.getNumber())
                    * player.getMaxHpLevelUp();
        } else {
            hpLimit += ExecuteConstants.HP_MAX_LIMIT_COEF.getFloatNumber() * hero.getMaxHp();
        }

        boolean isExecuted = false;
        if ((float) hero.getHp() < hpLimit && hero.getHp() > 0) {
            isExecuted = true;
        }

        float executeDamage = ExecuteConstants.INIT_EXEC_DAMAGE.getNumber();
        executeDamage += player.getLevel() * ExecuteConstants.EXEC_LEVEL_MODIFIER.getNumber();

        float slamDamage = SlamConstants.INIT_SLAM_DAMAGE.getNumber();
        slamDamage += player.getLevel() * SlamConstants.SLAM_LEVEL_MODIFIER.getNumber();

        opponentPower = executeDamage + slamDamage;


        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.LAND && !isExecuted) {
            opponentPower *= LandModifiers.KNIGHT_LAND_MODIFIER.getNumber();
        }

        float deflectDamage = getDeflectDamage(map, player,
                PlayersModifiers.KNIGHT_ATTACK_MODIFIER
                        .getNumber(hero.getAngelModifier()), opponentPower);
        deflectDamage = Math.round(deflectDamage);
        float totalActiveDamage = deflectDamage + drainDamage;

        player.getActiveDamage(Math.round(totalActiveDamage));
    }

    /**
     * Visit method for a Rogue.
     * Firstly we get the drainDamage, and then we calculate the damage that is going
     * to be deflect from rogue's abilities.
     * @param player
     * */
    @Override
    public void visit(final Rogue player) {
        Map map = Map.getInstance();
        float drainDamage = getDrainDamage(map, PlayersModifiers.ROGUE_DRAIN_MODIFIER
                        .getNumber(hero.getAngelModifier()),
                player);
        drainDamage = Math.round(drainDamage);

        float backstabActiveDamage = BackstabConstants.BACKSTAB_INIT_DAMAGE.getNumber()
                + this.level * BackstabConstants.BACKSTAB_LEVEL_MODIFIER.getNumber();

        if (player.getBackstab() % BackstabConstants.CRITICAL_HIT.getNumber() == 0) {
            if (map.getLandType(player.getCoordinates().getX(),
                    player.getCoordinates().getY()) == LandType.WOODS) {
                backstabActiveDamage *=
                        BackstabConstants.BACKSTAB_CRITICAL_HIT_COEF.getFloatNumber();
            }
        }

        float paralysisActiveDamage = ParalysisConstants.INIT_PARALYSIS_DAMAGE.getNumber()
                + this.level * ParalysisConstants.PARALYSIS_DAMAGE_MODIFIER.getNumber();


        float opponentPower = backstabActiveDamage + paralysisActiveDamage;
        if (map.getLandType(player.getCoordinates().getX(), player.getCoordinates().getY())
                == LandType.WOODS) {
            opponentPower *= LandModifiers.ROGUE_LAND_MODIFIER.getNumber();
        }

        float deflectDamage = getDeflectDamage(map, player,
                PlayersModifiers.ROGUE_ATTACK_MODIFIER
                        .getNumber(hero.getAngelModifier()), opponentPower);
        deflectDamage = Math.round(deflectDamage);
        float totalActiveDamage = deflectDamage + drainDamage;
        player.getActiveDamage(Math.round(totalActiveDamage));
    }

    /**
     * Visit method for a Wizard.
     * Wizard doesn't use deflect on another wizard so we only calculate the drainDamage.
     * @param player
     * */
    @Override
    public void visit(final Wizard player) {
        Map map = Map.getInstance();
        float drainDamage = getDrainDamage(map,
                PlayersModifiers.WIZARD_DRAIN_MODIFIER.getNumber(hero.getAngelModifier()), player);
        drainDamage = Math.round(drainDamage);
        player.getActiveDamage(Math.round(drainDamage));
    }
}
