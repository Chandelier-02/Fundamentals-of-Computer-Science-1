import java.text.DecimalFormat;

/**
Represents a type of direct marketing campagin along with 
the marketing campaign values and methods.
@author Chandler Dykes
@version 04/01/2021
Project 09
*/
public class DirectMC extends MarketingCampaign
{
   private double costPerMailPiece;
   private int numberOfMailPieces;
   
   /**Base cost of the campaign.*/
   public static final double BASE_COST = 1000.00;
   
   /**
   Constructor for the marketing campaign. Sets initial values.
   @param nameIn name of campaign
   @param revenueIn revenue campaign generated
   @param costPerMailPieceIn cost per mail piece
   @param numberOfMailPiecesIn number of mail pieces
   */
   public DirectMC(String nameIn, double revenueIn, 
      double costPerMailPieceIn, int numberOfMailPiecesIn)
   {
      super(nameIn, revenueIn);
      costPerMailPiece = costPerMailPieceIn;
      numberOfMailPieces = numberOfMailPiecesIn;
   }
    
    /**
    Gets the cost per mail piece.
    @return cost per mail piece.
    */  
   public double getCostPerMailPiece()
   {
      return costPerMailPiece;
   }
   
    /**
    Sets the cost per mail piece.
    @param costPerMailPieceIn cost per mail piece
    */
   public void setCostPerMailPiece(double costPerMailPieceIn)
   {
      costPerMailPiece = costPerMailPieceIn;
   }
   
    /**
    Gets the number of mail pieces.
    @return number of mail pieces
    */
   public int getNumberOfMailPieces()
   {
      return numberOfMailPieces;
   }
   
    /**
    Sets the number of mail pieces.
    @param numberOfMailPiecesIn number of mail pieces
    */
   public void setNumberOfMailPieces(int numberOfMailPiecesIn)
   {
      numberOfMailPieces = numberOfMailPiecesIn;
   }
   
    /**
    Generates the cost of the campaign.
    @return cost of campaign
    */
   public double campaignCost()
   {
      return BASE_COST + (costPerMailPiece * numberOfMailPieces);
   }
   
    /**
    Formats the DirectMC output.
    @return output formatted output
    */
   public String toString()
   {
      double mailCost = costPerMailPiece * numberOfMailPieces;
      DecimalFormat monetary = new DecimalFormat("$#,##0.00");
      String output = "";
      output += super.toString();
      output += "\n   Base Cost: " + monetary.format(BASE_COST)
             + "\n   Mail Cost: " + monetary.format(mailCost)
             + " = " + monetary.format(costPerMailPiece)
             + " per mail piece * " + numberOfMailPieces + " mail pieces";
      return output;
   }
}