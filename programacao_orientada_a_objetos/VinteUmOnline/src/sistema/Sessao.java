
package sistema;
import VinteUmOnline.*;

public class Sessao{  
   private static Sessao instance = null;  
   private int ID;
  
   private Sessao(){  
   }  
  
   public void setID(int ID){  
      this.ID = ID;  
   }  
  
   public int getID(){  
       return ID;  
   }  
   public static Sessao getInstance(){  
         if(instance == null){  
               instance = new Sessao();  
         }  
        return instance;  
   }  
} 