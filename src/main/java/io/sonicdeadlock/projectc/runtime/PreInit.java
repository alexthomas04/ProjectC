package io.sonicdeadlock.projectc.runtime;

import io.sonicdeadlock.projectc.entity.EntityFactory;
import io.sonicdeadlock.projectc.entity.Player;
import io.sonicdeadlock.projectc.entity.Widget;
import io.sonicdeadlock.projectc.entity.attribute.Attribute;
import io.sonicdeadlock.projectc.entity.attribute.AttributeFactory;
import io.sonicdeadlock.projectc.entity.attribute.Settings;
import io.sonicdeadlock.projectc.entity.skill.EyeSight;
import io.sonicdeadlock.projectc.entity.skill.Sprint;
import io.sonicdeadlock.projectc.world.chunk.ChunkGenerator;
import io.sonicdeadlock.projectc.world.chunk.generators.ChunkWidgetGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Alex on 10/5/2016.
 */
public class PreInit {
    private static PreInit ourInstance = new PreInit();
    private static final Logger LOGGER = LogManager.getLogger(PreInit.class);
    public static PreInit getInstance() {
        return ourInstance;
    }

    private PreInit() {

    }

    public void preInit(){
        registerEntities();
        registerGenerators();
        registerAttributes();
        registerSkills();
    }

    private void registerEntities(){
        LOGGER.info("Starting Entity registration");
        EntityFactory.getInstance().registerEntity(Widget.getType(),Widget.class);
        EntityFactory.getInstance().registerEntity(Player.getType(),Player.class);
        LOGGER.info("Finished Entity registration");
    }

    private void registerGenerators(){
        LOGGER.info("Starting Chunk Generator Registration");
        ChunkGenerator.getInstance().registerGenerator(ChunkWidgetGenerator.class);
        LOGGER.info("Finished Chunk Generator Registration");
    }

    private void registerAttributes(){
        LOGGER.info("Starting Attribute Registration");
        AttributeFactory.getInstance().registerAttribute(Settings.getType(),Settings.class);
        LOGGER.info("Finished Attribute Registration");
    }

    private void registerSkills(){
        LOGGER.info("Starting Skill Registration");
        AttributeFactory.getInstance().registerAttribute(Sprint.getType(),Sprint.class);
        AttributeFactory.getInstance().registerAttribute(EyeSight.getType(),EyeSight.class);
        LOGGER.info("Finished Skill Registration");
    }
}
