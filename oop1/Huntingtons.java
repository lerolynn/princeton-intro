public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int cag = 0;
        int maxCag = 0;
        for (int i = 0; i < dna.length() - 2; i++) {

            if (dna.substring(i, i + 3).equals("CAG")) {
                cag++;
                i += 2;
            } else {
                cag = 0;
            }
            if (cag > maxCag) {
                maxCag = cag;
            }
        }
        return maxCag;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        StringBuilder noWhite = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && s.charAt(i) != '\n' && s.charAt(i) != '\t')
                noWhite.append(s.charAt(i));
        }
        return noWhite.toString();
    }


    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {

        if (maxRepeats >= 10 && maxRepeats <= 35) {
            return "normal";
        } else if (maxRepeats >= 36 && maxRepeats <= 39) {
            return "Huntington's";
        } else if (maxRepeats >= 40 && maxRepeats <= 180) {
            return "Huntington's";
        } else {
            return "not human";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String fileName = args[0];
        In input = new In(fileName);
        String unprocessedGene = input.readAll();

        String gene = removeWhitespace(unprocessedGene);
        int repeats = maxRepeats(gene);
        String diagnosis = diagnose(repeats);

        System.out.println("max repeats = " + repeats);
        System.out.println(diagnosis);
    }
}
