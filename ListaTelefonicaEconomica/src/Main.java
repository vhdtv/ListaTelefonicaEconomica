import java.util.Arrays;
import java.util.Scanner;

class Main {

    static class StringWrapper implements Comparable<StringWrapper> {
        String s1;

        public StringWrapper(String s1) {
            this.s1 = s1;
        }

        @Override
        public int compareTo(StringWrapper o) {
            return this.s1.compareTo(o.s1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            StringWrapper[] sstring = new StringWrapper[t];

            for (int i = 0; i < t; i++) {
                String s = scanner.nextLine();
                sstring[i] = new StringWrapper(s);
            }

            Arrays.sort(sstring);

            int ans = 0;
            for (int i = 1; i < t; i++) {
                for (int j = 0; j < sstring[i].s1.length(); j++) {
                    if (sstring[i].s1.charAt(j) == sstring[i - 1].s1.charAt(j)) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(ans);
        }

        scanner.close();
    }
}
