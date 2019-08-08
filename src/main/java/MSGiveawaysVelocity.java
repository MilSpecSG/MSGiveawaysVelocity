import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

import javax.inject.Inject;

@Plugin(id = "msgiveawaysvelocity", name = "MSGiveawaysVelocity", authors = "STG_Allen, LGC_McLovin")
public class MSGiveawaysVelocity {
    public static ProxyServer server;

    @Inject
    public MSGiveawaysVelocity(ProxyServer lserver){server = lserver;}

    @Inject
    public void onStart(CommandManager commandManager, Logger logger){
        logger.info("[MSGiveaways] Initializing Plugin");
        commandManager.register(new SelectPlayer(), "msgive");
        logger.info("[MSGiveaways] Enabled commands.");

    }
}
