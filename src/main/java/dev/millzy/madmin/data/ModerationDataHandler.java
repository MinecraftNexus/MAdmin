package dev.millzy.madmin.data;

public class ModerationDataHandler extends DataHandler<ModerationData> {
    @Override
    public String getName() {
        return "moderation";
    }

    @Override
    public ModerationData instantiate() {
        return new ModerationData();
    }
}
