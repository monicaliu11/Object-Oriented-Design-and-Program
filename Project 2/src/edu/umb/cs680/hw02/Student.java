package edu.umb.cs680.hw02;

public class Student {
    private float tuition;
    private String name;
    private int i20num;
    private String usAddr;
    private int yrsInState;
    private String priorState;
    private String foreignAddr;
    private StudentStatus status;

    public enum StudentStatus {
        INSTATE, OUTSTATE, INTL;
    }

    private Student(float tuition, String name, int i20num, String usAddr, int yrsInState, String priorState,
                    String foreignAddr, StudentStatus status) {
        this.tuition = tuition;
        this.name = name;
        this.i20num = i20num;
        this.usAddr = usAddr;
        this.yrsInState = yrsInState;
        this.priorState = priorState;
        this.foreignAddr = foreignAddr;
        this.status = status;
    }

    public static Student createInStateStudent(String name, String usAddr, int yrsInState, String priorState) {
        return new Student (100f, name, 0, usAddr, yrsInState, priorState,"", StudentStatus.INSTATE);
    }

    public static Student createOutStateStudent (String name, String usAddr, int yrsInState, String priorState) {
        return new Student (200f, name, 0, usAddr, yrsInState, priorState,"", StudentStatus.OUTSTATE);
    }

    public static Student createIntelStudent (String name, int i20num, String usAddr, int yrsInState, String foreignAddr) {
        return new Student (500f, name, i20num, usAddr, yrsInState, null, foreignAddr, StudentStatus.INTL);
    }

    public float getTuition() { return this.tuition; }

    public String getName() { return this.name; }

    public int getI20num() { return this.i20num; }

    public String getUsAddr() { return this.usAddr; }

    public int getYrsInState() { return this.yrsInState; }

    public String getPriorState() {return this.priorState; }

    public String getForeignAddr() { return this.foreignAddr; }

    public StudentStatus getStatus() { return this.status; }


}
