public class Drob {
    private long chislitel;
    private long znamienatel;

    public Drob(){

    }

    void setChis(long ch){
        chislitel = ch;
    }
    void setZnamen(long zn){
        znamienatel = zn;
    }
    long getChis(){
        return chislitel;
    }
    long getZnam(){
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
        if(chislitel==0) {
            result.setChis(-1*d1.getChis());
            result.setZnamen(d1.getZnam());
            return result;
        }
        if(d1.getChis()==0){
            result.setChis(chislitel);
            result.setZnamen(znamienatel);
            return result;
        }
        result.setChis(chislitel*d1.getZnam() - d1.getChis()*znamienatel);
        result.setZnamen(d1.getZnam()*znamienatel);
        return result;
    }
}
