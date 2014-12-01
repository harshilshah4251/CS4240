package cs4240_team1;

/**
 * Created by svermeyen1 on 11/8/14.
 */
public class LiteralArgument implements IRCodeArgument {
    String text;
    TigerType type;

    public LiteralArgument(String text, TigerType type) {
        this.text = text;
        this.type = type;
    }

    @Override
    public String getTextForIR() {
        return this.text;
    }

    @Override
    public TigerType getTigerType() {
        return this.type;
    }
}
