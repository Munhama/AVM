public class Drob {
    private int chislitel;
    private int znamienatel;

    public Drob(){

    }

    void setChis(int ch){
        chislitel = ch;
    }
    void setZnamen(int zn){
        znamienatel = zn;
    }
    int getChis(){
        return chislitel;
    }
    int getZnam(){
        return znamienatel;
    }


    public Drob umnoz(Drob d1){
        Drob result = new Drob();
        result.setChis(d1.getChis()*chislitel);
        result.setZnamen(d1.getZnam()*znamienatel);
        return result;
    }

    public Drob delen(Drob d1){
        Drob result = new Drob();
        result.setChis(d1.getZnam()*chislitel);
        result.setZnamen(d1.getChis()*znamienatel);
        return result;
    }

    public Drob vichet(Drob d1){
        Drob result = new Drob();
        result.setChis(chislitel*d1.getZnam() - d1.getChis()*znamienatel);
        result.setZnamen(d1.getZnam()*znamienatel);
        return result;
    }
}
