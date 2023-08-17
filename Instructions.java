public class Instructions {
    public static final int MAX=200;
    private Instruction [] instructs;
    private int n;
    
    public Instructions() {
        instructs = new Instruction[MAX];
        n = 0;
    }
    
    public void addInstruction(Instruction newInstrct) {
        instructs[n] = newInstrct;
        n++;
    }
    
    public void addInstruction(int os, char oc, char nc, int dir, int ns) {
        Instruction inst;
        
        inst = new Instruction(os, oc, nc, dir, ns);
        addInstruction(inst);
    }
    
    public Instruction find(int os, char oc) {
        boolean found;
        int i;
        
        found = false;
        i = 1;
        while (!found && i < n)
            if (instructs[i].equals(os,oc))
                found = true;
            else
                i++;
        if (found)
            return instructs[i];
        else
            return null;
    }
    
    public String toString() {
        String str;
        int i;
        
        str = "Instructions:\n";
        for (i = 0; i < n; i++)
            str += "    "+instructs[i].toString();
        return str;
    }
}
