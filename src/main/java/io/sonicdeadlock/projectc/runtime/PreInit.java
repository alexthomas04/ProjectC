package io.sonicdeadlock.projectc.runtime;

import io.sonicdeadlock.projectc.entity.Player;
import io.sonicdeadlock.projectc.entity.Widget;
import io.sonicdeadlock.projectc.entity.attribute.Settings;
import io.sonicdeadlock.projectc.entity.skill.EyeSight;
import io.sonicdeadlock.projectc.entity.skill.Sprint;
import io.sonicdeadlock.projectc.item.WidgetItem;
import io.sonicdeadlock.projectc.util.LoaderFactory;
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
        registerItems();
    }

    private void registerEntities(){
        LOGGER.info("Starting Entity registration");
        LoaderFactory.getEntityLoaderFactoryInstance().registerLoadable(Widget.TYPE,Widget.class);
        LoaderFactory.getEntityLoaderFactoryInstance().registerLoadable(Player.TYPE,Player.class);
        LOGGER.info("Finished Entity registration");
    }

    private void registerGenerators(){
        LOGGER.info("Starting Chunk Generator Registration");
        ChunkGenerator.getInstance().registerGenerator(ChunkWidgetGenerator.class);
        LOGGER.info("Finished Chunk Generator Registration");
    }

    private void registerAttributes(){
        LOGGER.info("Starting Attribute Registration");
        LoaderFactory.getAttributeLoaderFactoryInstance().registerLoadable(Settings.TYPE,Settings.class);
        LOGGER.info("Finished Attribute Registration");
    }

    private void registerSkills(){
        LOGGER.info("Starting Skill Registration");
        LoaderFactory.getAttributeLoaderFactoryInstance().registerLoadable(Sprint.TYPE,Sprint.class);
        LoaderFactory.getAttributeLoaderFactoryInstance().registerLoadable(EyeSight.TYPE,EyeSight.class);
        LOGGER.info("Finished Skill Registration");
    }

    private void registerItems(){
        LOGGER.info("Starting Item Registration");
        LoaderFactory.getItemLoaderFactoryInstance().registerLoadable(WidgetItem.TYPE,WidgetItem.class);
        LOGGER.info("Finished Item Registration");
    }
}
