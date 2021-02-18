package characters;

public class GameCharacter {

    protected String displayCharacter;
    protected int rowAxis;
    protected int columnAxis;

    public GameCharacter() {}

    public String getDisplayCharacter() {
        return displayCharacter;
    }

    public int getRowAxis() {
        return rowAxis;
    }

    public int getColumnAxis() {
        return columnAxis;
    }

    public void setRowAxis(int rowAxis) {
        this.rowAxis = rowAxis;
    }

    public void setColumnAxis(int columnAxis) {
        this.columnAxis = columnAxis;
    }
}
