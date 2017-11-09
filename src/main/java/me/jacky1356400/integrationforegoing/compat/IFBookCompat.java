package me.jacky1356400.integrationforegoing.compat;

import com.buuz135.industrial.api.book.CategoryEntry;
import com.buuz135.industrial.api.book.page.PageText;
import com.buuz135.industrial.book.BookCategory;
import com.buuz135.industrial.proxy.ItemRegistry;
import me.jacky1356400.integrationforegoing.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;

public class IFBookCompat {

    public static void init() {
        BookCategory.GETTING_STARTED.getEntries().put(
                new ResourceLocation(Reference.MODID, "integration_foregoing"),
                new CategoryEntry("Integration Foregoing", new ItemStack(ItemRegistry.strawItem), Arrays.asList(new PageText(
                        "Seems like you've installed Integration Foregoing...\n\n"
                                + "Integration Foregoing is the official addon for Industrial Foregoing, "
                                + "making use of its API and added some missing mod integrations.\n\n"
                                + "Added contents includes: Additional straw drinking handler for fluids from other mods, "
                                + "Bioreactor entries, Plant Gatherer handlers, Tinkers' Construct tool materials and more!"
                )))
        );
    }

}
