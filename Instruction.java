public class Instruction {
    private int oldState, newState, direction;
    private char oldChar, newChar;
    
    public Instruction (int os, char oc, char nc, int dir, int ns) {
        oldState = os;
        oldChar = oc;
        newChar = nc;
        direction = dir;
        newState = ns;
    }
    
    public Instruction (String line) {
        String[] parts;
        parts = line.split(",");
        oldState = Integer.parseInt(parts[0]);
        oldChar = parts[1].charAt(0);
        newChar = parts[2].charAt(0);
        direction = Integer.parseInt(parts[3]);
        newState = Integer.parseInt(parts[4]);

    }
    public boolean equals(int state, char chr) {
        return (oldState == state && oldChar == chr);
    }
    
    public char getNewChar() {
        return newChar;
    }
    
    public int getDirection() {
        return direction;
    }
    
    public int getNewState() {
        return newState;
    }
    
    public String toString() {
        return "("+oldState+", "+oldChar+", "+newChar+", "+direction+", "+
               newState+")";
    }
}