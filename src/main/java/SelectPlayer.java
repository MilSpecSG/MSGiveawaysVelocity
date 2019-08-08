
import com.velocitypowered.api.command.Command;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.Player;
import net.kyori.text.TextComponent;
import net.kyori.text.format.TextColor;
import net.kyori.text.format.TextDecoration;


import javax.annotation.Nonnull;
import javax.xml.soap.Text;
import java.util.Random;

public class SelectPlayer implements Command {


    @Override
    public void execute(CommandSource source,@Nonnull String[] args) {
        if (source instanceof Player) {
                Player[] onlinePlayers = MSGiveawaysVelocity.server.getAllPlayers().toArray(new Player[MSGiveawaysVelocity.server.getAllPlayers().size()]);

                Player randomPlayer;
                randomPlayer = onlinePlayers[new Random().nextInt(MSGiveawaysVelocity.server.getAllPlayers().toArray().length)];
                if (MSGiveawaysVelocity.server.getAllPlayers().size() == 1) {
                    source.sendMessage(TextComponent.of("There aren't enough players online to run this command!"));
                } else {
                    if (randomPlayer.getUsername().equals(((Player) source).getUsername())) {
                        while (randomPlayer.getUsername().equals(((Player) source).getUsername())) {
                            randomPlayer = onlinePlayers[new Random().nextInt(MSGiveawaysVelocity.server.getAllPlayers().toArray().length)];
                        }
                    } else {
                        //Funky shit compared to sponge's methods (possibly fixed in the future???)
                        MSGiveawaysVelocity.server.broadcast(TextComponent.of("[").color(TextColor.GOLD).append(TextComponent.of("|").decoration(TextDecoration.OBFUSCATED, true))
                                .append(TextComponent.of("MSGiveaway").color(TextColor.DARK_AQUA)).append(TextComponent.of("|").color(TextColor.GOLD).decoration(TextDecoration.OBFUSCATED, true)).append(TextComponent.of("]")
                                        .color(TextColor.GOLD)).append(TextComponent.of(randomPlayer.getUsername() + " has been selected!")));
                    }
                 }
        }else{
                source.sendMessage(TextComponent.of("Missing arguments!"));
            }
    }


}
