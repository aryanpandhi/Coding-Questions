import java.util.*;

class Trees{

    int Value;
    Trees Left;
    Trees Right;

    Trees(int Value){
        this.Value = Value;
        Left = null;
        Right = null;
    }

    Trees(int Value, Trees Left, Trees Right){
        this.Value = Value;
        this.Left = Left;
        this.Right = Right;
    }

}