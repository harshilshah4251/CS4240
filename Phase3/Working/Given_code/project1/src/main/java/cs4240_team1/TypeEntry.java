package cs4240_team1;

public class TypeEntry extends SymbolTableEntry {

    public final String typeId;

    /* the base-type on the right hand side of the '=' in the source code */
    public final String derivedId;

    /* null dimension means that the type does not have that particular dimension */
    public final Integer dimension1;
    public final Integer dimension2;

	public TigerType tigerType;

    /** Non-arrays */
    public TypeEntry(String typeId, String derivedId) {
        this(typeId, derivedId, null, null);
    }

    /** One dimenensional arrays */
    public TypeEntry(String typeId, String derivedId, String dimension1) {
        this(typeId, derivedId, dimension1, null);
    }

    /** Two dimensional arrays */
    public TypeEntry(String typeId, String derivedId, String dimension1, String dimension2) {
        super(typeId);
        this.typeId = typeId;
        this.derivedId = derivedId;
        this.dimension1 = (dimension1 == null) ? null : Integer.parseInt(dimension1);
        this.dimension2 = (dimension2 == null) ? null : Integer.parseInt(dimension2);
		this.tigerType = new TigerType(this);
    }

    @Override
    public String toString() {
		String prefix = "< " + typeId + " | " + derivedId;
		String suffix = " >";
		if (tigerType.isArray1D()) {
			return prefix + "[" + dimension1 + "]" + suffix;
		} else if (tigerType.isArray2D()) {
			return prefix + "[" + dimension1 + "][" + dimension2 + "]" + suffix;
		} else {
			return prefix + suffix;
		}
    }

	@Override
	public String getCategoryAsString() {
		return "type";
	}

	public boolean isArray1D() {
		return dimension1 != null && dimension2 == null;
	}

	public boolean isArray2D() {
		return dimension1 != null && dimension2 != null;
	}

	public boolean isArray() {
		return isArray1D() || isArray2D();
	}

    /**
     * returns...
     *      0 if it is not an array type
     *      1 if it is a 1D array
     *      2 if it is a 2D array
     */
    public int getDimensions() {
        int count = 0;
        if (dimension1 != null) {
            count++;
        }
        if (dimension2 != null) {
            count++;
        }
        return count;
    }

}
