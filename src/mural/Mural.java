package mural;

import java.util.*;

public class Mural implements Iterable<Drawing> {
    private Set<Drawing> drawingSet;

    public Mural(Drawing[] drawings) {
        this.drawingSet = new HashSet<>(Arrays.asList(drawings));
    }

    public Set<Drawing> getDrawingSet() {
        return drawingSet;
    }

    public void setDrawingSet(Set<Drawing> drawingSet) {
        this.drawingSet = drawingSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mural\n");
        int countDrawing = 0;
        for (Drawing d : this) {
            sb.append("\t").append(d.toString()).append(" ").append(++countDrawing).append("\n");
            int countPicture = 0;
            for (Picture p : d.getPictureSet()) {
                sb.append("\t\t").append(p.toString()).append(" ").append(++countPicture).append("\n");
                for (Shape s : p.getShapeSet()) {
                    sb.append("\t\t\t").append(s.toString()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mural)) return false;
        Mural mural = (Mural) o;
        return getDrawingSet().equals(mural.getDrawingSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrawingSet());
    }

    @Override
    public Iterator<Drawing> iterator() {
        return this.drawingSet.iterator();
    }
}
