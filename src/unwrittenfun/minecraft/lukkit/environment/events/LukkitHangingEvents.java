
package unwrittenfun.minecraft.lukkit.environment.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

import java.util.ArrayList;

/**
 * Bukkit Plugin: Lukkit
 * Original Author: UnwrittenFun
 * Maintainer: jammehcow
*/
public class LukkitHangingEvents implements Listener {
    public LukkitHangingEvents() {
        LukkitEvents.eventMap.put("hangingBreakByEntity", new ArrayList<>());
        LukkitEvents.eventMap.put("hangingBreak", new ArrayList<>());
        LukkitEvents.eventMap.put("hangingPlace", new ArrayList<>());
    }

    @EventHandler
    public void hangingBreakByEntity(HangingBreakByEntityEvent event) {
        ArrayList<LuaFunction> callbacks = LukkitEvents.eventMap.get("hangingBreakByEntity");
        for (LuaFunction cb : callbacks) {
            cb.call(CoerceJavaToLua.coerce(event));
            if (event.isCancelled()) return;
        }
    }

    @EventHandler
    public void hangingBreak(HangingBreakEvent event) {
        ArrayList<LuaFunction> callbacks = LukkitEvents.eventMap.get("hangingBreak");
        for (LuaFunction cb : callbacks) {
            cb.call(CoerceJavaToLua.coerce(event));
            if (event.isCancelled()) return;
        }
    }

    @EventHandler
    public void hangingPlace(HangingPlaceEvent event) {
        ArrayList<LuaFunction> callbacks = LukkitEvents.eventMap.get("hangingPlace");
        for (LuaFunction cb : callbacks) {
            cb.call(CoerceJavaToLua.coerce(event));
            if (event.isCancelled()) return;
        }
    }
}