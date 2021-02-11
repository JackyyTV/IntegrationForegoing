package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerAOA {

    private static final String[] LOGS = new String[] {
            "achony", "blood", "churry", "creep", "cycade",
            "dawn", "eyeball", "haunted", "haunted_eye", "haunted_eyes",
            "haunted_flashing", "haunted_purpling", "iro", "lucalus", "lunide",
            "runic", "shadow", "shyre", "stranglewood", "toxic"
    };

    public static void init() {
        for (String log : LOGS) {
            ModUtils.registerTreeFluidExtractorEntry(ModNames.AOA, log + "_log", 1);
        }
    }

}
