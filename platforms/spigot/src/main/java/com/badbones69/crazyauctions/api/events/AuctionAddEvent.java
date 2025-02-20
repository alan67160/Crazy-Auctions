package com.badbones69.crazyauctions.api.events;

import com.badbones69.crazyauctions.api.auctionhouse.interfaces.AuctionItem;
import com.badbones69.crazyauctions.api.auctionhouse.objects.AuctionHouse;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 *
 * @author Ryder Belserion
 *
 * This event is fired when a item is added to a auction house.
 *
 */
public class AuctionAddEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private final UUID uuid;
    private final Player player;
    private final AuctionItem auctionItem;
    private final AuctionHouse auctionHouse;

    /**
     * A constructor to include values for a bid event.
     *
     * @param uuid the uuid of the player who placed the bid.
     * @param auctionHouse the auction house the item is being added to.
     * @param auctionItem the auction item being added.
     */
    public AuctionAddEvent(UUID uuid, AuctionHouse auctionHouse, AuctionItem auctionItem) {
        this.uuid = uuid;
        this.player = Bukkit.getPlayer(uuid);
        this.auctionHouse = auctionHouse;
        this.auctionItem = auctionItem;
    }

    public AuctionItem getAuctionItem() {
        return auctionItem;
    }

    public AuctionHouse getAuctionHouse() {
        return auctionHouse;
    }

    public Player getPlayer() {
        return this.player;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

}