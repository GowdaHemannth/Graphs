import java.util.*;
public class WordLadder1 {
    public static ArrayList<ArrayList<String>> Function(String startWord,String targetWord,String[] wordlist){
        Set<String>st=new HashSet<>();
        int len=wordlist.length;
        // Step 1;
        for(int i=0;i<len;i++){
            st.add(wordlist[i]);
        }
        Queue<ArrayList<String>>AS=new LinkedList<>();
        ArrayList<String>ls=new ArrayList<>();
        ls.add(startWord);
        AS.add(ls);

        // UsedLevel used beacuse it cant be defined in One or two line it needs to be understood by practice 
        ArrayList<String>UsedLevel=new ArrayList<>();
        int level=0;
          ArrayList<ArrayList<String>>ans=new ArrayList<>();

        // Step 2

        while(!AS.isEmpty()){
            ArrayList<String>VC=AS.peek();
            AS.remove();

            if(VC.size()>level){ //  These the only time we sre gonna do these removal thing these the only time 
                level++;
                for(int i=0;i<UsedLevel.size();i++){
                    String it=UsedLevel.get(i);
                    st.remove(it);

                }
                UsedLevel.clear(); // Clear for next level
            }
            String word=VC.get(VC.size()-1);
            if(word.equals(targetWord)) {
                if(ans.size() == 0 || ans.get(0).size() == VC.size()) {
                    ans.add(VC);
                }
            }
            


            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedCharArray[]=word.toCharArray(); // Here the whole Word will dived like d,e,s;
                    replacedCharArray[i]=ch;
                    String replacement =new String(replacedCharArray);
                    if(st.contains(replacement)){
                        VC.add(replacement);
        // Here you might have a doubt like why are we creating extra thing like that right beacse 
        //if directly add Vc then when we remove elements from VC it will effect the VC Elennt in Queue 
        // Since ArrayList Element are Passs By Reference 
                        ArrayList<String>Temp=new ArrayList<>(VC);
                         AS.add(Temp);

                         VC.remove(VC.size()-1);
                    }
                }
            }

        }
        return ans ;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        String startWord = "der";    String targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };
        
        ArrayList<ArrayList<String>>A=Function(startWord, targetWord, wordList);
        for(int i=0;i<A.size();i++){
           ArrayList<String>S=A.get(i);
           System.out.println(S);
        }
        System.out.println();


    }
    
}
