public class  check_Index  {
    int index_check(int index,int length){
        if(index<0 || index>length){
            throw new RuntimeException("Out of length: "+length + ", Index: "+index);
        }
        else
            return index;
    }
}
