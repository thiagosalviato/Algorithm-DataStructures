package LinearSearch;

public class StringVector {
    public static void main(String[] args) {

        String[] brazil_states = new String[10];

        brazil_states[0] = "AC";
        brazil_states[1] = "BA";
        brazil_states[2] = "CE";
        brazil_states[3] = "DF";
        brazil_states[4] = "AM";
        brazil_states[5] = "AP";
        brazil_states[6] = "PB";
        brazil_states[7] = "RN";
        brazil_states[8] = "SP";
        brazil_states[9] = "RN";

        for (int i = 0; i < brazil_states.length; i++) {
            System.out.println("State " + i + ":" + brazil_states[i]);
        }
    }
}
