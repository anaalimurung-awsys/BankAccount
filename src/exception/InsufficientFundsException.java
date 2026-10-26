package exception;

public class InsufficientFundsException extends Exception {
   private String message;

   public InsufficientFundsException (String message){
      super(message);
      this.message = message;
   }   

   public String getString(){
      return this.message;
   }
}
