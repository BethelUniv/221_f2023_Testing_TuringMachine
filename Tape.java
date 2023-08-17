public class Tape {
    private String myTape;
    private int head;
    
    public Tape(String inStr) {
        myTape = inStr;
        head = 0;
    }
    
    public char readTape() {
        return myTape.charAt(head);
    }
    
    public void writeTape(char newChar) {
        String front, end;
        front = myTape.substring(1,head);
        end = myTape.substring(head,myTape.length());
        myTape =  front+newChar+end;
    }
    
    public void moveHead(int direction) {
        head += direction;
    }
    
    public String toString() {
        return myTape+" head at "+head;
    }
}