import java.io.*;
import java.util.*;

public class TuringMachine {
    private Instructions myCode;
    private Tape myTape;
    private int state;
    
    public TuringMachine(String filename) throws IOException {
        Scanner myData;
        String dataLine;
        String[] parts;
        int os, ns, dir;
        char oc, nc;
        
        myData = new Scanner(new FileReader(filename));
        myCode = new Instructions();
        dataLine = myData.nextLine();
        myTape = new Tape(dataLine);
        state = 0;
        while (myData.hasNext()) {
            dataLine = myData.nextLine();
            parts = dataLine.split(",");
            os = Integer.parseInt(parts[0]);
            oc = parts[1].charAt(0);
            nc = parts[2].charAt(0);
            dir = Integer.parseInt(parts[3]);
            ns = Integer.parseInt(parts[4]);
            myCode.addInstruction(os,oc,nc,dir,ns);
        }
        myData.close();
    }
    
    public void step() {
        int curState, newState, direction;
        char curChar, newChar;
        Instruction curInstrct;
        
        curState = state;
        curChar = myTape.readTape();
        curInstrct = myCode.find(curState,curChar);
        newState = curInstrct.getNewState();
        newChar = curInstrct.getNewChar();
        direction = curInstrct.getDirection();
        myTape.writeTape(newChar);
        myTape.moveHead(direction);
        state = newState;
    }
    
    public void run() {
        while (state >= 0)
            step();
    }
    
    public String toString() {
        String result;
        
        result = "State:  ";
        if (state >= 0)
            result += state+"\n";
        else if (state == -1)
            result += "ACCEPTING\n";
        else
            result += "REJECTING ("+state+")\n";
        result += myTape.toString();
        return result;
    }
}
        