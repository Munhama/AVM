import java.sql.SQLOutput;

public class Gays {

    public static Drob Ras(Drob P, Drob a, Drob b, Drob Gla){
        return (P.vichet((a.umnoz(b)).delen(Gla)));
    }
    public static Drob Sokr(Drob A){
        int mn=gcd(A.getChis(),A.getZnam());
        if(mn == 0) return A;
        A.setChis(A.getChis() / mn);
        A.setZnamen(A.getZnam() / mn);
        return A;
    }

    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static void Vivod(){
        for(int e=0; e<n; e++) {
            for (int t = 0; t < m; t++) {
                System.out.print(M[e][t].getChis() + "/" + M[e][t].getZnam() + " ");
            }
            System.out.println();
        }
    }

    public static void Otvet(){
        boolean ch=true;
        boolean che=true;
        int cho=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m-1 & che==true & ch==true; j++){
                if(M[i][i].getChis()==1 & M[i][i].getZnam()==1);
                else ch=false;
                if(i!=j & M[i][j].getChis()==0);
                else che=false;
            }
            if(ch==false | che==false) break;
        }

        if(ch==true & che==true){
            System.out.println();
            ChorOtv();
        }
        else{
            for(int i=0; i<n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if(M[i][j].getChis()==0){
                        cho++;
                    }
                }
                if(cho==m-1 & M[i][m-1].getChis()!=0){
                    System.out.println("Result is not!");
                    return;
                }
                else cho=0;
            }

            System.out.println();
            NeChorOtv();
        }
    }

    public static void ChorOtv(){
        for(int i=0; i<n; i++) {
            System.out.println("X" + (i+1) + " = " + M[i][m-1].getChis() + "/" + M[i][m-1].getZnam());
        }
    }

    public static void NeChorOtv(){
        boolean ch;
        for(int i=0; i<n; i++) {
            ch=true;
            for(int j=0; j<m-1 & ch==true; j++){
                if(M[i][j].getChis()==1 & M[i][j].getZnam()==1) {
                    System.out.print("X" + (j+1) + " = " + M[i][m-1].getChis() + "/" + M[i][m-1].getZnam());
                    for (int z = j; z < m - 1; z++) {
                        if(M[i][z].getChis()!=0 & z!=j){
                            System.out.print(" - " + M[i][z].getChis() + "/" + M[i][z].getZnam() + " * " + "X" + (z+1));
                            ch=false;
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public static void Glav(){
        Drob GlavEl = new Drob();
        int GlavT = 0;
        int GlavE = 0;
        boolean check = false;

        for(int e=0; e<n; e++){
            for(int t=0; t<m-1 & !check; t++){
                if(M[e][t].getChis()!=0){
                    GlavEl.setChis(M[e][t].getChis());
                    GlavEl.setZnamen(M[e][t].getZnam());
                    GlavE = e;
                    GlavT = t;
                    check = true;
                    System.out.println(GlavEl.getChis() + "/" + GlavEl.getZnam());
                }
            }
            if(check==false) continue;
            Nulling(GlavE, GlavT, GlavEl);
            Podsc(GlavE, GlavT, GlavEl);
            Zap();

            Vivod();

            check = false;
        }
        Otvet();
    }

    public static void Nulling(int e, int t, Drob El){
        for(int i=0; i<n; i++){
            if(i!=e){
                Pred[i][t].setChis(0);
                Pred[i][t].setZnamen(0);
            }
        }

        for(int i=0; i<m; i++){
            Pred[e][i] = Pred[e][i].delen(El);
            Pred[e][i] = Sokr(Pred[e][i]);
        }
    }

    public static void Podsc(int e, int t, Drob El){
        for(int i=0; i<n; i++){
            if(i==e) continue;
            for(int j=0; j<m; j++){
                if(j>t) {
                    Pred[i][j] = Ras(M[i][j], M[e][j], M[i][t], El);
                    Pred[i][j] = Sokr(Pred[i][j]);
                }
            }
        }
    }

    public static void Zap(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(Pred[i][j].getChis()==0){
                    Pred[i][j].setZnamen(0);
                }
                M[i][j].setChis(Pred[i][j].getChis());
                M[i][j].setZnamen(Pred[i][j].getZnam());
            }
        }
    }

    static int n = 5, m =6; //m-столбец!!!
    static Drob[][] M = new Drob[n][m];
    static Drob[][] Pred = new Drob[n][m];

    public static void main(String[] args) {
        Drob a = new Drob();

        int[][] Matrix = {
                /*laba 8*/     {5,16,12,11,-7,62},
                {17,12,1,18,9,298},
                {15,-15,3,1,-7,-127},
                {-14,-13,-7,-5,-11,-190},
                {-1,13,-16,-6,8,152}
/* Otvet {1,5,-4,8,9}*/
                /*3 dz*/        /*{1,4,0,-1,5},
                {2,-3,1,1,3},
                {1,0,2,-1,3},
                {0,2,-3,2,3}*/

                /*4 dz*/       /*{2,-1,1,2,3,2},
                {6,-3,2,4,5,3},
                {6,-3,4,8,13,9},
                {4,-2,1,1,2,1}*/

                /*1 dz*/       /*{3,2,5,4,3},
                {1,-1,-1,-4,-2},
                {4,1,4,0,2}*/

                /*2 dz*/        /*{4,-3,-2,1,-2},
                {3,-1,-2,0,1},
                {2,1,-2,-1,4}*/

                /*{1,2,0,0,1},
                {0,-1,0,1,4},
                {0,3,-1,-2,2}*/

        };

        for(int e=0; e<n; e++) {
            for(int t=0; t<m; t++) {
                M[e][t]=new Drob();
                Pred[e][t]=new Drob();
                a.setChis(Matrix[e][t]);
                a.setZnamen(1);
                M[e][t].setChis(a.getChis());
                M[e][t].setZnamen(a.getZnam());
                Pred[e][t].setChis(a.getChis());
                Pred[e][t].setZnamen(a.getZnam());
                System.out.print(M[e][t].getChis() + "/" + M[e][t].getZnam() + " ");
            }
            System.out.println();
        }
        System.out.println();

        Glav();
    }
}
