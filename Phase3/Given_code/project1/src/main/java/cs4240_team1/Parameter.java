package cs4240_team1;

/** For function parameters */
public class Parameter {

    public final String paramId;
    public final String typeId;  /* use typeId to lookup type info in appropriate symbol table */

    public Parameter(String paramId, String typeId) {
        this.paramId = paramId;
        this.typeId = typeId;
    }
}
