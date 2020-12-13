package com.company;

public class Main {

    public static void main(String[] args){
        task1();
        task2();
        System.out.println(PigLatin("this cat is flying"));
        printTokenizedPhoneNumber("(537) 515-5348");
        lettersCounter("To be or not to be: that is the question");
        wordLengthCounter("Whether 'tis nobler in the mind to suffer");
        countOccurrencesOfWords("To be or not to be that is the question Whether 'tis nobler in the mind to suffer");
    }

    public static void task1(){
        StringBuilder s1 = new StringBuilder("Java");
        StringBuilder s2 = new StringBuilder("HTML");
        System.out.println(s1.append(" is fun"));
        s1.setLength(0); s1.append("Java");
        System.out.println(s1.append(s2));
        s1.setLength(0); s1.append("Java");
        System.out.println(s1.insert(2, "is fun"));
        s1.setLength(0); s1.append("Java");
        System.out.println(s1.insert(1, s2));
        s1.setLength(0); s1.append("Java");
        System.out.println(s1.charAt(2));
        System.out.println(s1.length());
        System.out.println(s1.deleteCharAt(3));
        s1.setLength(0); s1.append("Java");
        System.out.println(s1.delete(1, 3));
        s1.setLength(0); s1.append("Java");
        System.out.println(s1.reverse());
        s1.setLength(0); s1.append("Java");
        System.out.println(s1.replace(1, 3, "Computer"));
        s1.setLength(0); s1.append("Java");
        System.out.println(s1.substring(1, 3));
        System.out.println(s1.substring(2));
    }

    public static void change(String s, StringBuilder sb){
        s = s + " and HTML";
        sb.append(" and HTML");
    }

    public static void task2(){
        String s = "Java";
        StringBuilder sb = new StringBuilder(s);
        change(s, sb);
        System.out.printf("%s\n%s", s, sb);
    }

    public static StringBuilder latinWords(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.append(sb.charAt(0));
        sb.append("ay");
        sb.deleteCharAt(0);
        return sb;
    }

    public static StringBuilder PigLatin(String s){
        String [] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word :
                words) {
            sb.append(latinWords(word));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }

    public static void printTokenizedPhoneNumber(String s){
        String s1 = new String(s.substring(1, 4));
        String s2 = new String(s.substring(6, 9) + s.substring(10, 14));
        System.out.println("Code of area " + s1);
        System.out.println("Phone number " + s2);
    }

    public static void lettersCounter(String s){
        int [] ch = new int[26];
        s = s.toLowerCase();
        for(int i = 0 ; i < s.length(); ++i){
            if(s.charAt(i) < 'a' || s.charAt(i) > 'z'){
                continue;
            }
            ++ ch[(s.charAt(i) - 'a')];
        }
        for(int i=0;i<26;++i){
            System.out.printf("%c\t%d\n", (char)i+'a', ch[i]);
        }
    }
    public static void wordLengthCounter(String s){
        String [] words = s.split(" ");
        int [] r = new int[50];
        int max = 1;
        for (String word:
             words) {
            ++ r[ word.length()];
            max = Math.max(max, word.length());
        }
        for(int i=1;i<=max; ++i){
            System.out.printf("%d\t\t%d\n", i, r[i]);
        }
    }

    public static void countOccurrencesOfWords(String s){
        s = s.toLowerCase();
        String [] words = s.split(" ");
        int count = 0;
        for (String word : words) {
            while (s.contains(word)) {
                ++count;
                s = s.substring(0, s.indexOf(word)) + s.substring(s.indexOf(word) + word.length());
            }
            if (count != 0) {
                System.out.printf("%-15s\t\t%10d\n", word, count);
                count = 0;
            }
        }
    }
}
