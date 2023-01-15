package dev.millzy.madmin;

import dev.millzy.madmin.data.ModerationDataHandler;

public class DataManager {
    private static DataManager instance;

    private ModerationDataHandler moderationDataHandler;

    public static DataManager getInstance() {
        if (instance == null)
            instance = new DataManager();

        return instance;
    }

    private DataManager() {}

    public ModerationDataHandler getModerationData() {
        if (moderationDataHandler == null)
            moderationDataHandler = new ModerationDataHandler();
        return moderationDataHandler;
    }
}
