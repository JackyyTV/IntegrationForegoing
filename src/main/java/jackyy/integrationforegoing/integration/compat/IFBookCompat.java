package jackyy.integrationforegoing.integration.compat;

import com.buuz135.industrial.api.book.CategoryEntry;
import com.buuz135.industrial.api.book.page.PageText;
import com.buuz135.industrial.book.BookCategory;
import com.buuz135.industrial.proxy.ItemRegistry;
import jackyy.integrationforegoing.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class IFBookCompat {

    public static void init() {
        BookCategory.GETTING_STARTED.getEntries().put(
                new ResourceLocation(Reference.MODID, "addon_introduction"),
                new CategoryEntry(Reference.MODNAME, new ItemStack(ItemRegistry.strawItem), PageText.createTranslatedPages(Reference.BOOK_TEXT + "addon_introduction"))
        );
    }

}
