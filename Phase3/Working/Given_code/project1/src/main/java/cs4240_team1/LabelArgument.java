package cs4240_team1;


public class LabelArgument implements IRCodeArgument {

    String text;

    public LabelArgument(String text) {
        this.text = text;
    }

    @Override
    public String getTextForIR() {
        return this.text;
    }

    @Override
    public TigerType getTigerType() {
        return null;
    }
}
