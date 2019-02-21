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
                    System.out.println("e= " + GlavE + " t= " + GlavT);
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
                /*laba 9*/     {8,2,-8,-10,-3,142},
                {6,-1,11,4,11,-55},
                {13,-9,4,3,10,-49},
                {-9,4,14,15,13,-213},
                {9,6,8,4,-7,152}

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
