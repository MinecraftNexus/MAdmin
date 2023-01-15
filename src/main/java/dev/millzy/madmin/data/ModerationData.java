package dev.millzy.madmin.data;

import dev.millzy.madmin.data.stores.ModerationActionDataStore;

import java.util.ArrayList;

public class ModerationData extends Data {
    public ArrayList<ModerationActionDataStore> kicks = new ArrayList<>();
    public ArrayList<ModerationActionDataStore> warnings = new ArrayList<>();
    public ArrayList<ModerationActionDataStore> bans = new ArrayList<>();
}
