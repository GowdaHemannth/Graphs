import java.util.*;
class Pair{
    String First;
  int Second;
    Pair(String First,int  Second){
        this.First=First;
        this.Second=Second;

    }
}

public class WordLadder {
    public static int Function( String Start,String Target,  String[] wordList){

        Queue<Pair>Q=new LinkedList<>();

        Set<String>S=new HashSet<>();
               int n=wordList.length;
        for(int i=0;i<n;i++){
            S.add(wordList[i]);
        }

        Q.add(new Pair(Start, 1));
        S.remove(Start);

        while(!Q.isEmpty()){
            String word=Q.peek().First;
            int Steps=Q.peek().Second;
            if(word.equals(Target)==true){
                return Steps;
            }
            // 
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    // The Most Important thing Now 
                    char replacedCharArray[]=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replaceWord=new String(replacedCharArray);
                    if(S.contains(replaceWord)){
                        S.remove(replaceWord);
                        Q.add(new Pair(replaceWord, Steps+1));
                    }
                }
            }

        }
        return -1;


    }
    public static void main(String[] args) {
        String Start="der";
        String Target="dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };
        System.out.println(Function(Start, Target, wordList));
    }
}
