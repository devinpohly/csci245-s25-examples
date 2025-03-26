
public class Ostrich extends Bird {

    public String noise() { return "hiss"; }

    @Override
    public String howMoves() { return "runs"; }
    
    public String howMovesWithJetPack() {
        return howMoves() + " and " + super.howMoves(); 
    }
}
