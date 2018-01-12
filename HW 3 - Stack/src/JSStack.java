/**
 * Created by Richu on 10/9/2016.
 */
import java.util.ArrayList;
import java.util.EmptyStackException;

public class JSStack extends ArrayList {


    public JSStack(){
        super();
    }

    public void push(enumBlockType b){

        super.add(b);
    }

    public enumBlockType pop()throws  EmptyStackException{
        if(super.isEmpty()){
            throw new EmptyStackException();
        }else{
            enumBlockType temp;
            temp = (enumBlockType) super.remove(super.size()-1);
            return temp;
        }
    }

    public enumBlockType peek(){
        return (enumBlockType) super.get(super.size()-1);
    }

    public boolean isEmpty(){
        if(super.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
}
