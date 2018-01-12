/**
 * Created by Richu on 10/9/2016.
 */
import java.io.FileNotFoundException;
import java.io.*;
import java.lang.StringBuffer;

public class JavascriptFormatter {
    private JSStack stack;
    private int indentLevel;

    public JavascriptFormatter(){
        stack = new JSStack();
        indentLevel=0;
    }

   public String format(String input){
        try{

            File file  = new File("/Users/Richu/Documents/cse2143/extrabrace-unformat");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String text=br.readLine();
            for(int i=0; i<text.length(); i++){
                char check = text.charAt(i);
                if(check=='f'){
                    if(text.charAt(i+1)=='o'){
                        if(text.charAt(i+2)=='r'){
                            if(text.charAt(i+3)=='('){
                                stack.push(enumBlockType.FOR);
                            }
                        }
                    }
                //parenthesis that isn't part of loop
                }if(check=='('){
                    stack.push(enumBlockType.PAREN);
                    //text=text.substring(0, i)+ "\n" + text.substring(i+1, text.length());
                }if(check=='{'){
                    stack.push(enumBlockType.BRACE);
                    indentLevel++;
                    //text=text.substring(0, i)+ "\n" + text.substring(i+1, text.length());
                }if(check==')'){
                    //stack.pop();
                    if(stack.peek()==enumBlockType.PAREN){
                        stack.pop();
                    }else{
                        i=text.length();
                        return "\n//Missing closing parenthese found";
                    }
                }if(check=='}'){
                    //stack.pop();
                    if(stack.peek()==enumBlockType.BRACE){
                        stack.pop();
                    }else{
                        i=text.length();
                        return "\n//Missing closing bracing found";
                    }

                    indentLevel--;
                    text=text.substring(0, i)+ "\n" + text.substring(i+1, text.length());
                }
                if(check==';'){
                    indentLevel--;
                    text=text.substring(0, i)+ "\n" + text.substring(i+1, text.length());
                }

            }

            return text;
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

   }



}
